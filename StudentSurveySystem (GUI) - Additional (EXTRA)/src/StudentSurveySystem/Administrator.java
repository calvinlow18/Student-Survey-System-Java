package StudentSurveySystem;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Administrator extends Inheritance {
    
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
        
    public boolean read() throws Exception {
        File file = new File("adminPass.txt");
        boolean test = true;
        if (!file.exists() || file.length() == 0) {
            file.createNewFile();
            AdministratorMenu am = new AdministratorMenu();
            test = am.callSetPass();
            if (test == true) {
                password = am.getPassword();
                write();
            }
            return test;
        } else {
            Scanner fileIn = new Scanner(file);
            this.password = fileIn.nextLine();
            return true;
        }
        
    }
    
    public void write() throws Exception {
        PrintWriter pw = new PrintWriter("adminPass.txt");
        pw.println(this.password);
        pw.close();
    }
    
}
