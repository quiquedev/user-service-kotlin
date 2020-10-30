package info.quiquedev.userservice.usecase.domain

import info.quiquedev.userservice.UserConstraints.EmailsMax
import info.quiquedev.userservice.UserConstraints.EmailsMin
import info.quiquedev.userservice.UserConstraints.FirstNameMaxLength
import info.quiquedev.userservice.UserConstraints.FirstNameMinLength
import info.quiquedev.userservice.UserConstraints.LastNameMaxLength
import info.quiquedev.userservice.UserConstraints.LastNameMinLength
import info.quiquedev.userservice.UserConstraints.PhoneNumbersMax
import info.quiquedev.userservice.UserConstraints.PhoneNumbersMin
import info.quiquedev.userservice.usecase.Utils.randomId
import org.hibernate.validator.constraints.Length
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany
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

        @OneToMany(
                cascade = [CascadeType.ALL],
                orphanRemoval = true
        )
        @Min(EmailsMin)
        @Max(EmailsMax)
        val mail: List<Mail> = emptyList(),

        @OneToMany(
                cascade = [CascadeType.ALL],
                orphanRemoval = true
        )
        @Min(PhoneNumbersMin)
        @Max(PhoneNumbersMax)
        val numbers: List<PhoneNumber> = emptyList()
)