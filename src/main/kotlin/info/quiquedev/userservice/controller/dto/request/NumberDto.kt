package info.quiquedev.userservice.controller.dto.request

import info.quiquedev.userservice.controller.dto.UserConstraints.NumberMaxLength
import info.quiquedev.userservice.controller.dto.UserConstraints.NumberMinLength
import org.hibernate.validator.constraints.Length

class NumberDto(
        @field:Length(min = NumberMinLength, max = NumberMaxLength)
        var value: String
)