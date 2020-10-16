package info.quiquedev.userservice.controller.dto.request

import info.quiquedev.userservice.controller.dto.UserConstraints.MailMaxLength
import info.quiquedev.userservice.controller.dto.UserConstraints.MailMinLength
import org.hibernate.validator.constraints.Length

class MailModificationDto(
        @field:Length(min = MailMinLength, max = MailMaxLength)
        var value: String
)