package info.quiquedev.userservice.controller.dto.response

import info.quiquedev.userservice.usecase.domain.User

data class UserDto(
        val id: String,
        val lastName: String,
        val firstName: String,
        val emails: List<MailDto>,
        val phoneNumbers: List<NumberDto>
) {
    data class MailDto(val id: String, val mail: String)
    data class NumberDto(val id: String, val mail: String)
}

fun User.toDto(): UserDto = UserDto(
        id = this.id,
        lastName = this.lastName,
        firstName = this.firstName,
        emails = this.mail.map { UserDto.MailDto(it.id, it.value) },
        phoneNumbers = this.numbers.map { UserDto.NumberDto(it.id, it.value) }
)