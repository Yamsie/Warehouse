package BLL.Authentication;

import java.io.IOException;
import java.util.Scanner;
/**
 * Created by Jiasen on 2017/3/12.
 */
public interface  Authentication {
    void check(String userName, char[] passWord);
    void pageLoading(boolean temp, UserDetails details);
}


