package by.malinovski.book.model;

import by.malinovski.book.model.Photos.FlatPhoto;
import by.malinovski.book.model.attributes.FlatAttributes;
import by.malinovski.book.model.attributes.SimpleAttributes;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "flat")
public class Flat {

    //General
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "flatOwner")
    private User flatOwner;

    @Column(name = "ownerName", nullable = false, length = 250)
    private String ownerName;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "flat", cascade = CascadeType.ALL)
    private FlatAttributes flatAttributes;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "flat", cascade = CascadeType.ALL)
    private SimpleAttributes simpleAttributes;

    @Column(name = "descriptionShort", nullable = false, length = 250)
    private String descriptionShort;

    //Address
    @Column(name = "city", nullable = false, length = 250)
    private String city;

    @Column(name = "street", nullable = false, length = 250)
    private String street;

    @Column(name = "house", nullable = false, length = 250)
    private String house;

    //Service
    @Column(name = "created", nullable = false)
    private Date created;

    @Column(name = "modified", nullable = false, length = 250)
    private Date modified;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "flat", cascade = CascadeType.REMOVE)
    private Set<FlatPhoto> photos = new HashSet<>();

    // -- gettets and setters --

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getFlatOwner() {
        return flatOwner;
    }

    public void setFlatOwner(User flatOwner) {
        this.flatOwner = flatOwner;
    }

    public FlatAttributes getFlatAttributes() {
        return flatAttributes;
    }

    public void setFlatAttributes(FlatAttributes flatAttributes) {
        this.flatAttributes = flatAttributes;
    }

    public String getDescriptionShort() {
        return descriptionShort;
    }

    public void setDescriptionShort(String descriptionShort) {
        this.descriptionShort = descriptionShort;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public SimpleAttributes getSimpleAttributes() {
        return simpleAttributes;
    }

    public void setSimpleAttributes(SimpleAttributes simpleAttributes) {
        this.simpleAttributes = simpleAttributes;
    }

    public Set<FlatPhoto> getPhotos() {
        return photos;
    }

    public void setPhotos(Set<FlatPhoto> photos) {
        this.photos = photos;
    }
}
