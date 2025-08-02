package br.com.rocketseat.todolist.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "tb_users") // anotação entity é usada para referencia que é uma tabela
public class UserModel {

    @Id // essa anotação vai definir seu id vai ser chave primaria da tabela tb_users
    @GeneratedValue(generator = "UUID") // GERADOR
    private UUID id;

    @Column(unique = true)
    private String username;
    private String name;
    private String password;


    @CreationTimestamp // quando foi criado
    private LocalDateTime createdAt;



    // getter e setters
    // quando utitlizamos quando vamos adicionar uma algo privado em outras classes usando esse objeto.


}