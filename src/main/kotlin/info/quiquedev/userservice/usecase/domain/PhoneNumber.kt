package info.quiquedev.userservice.usecase.domain

import info.quiquedev.userservice.UserConstraints.MailMaxLength
import info.quiquedev.userservice.UserConstraints.MailMinLength
import info.quiquedev.userservice.UserConstraints.NumberMaxLength
import info.quiquedev.userservice.UserConstraints.NumberMinLength
import info.quiquedev.userservice.usecase.Utils.randomId
import org.hibernate.validator.constraints.Length
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.validation.constraints.Email

@Entity(name = "numbers")
data class PhoneNumber(
        @Id
        @Column(name = "number_id")
        val id: String = randomId(),

        @ManyToOne
        @JoinColumn(name = "user_id")
        val user: User,

        @field:Length(min = NumberMinLength, max = NumberMaxLength)
        val value: String
)
