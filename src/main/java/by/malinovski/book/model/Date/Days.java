package by.malinovski.book.model.Date;

public enum Days {


    MONDAY("Monday", "Понедельник"),

    TUESDAY("Tuesday", "Вторник"),

    WEDNESDAY("Wednesday", "Среда"),

    THURSDAY("Thursday", "Четверг"),

    FRIDAY("Friday", "Пятница"),

    SATURDAY("Saturday", "Суббота"),

    SUNDAY("Sunday", "Воскресенье");

    private String rus;
    private String eng;

    Days(String rus, String eng) {
        this.rus = rus;
        this.eng = eng;
    }

    public String getRus() {
        return rus;
    }

    public String getEng() {
        return eng;
    }
}
