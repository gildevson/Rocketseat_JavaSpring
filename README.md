📌 O que tem nesse código?
Antes de tudo, precisamos entender:


❓ O que é o Lombok?
O Lombok é uma biblioteca (lib) para Java que tem como objetivo facilitar e reduzir a repetição de código.
Ele ajuda a evitar a escrita manual de métodos como:

getters

setters

toString()

equals() e hashCode()

Construtores

🧠 Por que usar o Lombok?
Imagine que temos a seguinte classe User com atributos privados:

private UUID id;
private String username;
private String name;
private String password;

Normalmente, como os atributos são private, precisamos criar getters e setters para poder acessá-los e modificá-los em outras classes:

public UUID getId() { return id; }
public void setId(UUID id) { this.id = id; }

public String getUsername() { return username; }
public void setUsername(String username) { this.username = username; }
// ... e assim por diante


Isso torna o código maçante e repetitivo.
É aí que o Lombok entra para facilitar sua vida.

Com a anotação @Data, por exemplo, o Lombok gera automaticamente todos os getters e setters, além de:

toString()

equals() e hashCode()

Exemplo com Lombok:
import lombok.Data;
import java.util.UUID;

@Data
public class User {
    private UUID id;
    private String username;
    private String name;
    private String password;
}


isso são anotações

@Autowired
@RequestMapping
@postMapping
@RequestBody
@Id
@Entity
@GeneratedValue
@CreationTimestamp
@Column