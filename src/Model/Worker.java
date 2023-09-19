package Model;

public class Worker extends Assistant{

    private int salary;
    private Dependency dependency;

    public Worker(int id, String firstName, String lastName, int salary, Dependency dependency) {
        super(id, firstName, lastName);
        this.salary = salary;
        this.dependency = dependency;
    }

    @Override
    public String fullName() {
        return "Sr(a) " + getFirstName() + " " + getLastName();
    }

    public Dependency getDependency() {
        return this.dependency;
    }
}
