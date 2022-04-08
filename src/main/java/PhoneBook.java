import java.util.*;

public class PhoneBook {

    private Map<String, Contact> contactList;

    public PhoneBook() {
        this.contactList = new HashMap<>();
    }

    public void addContactList(Contact contact) {
        this.contactList.put(contact.getNumber(), contact);
    }

    public String searchForContactByNumber(String number) {
        if (contactList.get(number) != null) {
            return String.format("%s", contactList.get(number).getName());
        } else {
            return "Контакт с таким номером отсутствует";
        }
    }

    public boolean isFoundTheNumber(String number) {
        if (contactList.get(number) != null) {
            return true;
        } else {
            return false;
        }
    }

}