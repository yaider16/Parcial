package Model;

public class Student extends Assistant implements IPerson{
    private int code;
    private int age;

    public Student(int id, String firstName, String lastName, int code, int age) {
        super(id, firstName, lastName);
        this.code = code;
        this.age = age;
    }


    @Override
    public String fullName() {
        return "Est. "+ getFirstName() + " " + getLastName();
    }

    @Override
    public boolean isAdult() {
        return this.age >= 18;
    }
}
