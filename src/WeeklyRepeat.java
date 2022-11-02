import java.time.LocalDateTime;

public class WeeklyRepeat implements Repeatable{

    @Override
    public LocalDateTime nextDateTime(LocalDateTime previousDatetime) {
        return previousDatetime.plusWeeks(1);
    }

    @Override
    public String toString() {
        return "Повторяется еженедельно";
    }
}
