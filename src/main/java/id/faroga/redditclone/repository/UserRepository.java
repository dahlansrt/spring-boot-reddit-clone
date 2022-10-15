package id.faroga.redditclone.repository;

import id.faroga.redditclone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
