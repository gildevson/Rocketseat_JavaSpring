package br.com.rocketseat.todolist.user;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IUserRepository extends JpaRepository<UserModel, UUID> { // o que é uma interface é um contrato
    UserModel findByUsername(String username);
}
