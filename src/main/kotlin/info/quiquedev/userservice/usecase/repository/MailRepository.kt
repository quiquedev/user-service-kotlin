package info.quiquedev.userservice.usecase.repository

import info.quiquedev.userservice.usecase.domain.Mail
import org.springframework.data.repository.CrudRepository

interface MailRepository : CrudRepository<Mail, String>