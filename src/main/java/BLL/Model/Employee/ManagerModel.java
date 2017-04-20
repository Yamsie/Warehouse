package BLL.Model.Employee;

import DAL.DatabaseService.AccessEmployees;
import DAL.DatabaseService.DatabaseService;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by James on 14/03/2017.
 */
public class ManagerModel extends Employee implements I_EmployeeModel{

        public ManagerModel(int id, String userName, String jobTitle, String email) {
            super( id, userName, jobTitle, email);
        }

        private List<Employee> employeeOutput = new ArrayList<Employee>();
        private DatabaseService employees = new AccessEmployees();

        public String[][] getEmployeeData() {
            List<String> employeeText = employees.getData();
            String[][] elements = new String[employeeText.size()][5];

            for (int i = 0; i < employeeText.size(); i++) {
                elements[i] = employeeText.get(i).split(",");
            }

            return elements;
        }

        public void addNewEmployee(String id, String name, char[] pass, String job, String email) {
            String newRow = id + "," + name + "," + pass.toString() + "," + job + "," + email;
            employees.addData(newRow);
        }

}