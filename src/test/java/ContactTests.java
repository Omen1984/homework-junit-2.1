import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.samePropertyValuesAs;

public class ContactTests {

    @Test
    public void test_whenToStringReturnsRequiredString_thenCorrect() {
        // given:
        Contact contact = new Contact("Иван", "89874356792");
        // when:
        String toString = contact.getName() + " - " + contact.getNumber();
        // then:
        assertThat(contact, hasToString(toString));
    }

    @Test
    public void test_whenHavingSameValues_thenCorrect() {
        // given:
        Contact contact1 = new Contact("Иван", "89874356792");
        Contact contact2 = new Contact("Иван", "89874356792");
        // then:
        assertThat(contact1, samePropertyValuesAs(contact2));
    }

}
