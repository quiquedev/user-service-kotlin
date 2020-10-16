package info.quiquedev.userservice.usecase

import info.quiquedev.userservice.controller.dto.request.NewUserDto
import info.quiquedev.userservice.controller.dto.response.UserDto
import info.quiquedev.userservice.usecase.domain.Converters.toDomain
import info.quiquedev.userservice.usecase.domain.Converters.toDto
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Component

@Component
class UsersUsecase(
        private val userRepository: UserRepository
) {
    companion object {
        class UsersUsecaseException(t: Throwable) : Exception(t)
    }

    @Throws(UsersUsecaseException::class)
    fun createUser(newUserDto: NewUserDto): UserDto =
            try {
                userRepository.save(newUserDto.toDomain()).toDto()
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
        userRepository.findByFirstNameCaseIgnoreCaseAndLastNameIgnoreCase(firstName, lastName)?.toDto()
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