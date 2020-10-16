package info.quiquedev.userservice.usecase.domain

import info.quiquedev.userservice.controller.dto.request.NewUserDto
import info.quiquedev.userservice.controller.dto.response.UserDto
import java.util.*


object Converters {
    fun randomId(): String = UUID.randomUUID().toString()

    fun NewUserDto.toDomain(): User = User(
            firstName = this.firstName,
            lastName = this.lastName,
            emails = this.emails.map { User.Mail(value = it) },
            phoneNumbers = this.phoneNumbers.map { User.Number(value = it) }
    )

    fun User.toDto(): UserDto = UserDto(
            id = this.id,
            firstName = this.firstName,
            lastName = this.lastName,
            emails = this.emails.map { UserDto.MailDto(it.id, it.value) },
            phoneNumbers = this.phoneNumbers.map { UserDto.NumberDto(it.id, it.value) }
    )
}