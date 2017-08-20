package StudentSurveySystem;

import com.sun.glass.events.KeyEvent;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.Scanner;

public class Inheritance {
    
    protected static ArrayList<Form> record = new ArrayList<Form>();
    protected static String[] question = new String[5];
    protected static boolean repeat;
    
    public void resetQues() {
        for (int i=0;i<5;i++) {
                question[i] = "Question " + (i+1);
        }
    }
    
    public static void clearScreen() throws Exception{
        Robot key = new Robot();
        key.keyPress(KeyEvent.VK_CONTROL);
        key.keyPress(KeyEvent.VK_L);
        key.keyRelease(KeyEvent.VK_CONTROL);
        key.keyRelease(KeyEvent.VK_L);
        Thread.sleep(50);
    }
    
    public static int errorTest(int min, int max) {
        Scanner input = new Scanner(System.in);
        int option = 0;
        do{
            if (min == 0)
                System.out.print("Enter Option : ");
            try {
                option = input.nextInt();
                input.nextLine();
                if (option>=min && option<=max)
                    repeat = false;
                else {
                    repeat = true;
                    if (min!=0)
                        break;
                    else
                        System.out.println("Please enter option between " + min + " and " + max + " only");
                }
            } catch(Exception e) {
                repeat = true;
                input.nextLine();
                if (min!=0)
                    break;
                else
                    System.out.println("Please enter option between " + min + " and " + max + " only");
            }
        } while(repeat);
        
        return option;
    }
    
    public static void cmdToQuit() {
        Scanner input = new Scanner(System.in);
        System.out.print("Press any key and ENTER to quit: ");
        input.next();
    }
    
    public int printCourse() {
            System.out.println("1 PRG1203 - Object Oriented Programming Fundamentals");
            System.out.println("2 CSC1202 - Computer Organisation");
            System.out.println("3 SEG1201 - Database Fundamentals");
            System.out.println("4 WEB1201 - Web Fundamentals");
            System.out.println("0 Exit");
            int option = errorTest(0, 4);
            return option;
    }
    
    public String assignCourse(int option) {
        switch (option) {
            case 1:
                return "PRG1203";
            case 2:
                return "CSC1202";
            case 3:
                return "SEG1201";
            case 4:
                return "WEB1201";
        }
        return "";
    }
}
