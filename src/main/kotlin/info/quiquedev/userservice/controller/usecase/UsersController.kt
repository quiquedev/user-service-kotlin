package info.quiquedev.userservice.controller.usecase

import info.quiquedev.userservice.controller.dto.UserConstraints.FirstNameMaxLength
import info.quiquedev.userservice.controller.dto.UserConstraints.FirstNameMinLength
import info.quiquedev.userservice.controller.dto.UserConstraints.LastNameMaxLength
import info.quiquedev.userservice.controller.dto.UserConstraints.LastNameMinLength
import info.quiquedev.userservice.controller.dto.request.NewUserDto
import info.quiquedev.userservice.controller.dto.response.UserDto
import org.hibernate.validator.constraints.Length
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/users")
class UsersController {

    @PostMapping
    fun createUser(@Valid @RequestBody newUser: NewUserDto): UserDto = TODO()


    @GetMapping
    fun findUserByFirstAndLastName(
            @Valid @Length(min = FirstNameMinLength, max = FirstNameMaxLength) @RequestParam("firstName")
            firstName: String,
            @Valid @Length(min = LastNameMinLength, max = LastNameMaxLength) @RequestParam("lastName")
            lastName: String
    ): UserDto = TODO()
}
