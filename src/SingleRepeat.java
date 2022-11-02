import java.time.LocalDateTime;

public class SingleRepeat implements Repeatable{

    @Override
    public LocalDateTime nextDateTime(LocalDateTime previousDatetime) {
        return null;//задача одноразовая, следущей даты не существует
    }

    @Override
    public String toString() {
        return "Не повторяется";
    }
}
