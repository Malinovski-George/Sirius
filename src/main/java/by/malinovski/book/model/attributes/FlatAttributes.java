package by.malinovski.book.model.attributes;

import by.malinovski.book.model.Flat;
import by.malinovski.book.model.Price.Price;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/** This class contains all flat attributes that is used in full setting form */
@Entity
@Table(name = "Flat_Attributes")
@javax.persistence.Cacheable
public class FlatAttributes {
  // TODO convert in USD/RUB

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  @JoinColumn(name = "flat")
  Flat flat;

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

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "price")
  private Price price;

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

  public Price getPrice() {
    return price;
  }

  public void setPrice(Price price) {
    this.price = price;
  }
}
