package info.quiquedev.userservice.usecase.repository

import info.quiquedev.userservice.usecase.domain.Email
import org.springframework.data.repository.CrudRepository

interface EmailRepository : CrudRepository<Email, String>