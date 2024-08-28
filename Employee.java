public class Employee {
    private String name;
    private int id;
    private String position;

    // Constructor
    public Employee(String name, int id, String position) {
        this.name = name;
        this.id = id;
        this.position = position;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee ID: " + id + ", Name: " + name + ", Position: " + position;
    }
}
