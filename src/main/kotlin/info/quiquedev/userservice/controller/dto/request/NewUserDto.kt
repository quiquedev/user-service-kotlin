package info.quiquedev.userservice.controller.dto.request

import info.quiquedev.userservice.UserConstraints.EmailsMax
import info.quiquedev.userservice.UserConstraints.EmailsMin
import info.quiquedev.userservice.UserConstraints.FirstNameMaxLength
import info.quiquedev.userservice.UserConstraints.FirstNameMinLength
import info.quiquedev.userservice.UserConstraints.LastNameMaxLength
import info.quiquedev.userservice.UserConstraints.LastNameMinLength
import info.quiquedev.userservice.UserConstraints.MailMaxLength
import info.quiquedev.userservice.UserConstraints.MailMinLength
import info.quiquedev.userservice.UserConstraints.NumberMaxLength
import info.quiquedev.userservice.UserConstraints.NumberMinLength
import info.quiquedev.userservice.UserConstraints.PhoneNumbersMax
import info.quiquedev.userservice.UserConstraints.PhoneNumbersMin
import org.hibernate.validator.constraints.Length
import javax.validation.constraints.Email
import javax.validation.constraints.Max
import javax.validation.constraints.Min

class NewUserDto(
        @field:Length(min = LastNameMinLength, max = LastNameMaxLength)
        var lastName: String,
        @field:Length(min = FirstNameMinLength, max = FirstNameMaxLength)
        var firstName: String,
        @field:Min(EmailsMin)
        @field:Max(EmailsMax)
        var emails: List<@Length(min = MailMinLength, max = MailMaxLength) @Email String>,
        @field:Min(PhoneNumbersMin)
        @field:Max(PhoneNumbersMax)
        var phoneNumbers: List<@Length(min = NumberMinLength, max = NumberMaxLength) String>
)