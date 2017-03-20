package BLL.Authentication;

/**
 * Created by James on 18/03/2017.
 */
public class UserDetails {
        private String userName;
        private char[] password;
        private int id;
        private String email;
        private String jobTitle;

        UserDetails(int newId, String newUser, char[] newPass, String newJobTitle, String newEmail) {
            id = newId;
            userName = newUser;
            password = newPass;
            jobTitle = newJobTitle;
            email = newEmail;
        }

        public String getUserName() {
            return userName;
        }

        protected char[] getPassword() {
            return password;
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
