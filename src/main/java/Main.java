import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        MissedCalls missedCalls = new MissedCalls();

        List<Contact> contactList = new ArrayList<>();
        contactList.add(new Contact("Иван", "89870431234"));
        contactList.add(new Contact("Артем", "89371133456"));
        contactList.add(new Contact("Марина", "89871137045"));
        contactList.add(new Contact("Ольга", "89270806734"));

        PhoneBook p1 = new PhoneBook();

        fillPhoneBook(contactList, p1);

        p1.searchForContactByNumber("89870431234");

        fillMissedCalls(missedCalls);

        missedCalls.showMissedCallsList(p1);
    }

    private static void fillPhoneBook(List<Contact> contactList, PhoneBook phoneBook) {
        for (Contact contact : contactList) {
            phoneBook.addContactList(contact);
        }
    }

    private static void fillMissedCalls(MissedCalls missedCalls) throws InterruptedException {
        missedCalls.addMissedCalls(new MissedCall("89870431234"));
        Thread.sleep(10);
        missedCalls.addMissedCalls(new MissedCall("89871137045"));
        Thread.sleep(10);
        missedCalls.addMissedCalls(new MissedCall("89871137045"));
        Thread.sleep(10);
        missedCalls.addMissedCalls(new MissedCall("8800553535"));
    }
}
