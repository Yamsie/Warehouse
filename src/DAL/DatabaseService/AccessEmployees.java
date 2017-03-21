package DAL.DatabaseService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by James on 20/03/2017.
 */
public class AccessEmployees extends DatabaseService  {

    private String jobTitle;

    public AccessEmployees(String jobTitle) {
        super("data/EMPLOYEES.txt");
        this.jobTitle = jobTitle;
    }
}
