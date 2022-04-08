import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneBookTests {
    PhoneBook sut;

    @BeforeEach
    public void init() {
        sut = new PhoneBook();
        sut.addContactList(new Contact("Иван", "89570420645"));
        sut.addContactList(new Contact("Ольга", "89390498885"));
    }

    @Test
    public void test_searchForContactByNumber() {
        // given:
        String number = "89570420645", expected = "Иван";
        // when:
        String result = sut.searchForContactByNumber(number);
        // then:
        assertEquals(expected, result);
    }

    @Test
    public void test_isFoundTheNumberByTrue() {
        // given:
        String number = "89570420645";
        // when:
        boolean result = sut.isFoundTheNumber(number);
        // then:
        assertTrue(result);
    }

    @Test
    public void test_isFoundTheNumberByFalse() {
        // given:
        String number = "895704203";
        // when:
        boolean result = sut.isFoundTheNumber(number);
        // then:
        assertFalse(result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/source.csv")
    public void test_searchForContactByNumber(String number, String expected) {
        // given:
        String result = sut.searchForContactByNumber(number);
        // then:
        assertEquals(expected, result);
    }

}