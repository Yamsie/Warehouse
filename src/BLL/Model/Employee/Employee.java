package BLL.Model.Employee;

/**
 * Created by James on 16/03/2017.
 */
public class Employee {

    private String name;
    private int id;
    private String email;
    private String jobTitle;

    Employee() {
    }

    Employee(int newId, String newName, String newJobTitle, String newEmail) {
        name = newName;
        id = newId;
        email = newEmail;
        jobTitle = newJobTitle;
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

    public String getJobTitle() {
        return jobTitle;
    }
}
