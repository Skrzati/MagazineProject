package pl.skrzati.magazineproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.skrzati.magazineproject.models.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
