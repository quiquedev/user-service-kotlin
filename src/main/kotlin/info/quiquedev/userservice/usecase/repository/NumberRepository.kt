package info.quiquedev.userservice.usecase.repository

import info.quiquedev.userservice.usecase.domain.Number
import org.springframework.data.repository.CrudRepository

interface NumberRepository : CrudRepository<Number, String>