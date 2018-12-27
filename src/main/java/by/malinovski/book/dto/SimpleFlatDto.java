package by.malinovski.book.dto;

import org.springframework.stereotype.Component;

@Component
public class SimpleFlatDto {


    private int id;
    private String ownerName;

    // TODO GM: add phones
    private String phone1;
    private String phone2;
    private String phone3;


    //    Где находится ваш объект?
    private String street;
    private String houseNumber;
    private String country;
    private String town;

    //    private String bathroomNumber;
    //    Планировка и цены
    private byte roomNumber;
    private byte multistorey;
    private byte generalArea;
    private byte lifeArea;
    private byte kitchenArea;

    //    Количество гостей
    private byte guestsNumber;

    //Количество кроватей
    private byte bedNumber;

    private String descriptionShort;


    //    цена за ночь


private long priceDay;

/*    private int priceNight;
    private int priceHour;*/


    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public byte getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(byte roomNumber) {
        this.roomNumber = roomNumber;
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

    public byte getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(byte bedNumber) {
        this.bedNumber = bedNumber;
    }

   /* public int getPriceNight() {
        return priceNight;
    }

    public void setPriceNight(int pricenight) {
        this.priceNight = pricenight;
    }

    public int getPriceHour() {
        return priceHour;
    }

    public void setPriceHour(int priceHour) {
        this.priceHour = priceHour;
    }*/

    public long getPriceDay() {
        return priceDay;
    }

    public void setPriceDay(long priceDay) {
        this.priceDay = priceDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescriptionShort() {
        return descriptionShort;
    }

    public void setDescriptionShort(String descriptionShort) {
        this.descriptionShort = descriptionShort;
    }
}