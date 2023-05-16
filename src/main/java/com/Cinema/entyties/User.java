package com.Cinema.entyties;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import com.Cinema.constraints.Unique;
import com.Cinema.constraints.ValidPassword;

@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NonNull
    @NotBlank(message = "{error.empty}")
    @Unique(message = "{error.empty}", fieldName = "email")
    @Column(name = "email")
    @Email
    private String email;

    @NonNull
    @NotBlank(message = "{error.empty}")
    @Column(name = "first_name")
    private String firstName;

    @NonNull
    @NotBlank(message = "{error.empty}")
    @Column(name = "last_name")
    private String lastName;

    @NonNull
    @Pattern(regexp = "^\\+7?8? \\(\\d{3}\\) \\d{7}",
            message="{error.phone}")
    @Column(name = "phone_number")
    private String phoneNumber;

    @NonNull
    @ValidPassword
    @Column(name = "password")
    private String password;

    @Column(name = "pic_name")
    private String picName = "default.jpeg";


    @NonNull
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    @NonNull
    @Column(name = "confirmation")
    @Enumerated(EnumType.STRING)
    private Confirmation confirmation = Confirmation.NOT_CONFIRMED;
}
