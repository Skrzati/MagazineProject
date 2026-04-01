package pl.skrzati.magazineproject.services;


import org.springframework.stereotype.Service;
import pl.skrzati.magazineproject.models.Dto.RegisterRequestDto;
import pl.skrzati.magazineproject.models.Role;
import pl.skrzati.magazineproject.models.UserEntity;
import pl.skrzati.magazineproject.repository.UserRepository;

@Service
public class UserService {

    public final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createAccount(RegisterRequestDto registerRequestDto) {
        if (userRepository.findByEmail(registerRequestDto.email()).isPresent()) {
            throw new IllegalArgumentException("Użytkownik z tym adresem email już istnieje");
        }
        else{
            UserEntity user = UserEntity.builder()
                    .firstName(registerRequestDto.firstName())
                    .lastName(registerRequestDto.lastName())
                    .email(registerRequestDto.email())
                    .password(registerRequestDto.password())
                    .role(Role.WORKER)
                    .build();
            userRepository.save(user);
        }
    }
}
