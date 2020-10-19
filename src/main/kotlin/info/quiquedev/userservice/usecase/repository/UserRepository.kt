package info.quiquedev.userservice.usecase.repository

import info.quiquedev.userservice.usecase.domain.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, String> {
    fun findByFirstNameIgnoreCaseAndLastNameIgnoreCase(firstName: String, lastName: String): User?
}