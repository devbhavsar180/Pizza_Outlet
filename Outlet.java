import java.util.ArrayList;

public class Outlet {
    private String name;
    private String address;
    private ArrayList<Employee> employees;

    // Constructor
    public Outlet(String name, String address) {
        this.name = name;
        this.address = address;
        this.employees = new ArrayList<>();
    }

    // Add an employee to the outlet
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Display outlet details
    public void displayDetails() {
        System.out.println("Outlet Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Employees: ");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
}
