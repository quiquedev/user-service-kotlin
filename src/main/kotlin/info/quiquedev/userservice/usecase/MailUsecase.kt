package info.quiquedev.userservice.usecase

import info.quiquedev.userservice.controller.dto.request.NewMailDto
import info.quiquedev.userservice.usecase.domain.Mail
import info.quiquedev.userservice.usecase.domain.User
import info.quiquedev.userservice.usecase.repository.MailRepository
import org.springframework.stereotype.Component
import javax.transaction.Transactional

@Component
class MailUsecase(
        private val mailRepository: MailRepository
) {
    companion object {
        abstract class MailUsecaseException(msg: String, t: Throwable? = null) : Exception(msg, t)
        class UserNotFoundException(userId: String) : MailUsecaseException("User '$userId' not found")
        class MailAlreadyPresentException(userId: String, mail: String) :
                MailUsecaseException("User '$userId' has already the mail '$mail'")
    }

    @Throws(MailUsecaseException::class)
    @Transactional
    fun addMailToUser(userId: String, newMailDto: NewMailDto): User =
            mailRepository.findByUserId(userId)?.user?.let { user ->
                val existingMail = user.mail.find { it.value.toLowerCase() == newMailDto.value.toLowerCase() }

                if (existingMail != null) throw MailAlreadyPresentException(userId, newMailDto.value)
                else mailRepository.save(Mail(user = user, value = newMailDto.value)).user
            } ?: throw UserNotFoundException(userId)

}