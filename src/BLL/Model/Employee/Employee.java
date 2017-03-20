package BLL.Model.Employee;

/**
 * Created by James on 16/03/2017.
 */
public class Employee {

    private String name;
    private int id;
    private String email;

    Employee() {
    }

    Employee(String newName, int newId, String newEmail) {
        name = newName;
        id = newId;
        email = newEmail;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
