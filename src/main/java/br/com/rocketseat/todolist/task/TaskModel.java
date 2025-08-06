package br.com.rocketseat.todolist.task;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;
    /*
    * ID
    * Usuario (ID_USUARIO)
    * Descrição
    * Titulo
    * Data de Inicio
    * Data de Terminio
    * Prioridade
    * */

@Data
@Entity(name = "tb_tasks")
public class TaskModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String description;

    @Column(length = 50)
    private String title;
    private LocalDateTime startAt; // data e horario
    private LocalDateTime endAt; // Quando ele vai finalizar a tarefa
    private String priority; // prioridade

    @CreationTimestamp
    private LocalDateTime createdAt;

    private UUID idUser;
}
