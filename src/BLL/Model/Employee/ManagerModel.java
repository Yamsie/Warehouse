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
        /*private String jobTitle;

        public ManagerModel(String userName, int id, String email) {
            super(userName, id, email);
            jobTitle = "Manager";
        }
*/

        private List<Employee> employeeOutput = new ArrayList<>();
        private DatabaseService employees = new AccessEmployees(this.getJobTitle());
        private Employee employeeJohn;
        private Employee employeeMary;
        private Employee employeeBob;
        private Employee employeeSteve;
        private Employee employeeTom;
        //private Order order;
        //private Customer customer

        public String[][] getEmployeeData() {
            List<String> employeeText = employees.getData();
            String[][] elements = new String[employeeText.size()][5];

            for (int i = 0; i < employeeText.size(); i++) {
                elements[i] = employeeText.get(i).split(",");
                //employeeData.add(new Employee(Integer.parseInt(elements[0]), elements[1], elements[3], elements[4]));
            }

            return elements;
        }

        public void addNewEmployee(String id, String name, char[] pass, String job, String email) {
            String newRow = id + "," + name + "," + pass.toString() + "," + job + "," + email;
            employees.addData(newRow);
        }

        /*public ArrayList<> getCustomerData() {
            return "Customer Data";

        }

        public ArrayList<String> getOrderData() {
            return "Order Data";

        } */

}