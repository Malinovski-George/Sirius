package by.malinovski.book.model;


import by.malinovski.book.service.validator.ValidEmail;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Pass & mail для регистрации и логирования
 */


@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ValidEmail
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "password", nullable = false, length = 20)
    private String password;

    // TODO GM: move to contacts class
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "phone1", nullable = false, length = 50)
    private String phone1;

    @Column(name = "phone2", length = 50)
    private String phone2;

    @Column(name = "phone3", length = 50)
    private String phone3;

    @Column(name = "phoneViber", length = 50)
    private String phoneViber;

    @Column(name = "phoneWatsUp", length = 50)
    private String phoneWatsUp;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "flatOwner", cascade = CascadeType.ALL)
    private Set<Flat> flats = new HashSet<>();

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "ROLE_ID", nullable = false, length = 3)
    private Role role;

    public Role getRole() {
        return role;
    }


    public void setRole(Role role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getPhone3() {
        return phone3;
    }

    public void setPhone3(String phone3) {
        this.phone3 = phone3;
    }

    public String getPhoneViber() {
        return phoneViber;
    }

    public void setPhoneViber(String phoneViber) {
        this.phoneViber = phoneViber;
    }

    public String getPhoneWatsUp() {
        return phoneWatsUp;
    }

    public void setPhoneWatsUp(String phoneWatsUp) {
        this.phoneWatsUp = phoneWatsUp;
    }

    public Set<Flat> getFlats() {
        return flats;
    }

    public void setFlats(Set<Flat> flats) {
        this.flats = flats;
    }
}
