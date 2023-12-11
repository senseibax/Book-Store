package kz.sensei.crudlab1.Repository;

import kz.sensei.crudlab1.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
