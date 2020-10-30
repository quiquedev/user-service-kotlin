package info.quiquedev.userservice.usecase.domain

import info.quiquedev.userservice.UserConstraints.MailMaxLength
import info.quiquedev.userservice.UserConstraints.MailMinLength
import info.quiquedev.userservice.usecase.Utils.randomId
import org.hibernate.validator.constraints.Length
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.validation.constraints.Email

@Entity(name = "mails")
data class Mail(
        @Id
        @Column(name = "mail_id")
        val id: String = randomId(),

        @ManyToOne
        @JoinColumn(name = "user_id")
        val user: User,

        @field:Length(min = MailMinLength, max = MailMaxLength)
        var value: String
)
