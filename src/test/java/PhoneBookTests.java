import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

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
        assertThat(result, equalTo(expected));
    }

    @Test
    public void test_isFoundTheNumberByTrue() {
        // given:
        String number = "89570420645";
        // when:
        boolean result = sut.isFoundTheNumber(number);
        // then:
        assertThat(result, equalTo(true));
    }

    @Test
    public void test_isFoundTheNumberByFalse() {
        // given:
        String number = "895704203";
        // when:
        boolean result = sut.isFoundTheNumber(number);
        // then:
        assertThat(result, equalTo(false));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/source.csv")
    public void test_searchForContactByNumber(String number, String expected) {
        // given:
        String result = sut.searchForContactByNumber(number);
        // then:
        assertThat(result, equalTo(expected));
    }

    @Test
    public void test_searchForContactByNumber_whenNotEqual_thenCorrect() {
        // given:
        String number = "89570420645", expected = "Контакт с таким номером отсутствует";
        // when:
        String result = sut.searchForContactByNumber(number);
        // then:
        assertThat(result, not(expected));
    }

}