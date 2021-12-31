import java.util.Optional;
import java.util.stream.Stream;

public class PhoneBookCrawler {

    private PhoneBook phoneBook;

    public PhoneBookCrawler(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    public String findPhoneNumberByNameAndPunishIfNothingFound(String name){
        return phoneBook.findPhoneNumberByName(name).orElseThrow(()->new IllegalArgumentException("No phone number found"));
    }

    public String findPhoneNumberByNameAndPrintPhoneBookIfNothingFound(String name){
        return phoneBook.findPhoneNumberByName(name).orElse(phoneBook.toString());
    }
    public Optional<String> findPhoneNumberByName(String name){
        return Stream.of(phoneBook)
                .map(phoneBook1 -> Optional.ofNullable(phoneBook1.getPhone()
                        .get(name)))
                .findFirst().orElse(Optional.empty());
    }

    public String findPhoneNumberByNameAndPrintPhoneBookIfNothingFoundByStreams(String name){
        return Stream.of(phoneBook)
                .map(phoneBook1 -> Optional.ofNullable(phoneBook1
                        .getPhone()
                        .get(name)).orElse(phoneBook1.toString()))
                .findFirst().get();
    }
    public String findPhoneNumberByNameOrNameByPhoneNumber(String name,String phoneNumber){
        return Stream.of(phoneBook.findPhoneNumberByName(name),phoneBook.findNameByPhoneNumber(phoneNumber))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst().get();
    }

}