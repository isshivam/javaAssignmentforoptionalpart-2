import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


public class PhoneBookTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private final PhoneBook phoneBookTest = new PhoneBook();

    @Test
    public void findPhoneNumberByName_CorrectIfFound() {
        Optional<String> phoneNumber = phoneBookTest.findPhoneNumberByName("Shivam");
        assertThat(phoneNumber.get()).isEqualTo("9999988888");
    }

    @Test
    public void findPhoneNumberByName_CorrectIfNotFound(){
        expectedException.expect(NoSuchElementException.class);
        Optional<String> phoneNumber = phoneBookTest.findPhoneNumberByName("piyush");
        phoneNumber.get();
    }

    @Test
    public void findNameByPhoneNumber_CorrectIfFound(){
        Optional<String> name = phoneBookTest.findNameByPhoneNumber("7777888888");
        assertThat(name.get()).isEqualTo("Rahul");
    }

    @Test
    public void findNameByPhoneNumber_CorrectIfNotFound(){
        expectedException.expect(NoSuchElementException.class);
        Optional<String> phoneNumber = phoneBookTest.findNameByPhoneNumber("6667778899");
        phoneNumber.get();
    }
}
