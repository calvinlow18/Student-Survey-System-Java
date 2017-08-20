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
    
    public void chooseOption() throws Exception {
        printOption();
        int adminOption = errorTest(0, 4);
        switch (adminOption) {
            case 1:
                DataAnalysis da = new DataAnalysis();
                da.courseAnalysis();
                break;
            case 2:
                FormFunction ff = new FormFunction();
                do {
                    clearScreen();
                } while (ff.printEdit());
                ff.writeQuestion();
                break;
            case 3:
                record.clear();
                break;
            case 4:
                clearScreen();
                newPass();
                break;
        }
        repeat = (adminOption != 0);
    }
    
    public void login() throws Exception {
        
        do {
            System.out.println("Please enter administrator password. (Enter 'quit' to return)");
            Scanner input = new Scanner(System.in);
            String typedPass = input.nextLine();
            if (typedPass.contentEquals(this.password)) {
                do {
                    chooseOption();
                } while (repeat);
            } else if(typedPass.contentEquals("quit")) {
                repeat = false;
            } else
                repeat = true;
        } while (repeat);
    }
    
    public void printOption() throws Exception {
        clearScreen();
        System.out.println("Welcome administrator. What do you want to do?");
        System.out.println("1 Data Analysis");
        System.out.println("2 Edit Survey Questions");
        System.out.println("3 Reset Survey");
        System.out.println("4 Change Password");
        System.out.println("0 Quit");
    }
    
    public void read() throws Exception {
        File file = new File("adminPass.txt");
        Scanner input = new Scanner(System.in);
        if (!file.exists() || file.length() == 0) {
            file.createNewFile();
            String pass;
            do {
                System.out.print("Set your administrator password: ");
                pass = input.nextLine();
            }while (pass.matches("quit"));
            setPassword(pass);
            write();
        } else {
            Scanner fileIn = new Scanner(file);
            this.password = fileIn.nextLine();
        }
    }
    
    public void write() throws Exception {
        PrintWriter pw = new PrintWriter("adminPass.txt");
        pw.println(this.password);
        pw.close();
    }
    
    public void newPass() throws Exception {
        Scanner input = new Scanner(System.in);
        String newPass, repPass;
        do{
            System.out.println("Enter your new password");
            newPass = input.nextLine();
            System.out.println("Repeat your new password");
            repPass = input.nextLine();
        } while(!repPass.contentEquals(newPass) || newPass.contentEquals("quit"));
        setPassword(newPass);
        write();
    }
}
