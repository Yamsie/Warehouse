package BLL.Models.Employees;

import org.glassfish.jersey.model.internal.RankedComparator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by James on 14/03/2017.
 */
public class ManagerModel /*extends Employee*/ implements I_EmployeeModel{
        /*private String jobTitle;

        public ManagerModel(String userName, int id, String email) {
            super(userName, id, email);
            jobTitle = "Manager";
        }

        public String getJobTitle() {
            return jobTitle;
        } */
        private List<Employee> employeeOutput = new ArrayList<>();
        private Employee employeeJohn;
        private Employee employeeMary;
        private Employee employeeBob;
        private Employee employeeSteve;
        private Employee employeeTom;
        //private Order order;
        //private Customer customer

        public String[][] getEmployeeData() {
            employeeJohn    = new Employee("John", 12345678, "john@johnmail.john");
            employeeMary    = new Employee("Mary", 87654321, "mary@johnmail.john");
            employeeBob     = new Employee("Bob", 87651234, "bob@johnmail.john");
            employeeSteve   = new Employee("Steve", 43215678, "steve@johnmail.john");
            employeeTom     = new Employee("Tom", 55555555, "tom@johnmail.john");

            employeeOutput = new ArrayList<Employee>();
            employeeOutput.add(employeeJohn);
            employeeOutput.add(employeeMary);
            employeeOutput.add(employeeBob);
            employeeOutput.add(employeeSteve);
            employeeOutput.add(employeeTom);

            String output[][] = new String[employeeOutput.size()][3];

            for(int i = 0; i < employeeOutput.size(); i++) {
                String nextLine = employeeOutput.get(i).getName() + " " + employeeOutput.get(i).getId() + " " + employeeOutput.get(i).getEmail();
                output[i] = nextLine.split(" ");
            }

            return output;
        }

        /*public ArrayList<> getCustomerData() {
            return "Customer Data";

        }

        public ArrayList<String> getOrderData() {
            return "Order Data";

        } */

}
