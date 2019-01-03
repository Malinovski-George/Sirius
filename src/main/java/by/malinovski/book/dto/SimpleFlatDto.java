package by.malinovski.book.dto;

import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Component
public class SimpleFlatDto {

  private int id;

  @NotNull(message = "Имя не должно быть пустым")
  private String ownerName;

  // TODO GM: add phones
  @NotNull(message = "Укажите хотя бы один телефон")
  @Pattern(
      regexp =
          "\\s{0,}\\+{0,1}375\\s{0,}\\({0,1}(([2]{1}([5]{1}|[9]{1}))|([3]{1}[3]{1})|([4]{1}[4]{1}))\\){0,1}\\s{0,1}[0-9]{3,3}\\s{0,1}\\-{0,1}\\s{0,1}[0-9]{2,2}\\s{0,1}\\-{0,1}\\s{0,1}[0-9]{2,2}",
      message = "Введите номер телефона соответствующий вормату +375(29|33|25|44)xxxxxxx")
  private String phone1;

  @Pattern(
      regexp =
          "\\s{0,}\\+{0,1}375\\s{0,}\\({0,1}(([2]{1}([5]{1}|[9]{1}))|([3]{1}[3]{1})|([4]{1}[4]{1}))\\){0,1}\\s{0,1}[0-9]{3,3}\\s{0,1}\\-{0,1}\\s{0,1}[0-9]{2,2}\\s{0,1}\\-{0,1}\\s{0,1}[0-9]{2,2}",
      message = "Введите номер телефона соответствующий вормату +375(29|33|25|44)xxxxxxx")
  private String phone2;

  @Pattern(
      regexp =
          "\\s{0,}\\+{0,1}375\\s{0,}\\({0,1}(([2]{1}([5]{1}|[9]{1}))|([3]{1}[3]{1})|([4]{1}[4]{1}))\\){0,1}\\s{0,1}[0-9]{3,3}\\s{0,1}\\-{0,1}\\s{0,1}[0-9]{2,2}\\s{0,1}\\-{0,1}\\s{0,1}[0-9]{2,2}",
      message = "Введите номер телефона соответствующий вормату +375(29|33|25|44)xxxxxxx")
  private String phone3;

  //    Где находится ваш объект?
  private String street;
  private String houseNumber;

  @NotNull(message = "Укажите город")
  private String town;

  private String country;

  //    private String bathroomNumber;
  //    Планировка и цены
  @NotNull(message = "Укажите количество комнат")
  @Range(min = 1L, message = "Количество комнат не может быть меньше 1")
  private byte roomNumber;

  @Range(min = 1L, message = "Количество этажей не может быть меньше 1")
  private byte multistorey;

  @Range(min = 1L, message = "Общая площадь не может быть меньше 1")
  private byte generalArea;

  @Range(min = 1L, message = "Жилая площадь не может быть меньше 1")
  private byte lifeArea;

  @Range(min = 1L, message = "Площадь кухни не может быть меньше 1")
  private byte kitchenArea;

  //    Количество гостей
  @NotNull(message = "Укажите максимально возможное количество гостей")
  @Range(min = 1L, message = "Количесвто гостей не может быть меньше 1")
  private byte guestsNumber;

  // Количество кроватей
  @NotNull(message = "Укажите количество спальных мест")
  @Range(min = 1L, message = "Количесвто спальных мест не может быть меньше 1")
  private byte bedNumber;

  private String descriptionShort;

  //    цена за ночь

  @NotNull(message = "Укажите цену")
  @Range(min = 1L, message = "Цена не может быть меньше 1")
  private long priceDay;

  private MultipartFile[] multipartFiles;
  private int mainPhotoId;

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

  public MultipartFile[] getMultipartFiles() {
    return multipartFiles;
  }

  public void setMultipartFiles(MultipartFile[] multipartFiles) {
    this.multipartFiles = multipartFiles;
  }

  public void setMainPhotoId(int mainPhotoId) {
    this.mainPhotoId = mainPhotoId;
  }

  public int getMainPhotoId() {
    return mainPhotoId;
  }
}
