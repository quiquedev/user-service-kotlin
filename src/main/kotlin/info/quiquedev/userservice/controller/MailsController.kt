package info.quiquedev.userservice.controller

import info.quiquedev.userservice.controller.dto.request.MailModificationDto
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
@RequestMapping("/users/{userId}/mails")
class MailsController {

    @PostMapping
    fun addEmailToUser(
            @PathVariable("userId") userId: String,
            @Valid @RequestBody mailModification: MailModificationDto
    ): Unit = TODO()

    @PutMapping("/{mailId}")
    fun modifyEmailFromUser(
            @PathVariable("userId") userId: String,
            @PathVariable("mailId") mailId: String,
            @Valid @RequestBody mailModification: MailModificationDto
    ): UserDto = TODO()

    @DeleteMapping("/{mailId}")
    fun deleteEmailFromUser(
            @PathVariable("userId") userId: String,
            @PathVariable("mailId") mailId: String
    ): UserDto = TODO()
}
