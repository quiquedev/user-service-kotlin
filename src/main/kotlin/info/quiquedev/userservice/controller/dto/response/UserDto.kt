package info.quiquedev.userservice.controller.dto.response

data class UserDto(
        val id: String,
        val lastName: String,
        val firstName: String,
        val emails: List<Email>,
        val phoneNumbers: List<PhoneNumber>
) {
    data class Email(val id: String, val mail: String)
    data class PhoneNumber(val id: String, val mail: String)
}