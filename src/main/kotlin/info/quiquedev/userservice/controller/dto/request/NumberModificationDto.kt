package info.quiquedev.userservice.controller.dto.request

import info.quiquedev.userservice.UserConstraints.NumberMaxLength
import info.quiquedev.userservice.UserConstraints.NumberMinLength
import org.hibernate.validator.constraints.Length

class NumberModificationDto(
        @field:Length(min = NumberMinLength, max = NumberMaxLength)
        var value: String
)