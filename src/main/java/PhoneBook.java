import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PhoneBook {

    Map<String, String> phoneMap = new HashMap<>();

    public PhoneBook() {
        phoneMap.put("Shivam","9999988888");
        phoneMap.put("Rahul","7777888888");
    }

    public Map<String, String> getPhone() {
        return phoneMap;
    }

    public void setPhoneMap(Map<String, String> phoneMap) {
        this.phoneMap = phoneMap;
    }

    public Optional<String> findPhoneNumberByName(String name){
        if(phoneMap.containsKey(name)){
            return Optional.of(phoneMap.get(name)) ;
        }
        return Optional.empty();
    }

    public Optional<String> findNameByPhoneNumber(String phoneNumber) {
        for (Map.Entry<String, String> entry : phoneMap.entrySet()) {
            if (entry.getValue() == phoneNumber) {
                return Optional.of(entry.getKey());
            }
        }
        return Optional.empty();
    }

    @Override
    public String toString() {
        return "PhoneBook{ PhoneBook = "+phoneMap+"}";
    }
}