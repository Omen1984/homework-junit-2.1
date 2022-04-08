import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

public class MissedCalls {

    private Map<LocalDateTime, String> missedCalls;

    public MissedCalls() {
        this.missedCalls = new TreeMap<>();
    }

    public void addMissedCalls(MissedCall missedCall) {
        missedCalls.put(LocalDateTime.now(), missedCall.getNumber());
    }

    public void showMissedCallsList(PhoneBook phoneBook) {
        System.out.println("Пропущенные вызовы");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        for (Map.Entry<LocalDateTime, String> kv : missedCalls.entrySet()) {
            String formattedDateTime = kv.getKey().format(formatter);
            if (phoneBook.isFoundTheNumber(kv.getValue())) {
                System.out.println(formattedDateTime + " - " + phoneBook.searchForContactByNumber(kv.getValue()));
            } else {
                System.out.println(formattedDateTime + " - " + kv.getValue());
            }
        }
    }

}
