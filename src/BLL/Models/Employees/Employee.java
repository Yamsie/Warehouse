package BLL.Models.Employees;

/**
 * Created by James on 16/03/2017.
 */
public class Employee {

    private String name;
    private int id;
    private String jobTitle;

    Employee() {
    }

    Employee(String newName, int newId, String newJobTitle) {
        name = newName;
        id = newId;
        jobTitle = newJobTitle;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getJobTitle() {
        return jobTitle;
    }
}
