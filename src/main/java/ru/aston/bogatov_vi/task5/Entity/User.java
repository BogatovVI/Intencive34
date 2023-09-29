package ru.aston.bogatov_vi.task5.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.aston.bogatov_vi.task5.BirthdayConvector;
import java.util.List;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Builder
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Surname")
    private String surname;

    @Column(name = "Birthday")
    @Convert(converter = BirthdayConvector.class)
    private Birthday birthday;

    @Column(name = "Telephone")
    private String telephone;

    @Column(name = "Email")
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id")
    private List<Order> orders;
}