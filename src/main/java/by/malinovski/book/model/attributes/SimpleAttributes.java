package by.malinovski.book.model.attributes;

import by.malinovski.book.model.Flat;
import by.malinovski.book.model.Price.Price;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * This class contains flat attributes
 * that is used in registration form and home page
 */

@Entity
@Table(name = "simpleAttributes")
public class SimpleAttributes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "flat")
    Flat flat;

    @Column(name = "roomNumber", nullable = false)
    byte roomNumber;

    @Column(name = "bedNumber")
    byte bedNumber;

    @Column(name = "guestsNumber")
    byte guestsNumber;

    @Column(name = "floor", nullable = false)
    byte floor;

    @Column(name = "multistorey", nullable = false)
    byte multistorey; //этажность

    @Column(name = "generalArea", nullable = false)
    private byte generalArea;

    @Column(name = "lifeArea", nullable = false)
    private byte lifeArea;

    @Column(name = "kitchenArea", nullable = false)
    private byte kitchenArea;


    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "price")
    private Price price;


// -- gettets and setters --

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Flat getFlat() {
        return flat;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }

    public byte getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(byte roomNumber) {
        this.roomNumber = roomNumber;
    }

    public byte getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(byte bedNumber) {
        this.bedNumber = bedNumber;
    }

    public byte getFloor() {
        return floor;
    }

    public void setFloor(byte floor) {
        this.floor = floor;
    }

    public byte getMultistorey() {
        return multistorey;
    }

    public void setMultistorey(byte multistorey) {
        this.multistorey = multistorey;
    }

    public byte getGeneralArea() {
        return generalArea;
    }

    public void setGeneralArea(byte generalArea) {
        this.generalArea = generalArea;
    }

    public byte getLifeArea() {
        return lifeArea;
    }

    public void setLifeArea(byte lifeArea) {
        this.lifeArea = lifeArea;
    }

    public byte getKitchenArea() {
        return kitchenArea;
    }

    public void setKitchenArea(byte kitchenArea) {
        this.kitchenArea = kitchenArea;
    }

    public byte getGuestsNumber() {
        return guestsNumber;
    }

    public void setGuestsNumber(byte guestsNumber) {
        this.guestsNumber = guestsNumber;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
