package module;

public class DateTime {
    private final int month;
    private final int day;
    private final int year;

    public DateTime(int month, int day, int year){
        this.month=month; this.day = day; this.year = year;
    }

    public int month(){
        return month;
    }

    public int day(){
        return day;
    }

    public int year(){
        return year;
    }

    public String toString(){
        return year() + "/" + month() + "/" + day();
    }

}























