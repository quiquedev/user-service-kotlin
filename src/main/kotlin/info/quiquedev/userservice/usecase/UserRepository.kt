package info.quiquedev.userservice.usecase

import info.quiquedev.userservice.usecase.domain.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, String> {
    fun findByFirstNameCaseIgnoreCaseAndLastNameIgnoreCase(firstName: String, lastName: String): User?
}