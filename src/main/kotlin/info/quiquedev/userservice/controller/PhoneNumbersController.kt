package info.quiquedev.userservice.controller

import info.quiquedev.userservice.controller.dto.request.PhoneNumberModificationDto
import info.quiquedev.userservice.controller.dto.response.UserDto
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/users/{userId}/numbers")
class PhoneNumbersController {

    @PostMapping
    fun addNumberToUser(
            @PathVariable("userId") userId: String,
            @Valid @RequestBody phoneNumberModificationDto: PhoneNumberModificationDto
    ): UserDto = TODO()

    @PutMapping("/{numberId}")
    fun modifyNumberFromUser(
            @PathVariable("userId") userId: String,
            @PathVariable("numberId") numberId: String,
            @Valid @RequestBody phoneNumberModification: PhoneNumberModificationDto
    ): UserDto = TODO()

    @DeleteMapping("/{numberId}")
    fun deleteNumberFromUser(
            @PathVariable("userId") userId: String,
            @PathVariable("numberId") numberId: String
    ): UserDto = TODO()
}
