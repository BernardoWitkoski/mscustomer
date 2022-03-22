package Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "teste")
public class testEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

}
