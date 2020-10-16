package info.quiquedev.userservice.controller.usecase

import info.quiquedev.userservice.controller.dto.UserConstraints.FirstNameMaxLength
import info.quiquedev.userservice.controller.dto.UserConstraints.FirstNameMinLength
import info.quiquedev.userservice.controller.dto.UserConstraints.LastNameMaxLength
import info.quiquedev.userservice.controller.dto.UserConstraints.LastNameMinLength
import info.quiquedev.userservice.controller.dto.request.MailDto
import info.quiquedev.userservice.controller.dto.request.NewUserDto
import info.quiquedev.userservice.controller.dto.request.NumberDto
import info.quiquedev.userservice.controller.dto.response.UserDto
import org.hibernate.validator.constraints.Length
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
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

    @GetMapping("/{userId}")
    fun getUserById(@PathVariable("userId") userId: String): UserDto = TODO()

    @DeleteMapping("/{userId}")
    fun deleteUserById(@PathVariable("userId") userId: String): Unit = TODO()

    @PostMapping("/{userId}/mails")
    fun addEmailToUser(
            @PathVariable("userId") userId: String,
            @Valid @RequestBody mail: MailDto
    ): Unit = TODO()

    @PutMapping("/{userId}/mails/{mailId}")
    fun modifyEmailFromUser(
            @PathVariable("userId") userId: String,
            @PathVariable("mailId") mailId: String,
            @Valid @RequestBody mail: MailDto
    ): UserDto = TODO()

    @DeleteMapping("/{userId}/mails/{mailId}")
    fun deleteEmailFromUser(
            @PathVariable("userId") userId: String,
            @PathVariable("mailId") mailId: String
    ): UserDto = TODO()

    @PostMapping("/{userId}/numbers")
    fun addNumberToUser(
            @PathVariable("userId") userId: String,
            @Valid @RequestBody number: NumberDto
    ): Unit = TODO()

    @PutMapping("/{userId}/numbers/{numberId}")
    fun modifyNumberFromUser(
            @PathVariable("userId") userId: String,
            @PathVariable("numberId") numberId: String,
            @Valid @RequestBody mail: NumberDto
    ): UserDto = TODO()

    @DeleteMapping("/{userId}/numbers/{numberId}")
    fun deleteNumberFromUser(
            @PathVariable("userId") userId: String,
            @PathVariable("numberId") numberId: String
    ): UserDto = TODO()
}
