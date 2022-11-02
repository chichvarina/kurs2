import java.time.LocalDateTime;

public class MonthlyRepeat implements Repeatable{

    @Override
    public LocalDateTime nextDateTime(LocalDateTime previousDatetime) {
        return previousDatetime.plusMonths(1);
    }

    @Override
    public String toString() {
        return "Повторяется ежемесячно";
    }
}
