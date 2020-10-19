package info.quiquedev.userservice.usecase

import info.quiquedev.userservice.controller.dto.request.NewUserDto
import info.quiquedev.userservice.controller.dto.response.UserDto
import info.quiquedev.userservice.usecase.Utils.toDto
import info.quiquedev.userservice.usecase.domain.Mail
import info.quiquedev.userservice.usecase.domain.Number
import info.quiquedev.userservice.usecase.domain.User
import info.quiquedev.userservice.usecase.repository.MailRepository
import info.quiquedev.userservice.usecase.repository.NumberRepository
import info.quiquedev.userservice.usecase.repository.UserRepository
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Component
import javax.transaction.Transactional

@Component
class UserUsecase(
        private val userRepository: UserRepository,
        private val mailRepository: MailRepository,
        private val numberRepository: NumberRepository
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

                val emails = mailRepository.saveAll(
                        newUserDto.emails.map { Mail(user = user, value = it) }
                )
                val phoneNumbers = numberRepository.saveAll(
                        newUserDto.phoneNumbers.map { Number(user = user, value = it) }
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