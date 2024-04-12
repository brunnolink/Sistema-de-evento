package rocketseat.com.passin.domain.attendee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rocketseat.com.passin.domain.event.Event;

import java.time.LocalDateTime;

@Entity //@Entity: Essa anotação indica que a classe Attendee é uma entidade JPA, ou seja, ela será mapeada para uma tabela no banco de dados.

@Table(name = "attendees") //@Table(name = "attendees"): Essa anotação especifica o nome da tabela no banco de dados que será mapeada para a entidade Attendee.
@Getter
@Setter // Essas anotações do Lombok geram automaticamente métodos getters e setters para os campos da classe.
@AllArgsConstructor
@NoArgsConstructor // Essas anotações do Lombok geram automaticamente construtores com todos os argumentos e construtor vazio, respectivamente.
public class Attendee {
    @Id //Essa anotação marca o campo id como a chave primária da entidade.

    @GeneratedValue(strategy = GenerationType.UUID) //Essa anotação especifica que o valor da chave primária será gerado automaticamente usando uma estratégia UUID.

    private String id;

    @Column(nullable = false) // Essas anotações especificam que os campos name e email não podem ser nulos no banco de dados.
    private String name;

    @Column(nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false) //Essas anotações definem o relacionamento entre a entidade Attendee e a entidade Event. Indica que um Attendee pertence a um Event.

    private Event event;

    @Column(name = "created_at") //Essa anotação especifica que o campo createdAt será mapeado para uma coluna chamada created_at no banco de dados.
    private LocalDateTime createdAt;
}