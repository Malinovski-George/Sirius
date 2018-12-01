package by.malinovski.book.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
* Pass & mail для регистрации и логирования
*
* */


@ToString(exclude = {"id", "email", "password", "phone"})
@EqualsAndHashCode(exclude = "id")
@RequiredArgsConstructor(staticName = "user")
@Data
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @NonNull
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @NonNull
    @Column(name = "password", nullable = false, length = 20)
    private String password;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @NonNull
    @Column(name = "phone1", nullable = false, length = 50)
    private String phone1;

    @Column(name = "phone2", length = 50)
    private String phone2;

    @Column(name = "phone3",  length = 50)
    private String phone3;

    @Column(name = "phoneViber", length = 50)
    private String phoneViber;

    @Column(name = "phoneWatsUp",length = 50)
    private String phoneWatsUp;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "flatOwner", cascade = CascadeType.ALL)
    private Set<Flat> flats = new HashSet<>();

}
