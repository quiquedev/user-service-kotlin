package info.quiquedev.userservice.usecase

import info.quiquedev.userservice.controller.dto.request.NewUserDto
import info.quiquedev.userservice.controller.dto.response.UserDto
import info.quiquedev.userservice.usecase.Utils.toDto
import info.quiquedev.userservice.usecase.domain.Email
import info.quiquedev.userservice.usecase.domain.PhoneNumber
import info.quiquedev.userservice.usecase.domain.User
import info.quiquedev.userservice.usecase.repository.EmailRepository
import info.quiquedev.userservice.usecase.repository.PhoneNumberRepository
import info.quiquedev.userservice.usecase.repository.UserRepository
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Component
import javax.transaction.Transactional

@Component
class UserUsecase(
        private val userRepository: UserRepository,
        private val emailRepository: EmailRepository,
        private val phoneNumberRepository: PhoneNumberRepository
) {
    companion object {
        class UsersUsecaseException(t: Throwable) : Exception(t)
    }

    @Throws(UsersUsecaseException::class)
    @Transactional
    fun createUser(newUserDto: NewUserDto): UserDto =
            try {
                val user = userRepository.save(User(
                        firstName = newUserDto.firstName,
                        lastName = newUserDto.lastName
                ))

                val emails = emailRepository.saveAll(
                        newUserDto.emails.map { Email(user = user, value = it) }
                )
                val phoneNumbers = phoneNumberRepository.saveAll(
                        newUserDto.phoneNumbers.map { PhoneNumber(user = user, value = it) }
                )

                UserDto(
                        id = user.id,
                        firstName = user.firstName,
                        lastName = user.lastName,
                        emails = emails.map { UserDto.MailDto(it.id, it.value) },
                        phoneNumbers = phoneNumbers.map { UserDto.NumberDto(it.id, it.value) }
                )
            } catch (e: Exception) {
                throw UsersUsecaseException(e)
            }

    fun findUserById(userId: String): UserDto? = try {
        userRepository.findById(userId)
                .map { it.toDto() }
                .orElseGet(null)
    } catch (e: Exception) {
        throw UsersUsecaseException(e)
    }

    fun findUserByFirstNameAndLastName(firstName: String, lastName: String): UserDto? = try {
        userRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCase(firstName, lastName)?.toDto()
    } catch (e: Exception) {
        throw UsersUsecaseException(e)
    }

    fun deleteUserById(userId: String): Unit? = try {
        userRepository.deleteById(userId)
    } catch (e: EmptyResultDataAccessException) {
        null
    } catch (e: Exception) {
        throw UsersUsecaseException(e)
    }
}