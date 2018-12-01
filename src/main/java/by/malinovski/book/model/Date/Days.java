package by.malinovski.book.model.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Days {


    MONDAY("Monday", "Понедельник"),

    TUESDAY("Tuesday", "Вторник"),

    WEDNESDAY("Wednesday", "Среда"),

    THURSDAY("Thursday", "Четверг"),

    FRIDAY("Friday", "Пятница"),

    SATURDAY("Saturday", "Суббота"),

    SUNDAY("Sunday", "Воскресенье");

    @Getter
    private String rus;
    @Getter
    private String eng;

    Days(String rus, String eng) {
        this.rus = rus;
        this.eng = eng;
    }
}
