import java.util.HashMap;

public class IDandPasswords {


    HashMap<String, String> logininfo = new HashMap<String, String>();

    IDandPasswords() {
        //Creating Password and username for the program in a hasmap
        logininfo.put("Jacques", "password");
        logininfo.put("Julia", "Chi");
        logininfo.put("Morty", "sickDog");
    }
       protected HashMap getLogInfo(){
        return logininfo;
        }
 }

