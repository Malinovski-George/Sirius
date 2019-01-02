package by.malinovski.book.model.Price;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Class for money and price
 */

@Entity
@Table(name = "Price")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "priceNight")
    private BigDecimal priceNight;

    @Column(name = "priceHour")
    private BigDecimal priceHour;

    @Column(name = "priceDay")
    private BigDecimal priceDay;

    // -- gettets and setters --

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public BigDecimal getPriceDay() {
        return priceDay;
    }

    public void setPriceDay(BigDecimal priceDay) {
        this.priceDay = priceDay;
    }
}
