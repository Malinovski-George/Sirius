package by.malinovski.book.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="FlatAttributes")
public class FlatAttributes {
//TODO convert in USD/RUB

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
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

    @Column(name = "hasBalcony")
    boolean balcony;

    @Column(name = "isToiletCombined")
    boolean isToiletCombined;

    @Column(name = "hasFridge")
    private boolean isFridge;

    @Column(name = "hasDishes")
    private boolean isDishes;

    @Column(name = "hasMicrowaveOven")
    private boolean isMicrowaveOven;

    @Column(name = "hasSmallEquipment")
    private boolean isSmallEquipment;

    @Column(name = "hasWasher")
    private boolean isWasher;

    @Column(name = "hasTV")
    private boolean isTV;

    @Column(name = "hasHairDryer")
    private boolean isHairDryer;

    @Column(name = "hasAirConditioning")
    private boolean isAirConditioning;

    @Column(name = "hasWifi")
    private boolean isWifi;

    @Column(name = "hasFurniture")
    private boolean isFurniture;

    @Column(name = "hasBuiltInWardrobes")
    private boolean isBuiltInWardrobes;

    @Column(name = "hasDomoff")
    private boolean isDomoff;

    @Column(name = "hasElevator")
    private boolean isElevator;

    @Column(name = "isWindowsToYard")
    private boolean isWindowsToYard;

    @Column(name = "hasDoubleGlazedWindows")
    private boolean isDoubleGlazedWindows;

    @Column(name = "CanSmoke")
    private boolean isCanSmoke;

    @Column(name = "isPossiblePets")
    private boolean isPossiblePets;

    @Column(name = "canSpendHolidays")
    private boolean isHolidays;

    @Column(name = "hasFireplace")
    private boolean isFireplace;

    @Column(name = "hasJacuzzi")
    private boolean isJacuzzi;

    @Column(name = "hasComputer")
    private boolean isOmputer;

    @Column(name = "hasPool")
    private boolean isPool;

    @Column(name = "hasDryingMachine")
    private boolean isDryingMachine;

    @Column(name = "hasIron")
    private boolean isIron;

    @Column(name = "hasIroningBoard")
    private boolean isIroningBoard;

    @Column(name = "hasDryer")
    private boolean isDryer;

    @Column(name = "hasTouletAccessories")
    private boolean isAccessories;

    @Column(name = "hasShampoo")
    private boolean isShampoo;

    @Column(name = "isSeparateEntrance")
    private boolean isSeparateEntrance;

    @Column(name = "hasReceptionist")
    private boolean isReceptionist;

    @Column(name = "priceDay")
    private BigDecimal priceDay;

    @Column(name = "priceNight")
    private BigDecimal priceNight;

    @Column(name = "priceHour")
    private BigDecimal priceHour;


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

    public boolean isBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    public boolean isToiletCombined() {
        return isToiletCombined;
    }

    public void setToiletCombined(boolean toiletCombined) {
        isToiletCombined = toiletCombined;
    }

    public boolean isFridge() {
        return isFridge;
    }

    public void setFridge(boolean fridge) {
        isFridge = fridge;
    }

    public boolean isDishes() {
        return isDishes;
    }

    public void setDishes(boolean dishes) {
        isDishes = dishes;
    }

    public boolean isMicrowaveOven() {
        return isMicrowaveOven;
    }

    public void setMicrowaveOven(boolean microwaveOven) {
        isMicrowaveOven = microwaveOven;
    }

    public boolean isSmallEquipment() {
        return isSmallEquipment;
    }

    public void setSmallEquipment(boolean smallEquipment) {
        isSmallEquipment = smallEquipment;
    }

    public boolean isWasher() {
        return isWasher;
    }

    public void setWasher(boolean washer) {
        isWasher = washer;
    }

    public boolean isTV() {
        return isTV;
    }

    public void setTV(boolean TV) {
        isTV = TV;
    }

    public boolean isHairDryer() {
        return isHairDryer;
    }

    public void setHairDryer(boolean hairDryer) {
        isHairDryer = hairDryer;
    }

    public boolean isAirConditioning() {
        return isAirConditioning;
    }

