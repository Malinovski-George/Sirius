package by.malinovski.book.model;

        import javax.persistence.*;

//@Entity
//@Table(name = "contacts")
public class Contacts {

    private long Id;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="USER_ID")
    private User user;

//    @Column(name = "phone1", nullable = false, length = 50)
    private String phone1;

//    @Column(name = "phone2", length = 50)
    private String phone2;

//    @Column(name = "phone3", length = 50)
    private String phone3;

//    @Column(name = "phoneViber", length = 50)
    private String phoneViber;

//    @Column(name = "phoneWatsUp", length = 50)
    private String phoneWatsUp;


    public Contacts() {
    }


//    @Id
//    @GeneratedValue
//    @Column(name = "ID")
    public long getId() {
        return this.Id;
    }

    public void setId(long id) {
        this.Id = id;
    }

   /* @Column(name = "STREET", nullable = false, length=250)
    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "CITY", nullable = false, length=50)
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "STATE", nullable = false, length=50)
    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }
*/

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

}
