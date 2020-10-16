package info.quiquedev.userservice.controller

import info.quiquedev.userservice.UserConstraints.FirstNameMaxLength
import info.quiquedev.userservice.UserConstraints.FirstNameMinLength
import info.quiquedev.userservice.UserConstraints.LastNameMaxLength
import info.quiquedev.userservice.UserConstraints.LastNameMinLength
import info.quiquedev.userservice.controller.dto.request.NewUserDto
import info.quiquedev.userservice.controller.dto.response.UserDto
import info.quiquedev.userservice.usecase.UserUsecase
import org.hibernate.validator.constraints.Length
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/users")
class UsersController(
        private val userUsecase: UserUsecase
) {

    @PostMapping
    fun createUser(@Valid @RequestBody newUser: NewUserDto): UserDto = userUsecase.createUser(newUser)

    @GetMapping
    fun getUserByFirstAndLastName(
            @Valid @Length(min = FirstNameMinLength, max = FirstNameMaxLength) @RequestParam("firstName")
            firstName: String,
            @Valid @Length(min = LastNameMinLength, max = LastNameMaxLength) @RequestParam("lastName")
            lastName: String
    ): UserDto? = userUsecase.findUserByFirstNameAndLastName(firstName, lastName)

    @GetMapping("/{userId}")
    fun getUserById(@PathVariable("userId") userId: String): UserDto? = userUsecase.findUserById(userId)

    @DeleteMapping("/{userId}")
    fun deleteUserById(@PathVariable("userId") userId: String): Unit? = userUsecase.deleteUserById(userId)
}
