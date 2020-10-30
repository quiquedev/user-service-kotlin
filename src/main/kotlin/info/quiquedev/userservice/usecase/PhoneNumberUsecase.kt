package info.quiquedev.userservice.usecase

import info.quiquedev.userservice.controller.dto.request.MailModificationDto
import info.quiquedev.userservice.controller.dto.request.NewMailDto
import info.quiquedev.userservice.controller.dto.response.UserDto
import info.quiquedev.userservice.controller.dto.response.toDto
import info.quiquedev.userservice.usecase.domain.Mail
import info.quiquedev.userservice.usecase.repository.PhoneNumberRepository
import info.quiquedev.userservice.usecase.repository.UserRepository
import org.springframework.stereotype.Component
import javax.transaction.Transactional

@Component
class PhoneNumberUsecase(
        private val userRepository: UserRepository,
        private val phoneNumberRepository: PhoneNumberRepository
) {
    companion object {
        abstract class PhoneNumberUsecaseException(msg: String, t: Throwable? = null) : Exception(msg, t)
        class UserNotFoundException(userId: String) : PhoneNumberUsecaseException("User '$userId' not found")
        class PhoneNumberNotFoundException(userId: String, phoneNumberId: String) : PhoneNumberUsecaseException("'$phoneNumberId' not found for '$userId'")
        class PhoneNumberAlreadyPresentException(userId: String, mail: String) :
                PhoneNumberUsecaseException("User '$userId' has already the mail '$mail'")
    }

    @Throws(PhoneNumberUsecaseException::class)
    @Transactional
    fun addMailToUser(userId: String, newMailDto: NewMailDto): UserDto =
            userRepository.findById(userId).orElse(null)?.let { user ->
                val existingMail = user.mail.find { it.value.toLowerCase() == newMailDto.value.toLowerCase() }

                if (existingMail != null) throw PhoneNumberAlreadyPresentException(userId, newMailDto.value)
                else mailRepository.save(Mail(user = user, value = newMailDto.value)).user.toDto()
            } ?: throw UserNotFoundException(userId)

    @Throws(UserNotFoundException::class,
            PhoneNumberNotFoundException::class)
    @Transactional
    fun modifyMailFromUser(userId: String, mailId: String, mailModificationDto: MailModificationDto): UserDto =
            userRepository.findById(userId).orElse(null)?.let { user ->
                user.mail.find { it.id == mailId }?.let { mail ->
                    mail.value = mailModificationDto.value
                    user.toDto()
                } ?: throw PhoneNumberNotFoundException(userId, mailId)
            } ?: throw UserNotFoundException(userId)

    @Throws(UserNotFoundException::class,
            PhoneNumberNotFoundException::class)
    @Transactional
    fun deleteMailFromUser(userId: String, mailId: String, mailModificationDto: MailModificationDto): UserDto =
            userRepository.findById(userId).orElse(null)?.let { user ->
                user.mail.find { it.id == mailId }?.let { mail ->
                    mailRepository.deleteById(mailId)
                    user.copy(mail = user.mail.filter { it.id == mailId }).toDto()
                } ?: throw PhoneNumberNotFoundException(userId, mailId)
            } ?: throw UserNotFoundException(userId)
}