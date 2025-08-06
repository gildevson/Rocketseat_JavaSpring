📌 Entendendo o Código e Conceitos Envolvidos
❓ O que é o Lombok?
O Lombok é uma biblioteca Java que tem como objetivo reduzir a verbosidade do código, evitando a necessidade de escrever manualmente métodos repetitivos, como:

Getters e Setters

toString()

equals() e hashCode()

Construtores (padrão e com argumentos)

✅ Vantagens de Usar Lombok
Redução de código repetitivo

Código mais limpo e legível

Manutenção facilitada

🧪 Exemplo sem Lombok
java
Copiar
Editar
public class User {
    private UUID id;
    private String username;
    private String name;
    private String password;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    // ... demais getters e setters
}
🧙‍♂️ Exemplo com Lombok
java
Copiar
Editar
import lombok.Data;
import java.util.UUID;

@Data
public class User {
    private UUID id;
    private String username;
    private String name;
    private String password;
}
🔹 A anotação @Data gera automaticamente:

Getters

Setters

toString()

equals() e hashCode()

Construtor padrão

🔧 Outras Anotações Comuns no Spring + JPA
Anotação	Descrição
@Autowired	Injeta dependências automaticamente (Inversão de Controle - IoC)
@RequestMapping	Mapeia requisições HTTP em métodos da controller
@PostMapping	Mapeia requisições POST
@RequestBody	Indica que o parâmetro virá no corpo da requisição HTTP
@Entity	Marca a classe como uma entidade JPA (tabela no banco de dados)
@Id	Indica o campo identificador da entidade (chave primária)
@GeneratedValue	Gera automaticamente o valor da chave primária
@CreationTimestamp	Preenche automaticamente com a data de criação
@Column	Personaliza a coluna no banco de dados (nome, tipo, etc.)

🗂️ O que é um Repository?
No contexto do Spring, um Repository é uma interface de acesso aos dados. Ele define métodos para interagir com o banco de dados, como salvar, buscar, atualizar e deletar registros.

java
Copiar
Editar
public interface UserRepository extends JpaRepository<User, UUID> {
    // Métodos personalizados podem ser definidos aqui
}
É considerado um contrato (interface), onde você pode definir regras de acesso aos dados.

💡 O que é o Spring Data JPA?
O Spring Data JPA é uma extensão do Spring que facilita o uso da JPA (Java Persistence API) para interagir com bancos de dados relacionais.

✅ Benefícios:
Reduz código boilerplate

Suporte a operações CRUD

Paginação e ordenação automáticas

Query derivada de nome de método

Integração com diversos bancos de dados

🧠 Entendendo ORM e JPA
ORM (Object-Relational Mapping) é um conceito geral que permite mapear objetos Java para tabelas do banco de dados.

JPA (Java Persistence API) é uma especificação (padrão) de ORM no ecossistema Java.

🧩 Ou seja:

ORM = Conceito/abstração

JPA = Padrão Java para ORM

Hibernate = Implementação concreta da JPA (a mais popular)