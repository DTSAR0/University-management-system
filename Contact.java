import java.io.Serializable;

public class Contact implements Serializable {

    private String email;
    private String phoneNumber;

    public Contact(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "email: " + email + ", phone: " + phoneNumber;
    }
}