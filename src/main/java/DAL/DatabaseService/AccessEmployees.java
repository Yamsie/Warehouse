package DAL.DatabaseService;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by James on 20/03/2017.
 */
public class AccessEmployees extends DatabaseService {

    public AccessEmployees() {
        super("data/EMPLOYEES.txt");
    }
}
