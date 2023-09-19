package Model;

public abstract class Assistant {
    private int id;
    private String firstName;
    private String lastName;

    public Assistant(int id, String name, String lastName) {
        this.id = id;
        this.firstName = name;
        this.lastName = lastName;
    }

    public abstract String fullName();

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return this.id;
    }
}
