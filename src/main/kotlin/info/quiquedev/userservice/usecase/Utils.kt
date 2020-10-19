package info.quiquedev.userservice.usecase

import info.quiquedev.userservice.controller.dto.response.UserDto
import info.quiquedev.userservice.usecase.domain.User
import java.util.*

object Utils {
    fun randomId(): String = UUID.randomUUID().toString()

    fun User.toDto(): UserDto = UserDto(
            id = this.id,
            firstName = this.firstName,
            lastName = this.lastName,
            emails = this.mail.map { UserDto.MailDto(it.id, it.value) },
            phoneNumbers = this.numbers.map { UserDto.NumberDto(it.id, it.value) }
    )
}