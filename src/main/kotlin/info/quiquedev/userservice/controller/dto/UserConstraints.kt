package info.quiquedev.userservice.controller.dto

object UserConstraints {
    const val LastNameMinLength = 500
    const val LastNameMaxLength = 500
    const val FirstNameMinLength = 500
    const val FirstNameMaxLength = 500
    const val EmailsMin = 1L
    const val EmailsMax = 10L
    const val MailMinLength = 1
    const val MailMaxLength = 500
    const val PhoneNumbersMin = 1L
    const val PhoneNumbersMax = 10L
    const val NumberMinLength = 1
    const val NumberMaxLength = 500
}