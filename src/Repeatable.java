import java.time.LocalDateTime;

public interface Repeatable {
    LocalDateTime nextDateTime(LocalDateTime previousDatetime);
}
