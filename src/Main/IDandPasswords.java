package Main;

import java.util.HashMap;
public class IDandPasswords {
    HashMap<String, String> loginInfo = new HashMap<String, String>();
    IDandPasswords(){
        loginInfo.put("Admin", "123");
        loginInfo.put("Ashley", "123");
    }

    protected HashMap getLoginInfo(){
        return loginInfo;
    }

}