    public void setAirConditioning(boolean airConditioning) {
        isAirConditioning = airConditioning;
    }

    public boolean isWifi() {
        return isWifi;
    }

    public void setWifi(boolean wifi) {
        isWifi = wifi;
    }

    public boolean isFurniture() {
        return isFurniture;
    }

    public void setFurniture(boolean furniture) {
        isFurniture = furniture;
    }

    public boolean isBuiltInWardrobes() {
        return isBuiltInWardrobes;
    }

    public void setBuiltInWardrobes(boolean builtInWardrobes) {
        isBuiltInWardrobes = builtInWardrobes;
    }

    public boolean isDomoff() {
        return isDomoff;
    }

    public void setDomoff(boolean domoff) {
        isDomoff = domoff;
    }

    public boolean isElevator() {
        return isElevator;
    }

    public void setElevator(boolean elevator) {
        isElevator = elevator;
    }

    public boolean isWindowsToYard() {
        return isWindowsToYard;
    }

    public void setWindowsToYard(boolean windowsToYard) {
        isWindowsToYard = windowsToYard;
    }

    public boolean isDoubleGlazedWindows() {
        return isDoubleGlazedWindows;
    }

    public void setDoubleGlazedWindows(boolean doubleGlazedWindows) {
        isDoubleGlazedWindows = doubleGlazedWindows;
    }

    public boolean isCanSmoke() {
        return isCanSmoke;
    }

    public void setCanSmoke(boolean canSmoke) {
        isCanSmoke = canSmoke;
    }

    public boolean isPossiblePets() {
        return isPossiblePets;
    }

    public void setPossiblePets(boolean possiblePets) {
        isPossiblePets = possiblePets;
    }

    public boolean isHolidays() {
        return isHolidays;
    }

    public void setHolidays(boolean holidays) {
        isHolidays = holidays;
    }

    public boolean isFireplace() {
        return isFireplace;
    }

    public void setFireplace(boolean fireplace) {
        isFireplace = fireplace;
    }

    public boolean isJacuzzi() {
        return isJacuzzi;
    }

    public void setJacuzzi(boolean jacuzzi) {
        isJacuzzi = jacuzzi;
    }

    public boolean isOmputer() {
        return isOmputer;
    }

    public void setOmputer(boolean omputer) {
        isOmputer = omputer;
    }

    public boolean isPool() {
        return isPool;
    }

    public void setPool(boolean pool) {
        isPool = pool;
    }

    public boolean isDryingMachine() {
        return isDryingMachine;
    }

    public void setDryingMachine(boolean dryingMachine) {
        isDryingMachine = dryingMachine;
    }

    public boolean isIron() {
        return isIron;
    }

    public void setIron(boolean iron) {
        isIron = iron;
    }

    public boolean isIroningBoard() {
        return isIroningBoard;
    }

    public void setIroningBoard(boolean ironingBoard) {
        isIroningBoard = ironingBoard;
    }

    public boolean isDryer() {
        return isDryer;
    }

    public void setDryer(boolean dryer) {
        isDryer = dryer;
    }

    public boolean isAccessories() {
        return isAccessories;
    }

    public void setAccessories(boolean accessories) {
        isAccessories = accessories;
    }

    public boolean isShampoo() {
        return isShampoo;
    }

    public void setShampoo(boolean shampoo) {
        isShampoo = shampoo;
    }

    public boolean isSeparateEntrance() {
        return isSeparateEntrance;
    }

    public void setSeparateEntrance(boolean separateEntrance) {
        isSeparateEntrance = separateEntrance;
    }

    public boolean isReceptionist() {
        return isReceptionist;
    }

    public void setReceptionist(boolean receptionist) {
        isReceptionist = receptionist;
    }

    public BigDecimal getPriceDay() {
        return priceDay;
    }

    public void setPriceDay(BigDecimal priceDay) {
        this.priceDay = priceDay;
    }

    public BigDecimal getPriceNight() {
        return priceNight;
    }

    public void setPriceNight(BigDecimal priceNight) {
        this.priceNight = priceNight;
    }

    public BigDecimal getPriceHour() {
        return priceHour;
    }

    public void setPriceHour(BigDecimal priceHour) {
        this.priceHour = priceHour;
    }
}
