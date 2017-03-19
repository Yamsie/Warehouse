package BLL.Models.Employees;

/**
 * Created by James on 14/03/2017.
 */
public class ManagerModel extends Employee implements I_EmployeeModel{
        private String jobTitle;

        public ManagerModel(String userName, int id, String email) {
            super(userName, id, email);
            jobTitle = "Manager";
        }

        public String getJobTitle() {
            return jobTitle;
        }

}
