package BLL.Authentication;

import java.io.IOException;
import java.util.Scanner;
/**
 * Created by Lenovo on 2017/3/12.
 */
public interface  Authentication {
    void check(String userName, String passWord) throws Exception;
    void pageLoading(boolean temp, String typeOfJob, String Name);
}


