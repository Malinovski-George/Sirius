package by.malinovski.book.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="FlatAttributes")
public class FlatAttributes {
//TODO convert in USD/RUB


    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    Flat flat;

    @Column(name = "roomNumber", nullable = false)
    byte roomNumber;

    @Column(name = "bedNumber")
    byte bedNumber;

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

    @Column(name = "balcony")
    boolean balcony;

    @Column(name = "isToiletCombined")
    boolean isToiletCombined;

    @Column(name = "isFridge")
    private boolean isFridge;

    @Column(name = "isDishes")
    private boolean isDishes;

    @Column(name = "isMicrowaveOven")
    private boolean isMicrowaveOven;

    @Column(name = "isSmallEquipment")
    private boolean isSmallEquipment;

    @Column(name = "isWashe")
    private boolean isWasher;

    @Column(name = "isTV")
    private boolean isTV;

    @Column(name = "isHairDryer")
    private boolean isHairDryer;

    @Column(name = "isAirConditioning")
    private boolean isAirConditioning;

    @Column(name = "isWifi")
    private boolean isWifi;

    @Column(name = "isFurniture")
    private boolean isFurniture;

    @Column(name = "isBuiltInWardrobes")
    private boolean isBuiltInWardrobes;

    @Column(name = "isDomoff")
    private boolean isDomoff;

    @Column(name = "isElevator")
    private boolean isElevator;

    @Column(name = "isWindowsToYard")
    private boolean isWindowsToYard;

    @Column(name = "isDoubleGlazedWindows")
    private boolean isDoubleGlazedWindows;

    @Column(name = "isCanSmoke")
    private boolean isCanSmoke;

    @Column(name = "isPossiblePets")
    private boolean isPossiblePets;

    @Column(name = "isHolidays")
    private boolean isHolidays;

    @Column(name = "isFireplace")
    private boolean isFireplace;

    @Column(name = "isJacuzzi")
    private boolean isJacuzzi;

    @Column(name = "isOmputer")
    private boolean isOmputer;

    @Column(name = "isPool")
    private boolean isPool;

    @Column(name = "isDryingMachine")
    private boolean isDryingMachine;

    @Column(name = "isIron")
    private boolean isIron;

    @Column(name = "isIroningBoard")
    private boolean isIroningBoard;

    @Column(name = "isDryer")
    private boolean isDryer;

    @Column(name = "isAccessories")
    private boolean isAccessories;

    @Column(name = "isShampoo")
    private boolean isShampoo;

    @Column(name = "isSeparateEntrance")
    private boolean isSeparateEntrance;

    @Column(name = "isReceptionist")
    private boolean isReceptionist;

    @Column(name = "priceDay")
    private BigDecimal priceDay;

    @Column(name = "priceNight")
    private BigDecimal priceNight;

    @Column(name = "priceHour")
    private BigDecimal priceHour;

}
