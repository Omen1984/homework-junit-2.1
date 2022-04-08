import java.time.LocalDateTime;

public class MissedCall implements Comparable<MissedCall> {

    private String number;
    private LocalDateTime dateAndTime;

    public MissedCall(String number) {
        this.number = number;
        this.dateAndTime = LocalDateTime.now();
    }

    public String getNumber() {
        return number;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    @Override
    public int compareTo(MissedCall o) {
        return dateAndTime.compareTo(o.dateAndTime);
    }
}
