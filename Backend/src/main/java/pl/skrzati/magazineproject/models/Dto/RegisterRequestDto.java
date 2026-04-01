package pl.skrzati.magazineproject.models.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequestDto(
        @NotBlank(message = "Imię nie może być puste")
        String firstName,
        @NotBlank(message = "Nazwisko nie może być puste")
        String lastName,
        @NotBlank(message = "Hasło nie może być puste")
        @Size(min = 8, max = 100, message = "Hasło musi mieć co najmniej 8 znaków")
        String password,
        @Email
        @NotBlank(message = "Email nie może być pusty")
        String email
) {
}
