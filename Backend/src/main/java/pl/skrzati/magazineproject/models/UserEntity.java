package pl.skrzati.magazineproject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "user_table")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Imię nie może być puste")
    private String firstName;
    @NotBlank(message = "Nazwisko nie może być puste")
    private String lastName;
    @Email
    @NotBlank(message = "Email nie może być pusty")
    private String email;
    @NotBlank(message = "Hasło nie może być puste")
    @Size(min = 8,max = 100, message = "Hasło musi mieć co najmniej 8 znaków")
    private String password;
}
