import java.time.LocalDate;

public class DayliRepeat implements Repeatable{

    @Override
    public LocalDate nextDate(LocalDate previousDate){
        return previousDate.plusDays(1);
    }

    @Override
    public String toString() {
        return "Повторяется ежедневно";
    }
}
