package BLL.Authentication;

import java.io.IOException;
import java.util.Scanner;
/**
 * Created by Lenovo on 2017/3/12.
 */
public interface  Authentication {
    public void check(String userName,String passWord) throws Exception;
    public void pageLoading(boolean temp, String typeOfJob, String Name);
}


