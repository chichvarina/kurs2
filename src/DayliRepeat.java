import java.time.LocalDateTime;

public class DayliRepeat implements Repeatable{

    @Override
    public LocalDateTime nextDateTime(LocalDateTime previousDatetime) {
        return previousDatetime.plusDays(1);
    }

    @Override
    public String toString() {
        return "Повторяется ежедневно";
    }
}
