package Main;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        IDandPasswords idandPasswords = new IDandPasswords();
        LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());

    }
}
