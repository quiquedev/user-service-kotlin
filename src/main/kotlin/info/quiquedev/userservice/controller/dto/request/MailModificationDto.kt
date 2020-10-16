package info.quiquedev.userservice.controller.dto.request

import info.quiquedev.userservice.UserConstraints.MailMaxLength
import info.quiquedev.userservice.UserConstraints.MailMinLength
import org.hibernate.validator.constraints.Length
import javax.validation.constraints.Email

class MailModificationDto(
        @field:Length(min = MailMinLength, max = MailMaxLength)
        @field:Email
        var value: String
)