import java.io.Serializable;

public class Person implements Serializable {

    private String firstName;
    private String lastName;
    private Contact contact; // composite attribute

    public Person(String firstName, String lastName, Contact contact) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Contact getContact() {
        return contact;
    }

    public void printData() {
        System.out.print("Data: " + firstName + " " + lastName + ", " + contact);
    }
}