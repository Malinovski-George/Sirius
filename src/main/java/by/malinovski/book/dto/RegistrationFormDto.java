package by.malinovski.book.dto;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegistrationFormDto {
    //    Какие контактные данные вы хотите указать для этого объекта?

    private String ownerName;

    private String phone1;
    private boolean viberPhone1;
    private boolean watsUpPhone1;

    private String phone2;
    private boolean viberPhone2;
    private boolean WatsUpPhone2;

    private String phone3;
    private boolean viberPhone3;
    private boolean WatsUpPhone3;

    //    Где находится ваш объект?
    private String street;
    private String houseNumber;
    private String country;
    private String town;

    //    Планировка и цены
    private double roomNumber;
    private double bedNumber;
    private String bathroomNumber;
    private int multistorey;
    private int generalarea;
    private int lifearea;
    private int kitchenarea;

    public String getBathroomNumber() {
        return bathroomNumber;
    }

    public void setBathroomNumber(String bathroomNumber) {
        this.bathroomNumber = bathroomNumber;
    }

    public int getMultistorey() {
        return multistorey;
    }

    public void setMultistorey(int multistorey) {
        this.multistorey = multistorey;
    }

    public int getGeneralarea() {
        return generalarea;
    }

    public void setGeneralarea(int generalarea) {
        this.generalarea = generalarea;
    }

    public int getLifearea() {
        return lifearea;
    }

    public void setLifearea(int lifearea) {
        this.lifearea = lifearea;
    }

    public int getKitchenarea() {
        return kitchenarea;
    }

    public void setKitchenarea(int kitchenarea) {
        this.kitchenarea = kitchenarea;
    }

    public int getGuestsNumber() {
        return guestsNumber;
    }

    public void setGuestsNumber(int guestsNumber) {
        this.guestsNumber = guestsNumber;
    }

    public int getPricenight() {
        return pricenight;
    }

    public void setPricenight(int pricenight) {
        this.pricenight = pricenight;
    }

    public int getPriceHour() {
        return priceHour;
    }

    public void setPriceHour(int priceHour) {
        this.priceHour = priceHour;
    }

    //    Количество гостей
    private int guestsNumber;

    //    цена за ночь
    private int pricenight;
    private int priceHour;

    private List dropzone;

    //    Какие удобства вы предлагаете?
    private boolean wifi;
    private boolean airconditioning;          //Кондиционер
    private boolean washer;
    private boolean tv;
    private boolean notSmoke;
    private boolean forChildren;
    private boolean possiblepets;


    //    дополнительные удобства

    //    Удобства в номере---------------
    private boolean clothesHanger;         //    Вешалка для одежды
    private boolean foldingBed;            //    Раскладная кровать
    private boolean sofaBed;               //    Диван-кровать
    private boolean cupboard;          //Шкаф/комод
    private boolean builtInWardrobes;          //Встроенные шкафы
    private boolean carpet;                //    Ковровое покрытие
    private boolean laminate;                //    Ламинат
    private boolean parquet;                //    Паркетный пол
    private boolean wooden;                //    Деревянный пол
    private boolean tiledMarble;             //    Плиточный/Мраморный пол
    private boolean linoleum;             //    Линолиум
    private boolean heatedFloors;             //    Полы с подогревом
    private boolean fireplace;             //    Камин
    private boolean fan;                        //    Вентилятор
    private boolean iron;
    private boolean ironingboard;
    private boolean mosquito;                  //    Москитная сетка
    private boolean separateEntrance;         //    Отдельный вход
    private boolean sofa;                        //    Диван
    private boolean doubleBed;           //Двухспальная кровать
    private boolean armchair;               //Кресло
    private boolean soundproofing;          //        Звукоизоляция
    private boolean desktop;                 //Рабочий стол
    private boolean cleaners;                //Чистящие средства

    //Ванная комната----------
    private boolean hairDryer;         // фен
    private boolean toiletPaper;         //Туалетная бумага
    private boolean bidet;                 //Биде
    private boolean bath;                    //Ванна
    private boolean showerCabin;         //Душевая кабина
    private boolean toiletries;         //Туалетные принадлежности
    private boolean jacuzzi;


    //Медиа и технологии-----------------
    private boolean computer;                       //Компьютер
    private boolean сableСhannels;             //Кабельные каналы
    private boolean satelliteChannels;         //Спутниковые каналы
    private boolean phone;                            //Телефон
    private boolean payPerViewChannels;         //Платные ТВ-каналы
    private boolean videoPlayer;                     //Видеопроигрыватель
    private boolean musicAudioSystem;         //Музыкальная аудио система

    //Питание и напитки---------------------
    private boolean dinnerTable;                      //Обеденный стол
    private boolean oven;                              //Духовка
    private boolean plate;                              //Плита
    private boolean toaster;                              //Тостер
    private boolean dishWasher;                     //Посудомоечная машина
    private boolean electricKettle;                //Электрический чайник
    private boolean kitchenAccessories;         //Кухонные принадлежности
    private boolean microwave;                 //Микроволновая печь
    private boolean fridge;                           //Холодильник
    private boolean coffeeMachine;           // Кофемашина

    //Дополнительные услуги--------------------
    private boolean alarmClock;         //Будильник
    private boolean underwear;         //    Белье
    private boolean towels;                //Полотенца
    private boolean extraBedding;     //Дополнительные полотенца/постельное белье за дополнительную плату

    //Снаружи-----------------------------
    private boolean balcony;                         //Балкон
    private boolean terrace;                         //    Терраса
    private boolean cityView;                         //Вид на город
    private boolean gardenView;                         //Вид на сад
    private boolean lakeView;                         //Вид на озеро
    private boolean forestView;                         //Вид на лес
    private boolean metro;                            //рядом метро
    private boolean busStop;                         //рядом автобусная остановка
    private boolean shop;                              //рядом магазин
    private boolean entertainmentCenter;         //рядом развлекательный центр
    private boolean freeParking;                     //бесплатная стоянка
    private boolean paidParking;                     //Платная стоянка
    private boolean oneParkingPace;                     //Одно стояночное место

    //Доступность----------------------------------
    private boolean firstFloor;         //Помещение полностью находится на первом этаже
    private boolean lift;                  //Лифт

    //Безопасность-------------------------------
    private boolean receptionist;                            //Портье
    private boolean surveillanceCamerasYard;         //Камеры наблюдения во дворе
    private boolean surveillanceCamerasParking;         //Камеры наблюдения на стоянке
    private boolean surveillanceCamerasLanding;         //Камеры наблюдения на лестничной площадке
    private boolean ironDoors;                                  //Железные входные двери
    private boolean safe;                                          //Сейф
    private boolean domoff;                                    //домофон

    //todo getters & setters

    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////

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

    public boolean isViberPhone1() {
        return viberPhone1;
    }

    public void setViberPhone1(boolean viberPhone1) {
        this.viberPhone1 = viberPhone1;
    }

    public boolean isWatsUpPhone1() {
        return watsUpPhone1;
    }

    public void setWatsUpPhone1(boolean watsUpPhone1) {
        this.watsUpPhone1 = watsUpPhone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public boolean isViberPhone2() {
        return viberPhone2;
    }

    public void setViberPhone2(boolean viberPhone2) {
        this.viberPhone2 = viberPhone2;
    }

    public boolean isWatsUpPhone2() {
        return WatsUpPhone2;
    }

    public void setWatsUpPhone2(boolean watsUpPhone2) {
        WatsUpPhone2 = watsUpPhone2;
    }

    public String getPhone3() {
        return phone3;
    }

    public void setPhone3(String phone3) {
        this.phone3 = phone3;
    }

    public boolean isViberPhone3() {
        return viberPhone3;
    }

    public void setViberPhone3(boolean viberPhone3) {
        this.viberPhone3 = viberPhone3;
    }

    public boolean isWatsUpPhone3() {
        return WatsUpPhone3;
    }

    public void setWatsUpPhone3(boolean watsUpPhone3) {
        WatsUpPhone3 = watsUpPhone3;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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


    public String getBathroomnumber() {
        return bathroomNumber;
    }

    public void setBathroomnumber(String bathroomnumber) {
        this.bathroomNumber = bathroomnumber;
    }


    public List getDropzone() {
        return dropzone;
    }

    public void setDropzone(List dropzone) {
        this.dropzone = dropzone;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isAirconditioning() {
        return airconditioning;
    }

    public void setAirconditioning(boolean airconditioning) {
        this.airconditioning = airconditioning;
    }

    public boolean isWasher() {
        return washer;
    }

    public void setWasher(boolean washer) {
        this.washer = washer;
    }

    public boolean isTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public boolean isNotSmoke() {
        return notSmoke;
    }

    public void setNotSmoke(boolean notSmoke) {
        this.notSmoke = notSmoke;
    }

    public boolean isForChildren() {
        return forChildren;
    }

    public void setForChildren(boolean forChildren) {
        this.forChildren = forChildren;
    }

    public boolean isPossiblepets() {
        return possiblepets;
    }

    public void setPossiblepets(boolean possiblepets) {
        this.possiblepets = possiblepets;
    }

    public boolean isClothesHanger() {
        return clothesHanger;
    }

    public void setClothesHanger(boolean clothesHanger) {
        this.clothesHanger = clothesHanger;
    }

    public boolean isFoldingBed() {
        return foldingBed;
    }

    public void setFoldingBed(boolean foldingBed) {
        this.foldingBed = foldingBed;
    }

    public boolean isSofaBed() {
        return sofaBed;
    }

    public void setSofaBed(boolean sofaBed) {
        this.sofaBed = sofaBed;
    }

    public boolean isCupboard() {
        return cupboard;
    }

    public void setCupboard(boolean cupboard) {
        this.cupboard = cupboard;
    }

    public boolean isBuiltInWardrobes() {
        return builtInWardrobes;
    }

    public void setBuiltInWardrobes(boolean builtInWardrobes) {
        this.builtInWardrobes = builtInWardrobes;
    }

    public boolean isCarpet() {
        return carpet;
    }

    public void setCarpet(boolean carpet) {
        this.carpet = carpet;
    }

    public boolean isLaminate() {
        return laminate;
    }

    public void setLaminate(boolean laminate) {
        this.laminate = laminate;
    }

    public boolean isParquet() {
        return parquet;
    }

    public void setParquet(boolean parquet) {
        this.parquet = parquet;
    }

    public boolean isWooden() {
        return wooden;
    }

    public void setWooden(boolean wooden) {
        this.wooden = wooden;
    }

    public boolean isTiledMarble() {
        return tiledMarble;
    }

    public void setTiledMarble(boolean tiledMarble) {
        this.tiledMarble = tiledMarble;
    }

    public boolean isLinoleum() {
        return linoleum;
    }

    public void setLinoleum(boolean linoleum) {
        this.linoleum = linoleum;
    }

    public boolean isHeatedFloors() {
        return heatedFloors;
    }

    public void setHeatedFloors(boolean heatedFloors) {
        this.heatedFloors = heatedFloors;
    }

    public boolean isFireplace() {
        return fireplace;
    }

    public void setFireplace(boolean fireplace) {
        this.fireplace = fireplace;
    }

    public boolean isFan() {
        return fan;
    }

    public void setFan(boolean fan) {
        this.fan = fan;
    }

    public boolean isIron() {
        return iron;
    }

    public void setIron(boolean iron) {
        this.iron = iron;
    }

    public boolean isIroningboard() {
        return ironingboard;
    }

    public void setIroningboard(boolean ironingboard) {
        this.ironingboard = ironingboard;
    }

    public boolean isMosquito() {
        return mosquito;
    }

    public void setMosquito(boolean mosquito) {
        this.mosquito = mosquito;
    }

    public boolean isSeparateEntrance() {
        return separateEntrance;
    }

    public void setSeparateEntrance(boolean separateEntrance) {
        this.separateEntrance = separateEntrance;
    }

    public boolean isSofa() {
        return sofa;
    }

    public void setSofa(boolean sofa) {
        this.sofa = sofa;
    }

    public boolean isDoubleBed() {
        return doubleBed;
    }

    public void setDoubleBed(boolean doubleBed) {
        this.doubleBed = doubleBed;
    }

    public boolean isArmchair() {
        return armchair;
    }

    public void setArmchair(boolean armchair) {
        this.armchair = armchair;
    }

    public boolean isSoundproofing() {
        return soundproofing;
    }

    public void setSoundproofing(boolean soundproofing) {
        this.soundproofing = soundproofing;
    }

    public boolean isDesktop() {
        return desktop;
    }

    public void setDesktop(boolean desktop) {
        this.desktop = desktop;
    }

    public boolean isCleaners() {
        return cleaners;
    }

    public void setCleaners(boolean cleaners) {
        this.cleaners = cleaners;
    }

    public boolean isHairDryer() {
        return hairDryer;
    }

    public void setHairDryer(boolean hairDryer) {
        this.hairDryer = hairDryer;
    }

    public boolean isToiletPaper() {
        return toiletPaper;
    }

    public void setToiletPaper(boolean toiletPaper) {
        this.toiletPaper = toiletPaper;
    }

    public boolean isBidet() {
        return bidet;
    }

    public void setBidet(boolean bidet) {
        this.bidet = bidet;
    }

    public boolean isBath() {
        return bath;
    }

    public void setBath(boolean bath) {
        this.bath = bath;
    }

    public boolean isShowerCabin() {
        return showerCabin;
    }

    public void setShowerCabin(boolean showerCabin) {
        this.showerCabin = showerCabin;
    }

    public boolean isToiletries() {
        return toiletries;
    }

    public void setToiletries(boolean toiletries) {
        this.toiletries = toiletries;
    }

    public boolean isJacuzzi() {
        return jacuzzi;
    }

    public void setJacuzzi(boolean jacuzzi) {
        this.jacuzzi = jacuzzi;
    }

    public boolean isComputer() {
        return computer;
    }

    public void setComputer(boolean computer) {
        this.computer = computer;
    }

    public boolean isСableСhannels() {
        return сableСhannels;
    }

    public void setСableСhannels(boolean сableСhannels) {
        this.сableСhannels = сableСhannels;
    }

    public boolean isSatelliteChannels() {
        return satelliteChannels;
    }

    public void setSatelliteChannels(boolean satelliteChannels) {
        this.satelliteChannels = satelliteChannels;
    }

    public boolean isPhone() {
        return phone;
    }

    public void setPhone(boolean phone) {
        this.phone = phone;
    }

    public boolean isPayPerViewChannels() {
        return payPerViewChannels;
    }

    public void setPayPerViewChannels(boolean payPerViewChannels) {
        this.payPerViewChannels = payPerViewChannels;
    }

    public boolean isVideoPlayer() {
        return videoPlayer;
    }

    public void setVideoPlayer(boolean videoPlayer) {
        this.videoPlayer = videoPlayer;
    }

    public boolean isMusicAudioSystem() {
        return musicAudioSystem;
    }

    public void setMusicAudioSystem(boolean musicAudioSystem) {
        this.musicAudioSystem = musicAudioSystem;
    }

    public boolean isDinnerTable() {
        return dinnerTable;
    }

    public void setDinnerTable(boolean dinnerTable) {
        this.dinnerTable = dinnerTable;
    }

    public boolean isOven() {
        return oven;
    }

    public void setOven(boolean oven) {
        this.oven = oven;
    }

    public boolean isPlate() {
        return plate;
    }

    public void setPlate(boolean plate) {
        this.plate = plate;
    }

    public boolean isToaster() {
        return toaster;
    }

    public void setToaster(boolean toaster) {
        this.toaster = toaster;
    }

    public boolean isDishWasher() {
        return dishWasher;
    }

    public void setDishWasher(boolean dishWasher) {
        this.dishWasher = dishWasher;
    }

    public boolean isElectricKettle() {
        return electricKettle;
    }

    public void setElectricKettle(boolean electricKettle) {
        this.electricKettle = electricKettle;
    }

    public boolean isKitchenAccessories() {
        return kitchenAccessories;
    }

    public void setKitchenAccessories(boolean kitchenAccessories) {
        this.kitchenAccessories = kitchenAccessories;
    }

    public boolean isMicrowave() {
        return microwave;
    }

    public void setMicrowave(boolean microwave) {
        this.microwave = microwave;
    }

    public boolean isFridge() {
        return fridge;
    }

    public void setFridge(boolean fridge) {
        this.fridge = fridge;
    }

    public boolean isCoffeeMachine() {
        return coffeeMachine;
    }

    public void setCoffeeMachine(boolean coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    public boolean isAlarmClock() {
        return alarmClock;
    }

    public void setAlarmClock(boolean alarmClock) {
        this.alarmClock = alarmClock;
    }

    public boolean isUnderwear() {
        return underwear;
    }

    public void setUnderwear(boolean underwear) {
        this.underwear = underwear;
    }

    public boolean isTowels() {
        return towels;
    }

    public void setTowels(boolean towels) {
        this.towels = towels;
    }

    public boolean isExtraBedding() {
        return extraBedding;
    }

    public void setExtraBedding(boolean extraBedding) {
        this.extraBedding = extraBedding;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    public boolean isTerrace() {
        return terrace;
    }

    public void setTerrace(boolean terrace) {
        this.terrace = terrace;
    }

    public boolean isCityView() {
        return cityView;
    }

    public void setCityView(boolean cityView) {
        this.cityView = cityView;
    }

    public boolean isGardenView() {
        return gardenView;
    }

    public void setGardenView(boolean gardenView) {
        this.gardenView = gardenView;
    }

    public boolean isLakeView() {
        return lakeView;
    }

    public void setLakeView(boolean lakeView) {
        this.lakeView = lakeView;
    }

    public boolean isForestView() {
        return forestView;
    }

    public void setForestView(boolean forestView) {
        this.forestView = forestView;
    }

    public boolean isMetro() {
        return metro;
    }

    public void setMetro(boolean metro) {
        this.metro = metro;
    }

    public boolean isBusStop() {
        return busStop;
    }

    public void setBusStop(boolean busStop) {
        this.busStop = busStop;
    }

    public boolean isShop() {
        return shop;
    }

    public void setShop(boolean shop) {
        this.shop = shop;
    }

    public boolean isEntertainmentCenter() {
        return entertainmentCenter;
    }

    public void setEntertainmentCenter(boolean entertainmentCenter) {
        this.entertainmentCenter = entertainmentCenter;
    }

    public boolean isFreeParking() {
        return freeParking;
    }

    public void setFreeParking(boolean freeParking) {
        this.freeParking = freeParking;
    }

    public boolean isPaidParking() {
        return paidParking;
    }

    public void setPaidParking(boolean paidParking) {
        this.paidParking = paidParking;
    }

    public boolean isOneParkingPace() {
        return oneParkingPace;
    }

    public void setOneParkingPace(boolean oneParkingPace) {
        this.oneParkingPace = oneParkingPace;
    }

    public boolean isFirstFloor() {
        return firstFloor;
    }

    public void setFirstFloor(boolean firstFloor) {
        this.firstFloor = firstFloor;
    }

    public boolean isLift() {
        return lift;
    }

    public void setLift(boolean lift) {
        this.lift = lift;
    }

    public boolean isReceptionist() {
        return receptionist;
    }

    public void setReceptionist(boolean receptionist) {
        this.receptionist = receptionist;
    }

    public boolean isSurveillanceCamerasYard() {
        return surveillanceCamerasYard;
    }

    public void setSurveillanceCamerasYard(boolean surveillanceCamerasYard) {
        this.surveillanceCamerasYard = surveillanceCamerasYard;
    }

    public boolean isSurveillanceCamerasParking() {
        return surveillanceCamerasParking;
    }

    public void setSurveillanceCamerasParking(boolean surveillanceCamerasParking) {
        this.surveillanceCamerasParking = surveillanceCamerasParking;
    }

    public boolean isSurveillanceCamerasLanding() {
        return surveillanceCamerasLanding;
    }

    public void setSurveillanceCamerasLanding(boolean surveillanceCamerasLanding) {
        this.surveillanceCamerasLanding = surveillanceCamerasLanding;
    }

    public boolean isIronDoors() {
        return ironDoors;
    }

    public void setIronDoors(boolean ironDoors) {
        this.ironDoors = ironDoors;
    }

    public boolean isSafe() {
        return safe;
    }

    public void setSafe(boolean safe) {
        this.safe = safe;
    }

    public boolean isDomoff() {
        return domoff;
    }

    public void setDomoff(boolean domoff) {
        this.domoff = domoff;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public double getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(double roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(double bedNumber) {
        this.bedNumber = bedNumber;
    }


    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////
    /////////////////////////////////////////


}
