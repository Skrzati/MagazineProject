package pl.skrzati.magazineproject.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.skrzati.magazineproject.models.Dto.RegisterRequestDto;
import pl.skrzati.magazineproject.models.UserEntity;
import pl.skrzati.magazineproject.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> createAccount(@Valid @RequestBody RegisterRequestDto registerRequestDto) {
        userService.createAccount(registerRequestDto);
        return ResponseEntity.ok().build();

    }
}
