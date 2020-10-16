package info.quiquedev.userservice.usecase.repository

import info.quiquedev.userservice.usecase.domain.PhoneNumber
import org.springframework.data.repository.CrudRepository

interface PhoneNumberRepository : CrudRepository<PhoneNumber, String>