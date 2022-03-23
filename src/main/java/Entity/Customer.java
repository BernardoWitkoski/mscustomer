package Entity;

import Constants.Gender;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
@Entity
//tabela customers
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    @Min(3)
    private String firstName;

    @Column(nullable = false)
    @Min(3)
    private String lastName;

    @Column(nullable = false)
    private Gender sex;

    @Column(nullable = false)
    @Pattern(regexp = "[0-9]{3}[.][0-9]{3}[.][0-9]{3}[-][0-9]{2}")
    private String cpf;

    @Column(nullable = false)
    private LocalDate birthdate;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @Min(8)
    private String password;

    @Column(nullable = false)
    private Boolean active;

}
