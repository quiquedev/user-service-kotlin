package info.quiquedev.userservice.usecase.domain

import info.quiquedev.userservice.UserConstraints.EmailsMax
import info.quiquedev.userservice.UserConstraints.EmailsMin
import info.quiquedev.userservice.UserConstraints.FirstNameMaxLength
import info.quiquedev.userservice.UserConstraints.FirstNameMinLength
import info.quiquedev.userservice.UserConstraints.LastNameMaxLength
import info.quiquedev.userservice.UserConstraints.LastNameMinLength
import info.quiquedev.userservice.UserConstraints.MailMaxLength
import info.quiquedev.userservice.UserConstraints.MailMinLength
import info.quiquedev.userservice.UserConstraints.NumberMaxLength
import info.quiquedev.userservice.UserConstraints.NumberMinLength
import info.quiquedev.userservice.UserConstraints.PhoneNumbersMax
import info.quiquedev.userservice.UserConstraints.PhoneNumbersMin
import info.quiquedev.userservice.usecase.domain.Converters.randomId
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Type
import org.hibernate.validator.constraints.Length
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.Valid
import javax.validation.constraints.Email
import javax.validation.constraints.Max
import javax.validation.constraints.Min

@Entity(name = "users")
data class User(
        @Id
        val id: String = randomId(),

        @Column(name = "first_name")
        @Length(min = FirstNameMinLength, max = FirstNameMaxLength)
        val firstName: String,

        @Column(name = "last_name")
        @Length(min = LastNameMinLength, max = LastNameMaxLength)
        val lastName: String,

        @Type(type = "jsonb")
        @Column(columnDefinition = "jsonb")
        @Min(EmailsMin)
        @Max(EmailsMax)
        val emails: List<@Valid Mail>,

        @Type(type = "jsonb")
        @Column(name = "phone_numbers", columnDefinition = "jsonb")
        @Min(PhoneNumbersMin)
        @Max(PhoneNumbersMax)
        val phoneNumbers: List<@Valid Number>
) {
    class Mail(
            val id: String = randomId(),
            @field:Length(min = MailMinLength, max = MailMaxLength)
            @field:Email
            val value: String
    )

    class Number(
            val id: String = randomId(),
            @field:Length(min = NumberMinLength, max = NumberMaxLength)
            val value: String
    )
}