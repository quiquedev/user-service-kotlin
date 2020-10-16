package info.quiquedev.userservice.controller.dto.response

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