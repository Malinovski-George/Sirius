package by.malinovski.book.model;

import by.malinovski.book.model.Photos.FlatPhoto;
import by.malinovski.book.model.attributes.FlatAttributes;
import by.malinovski.book.model.attributes.SimpleAttributes;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
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
    @Fetch(FetchMode.JOIN)
    private Set<FlatPhoto> photos = new HashSet<>();

    @Column(name = "phone1", length = 15)
    private String phone1;

    @Column(name = "phone2", length = 15)
    private String phone2;

    @Column(name = "phone3", length = 15)
    private String phone3;


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


}
