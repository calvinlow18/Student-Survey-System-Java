package StudentSurveySystem;

import java.util.ArrayList;

public class Inheritance {
    
    protected static ArrayList<Form> record = new ArrayList<Form>();
    protected static String[] question = new String[5];
    protected static String[] subject = {"PRG1203 - Object Oriented Programming Fundamentals", "CSC1202 - Computer Organisation", "SEG1201 - Database Fundamentals", "WEB1201 - Web Fundamentals"};

    public void resetQues() {
        for (int i=0;i<5;i++) {
                question[i] = "Question " + (i+1);
        }
    }
}
