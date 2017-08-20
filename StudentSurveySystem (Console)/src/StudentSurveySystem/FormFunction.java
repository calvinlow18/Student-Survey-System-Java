package StudentSurveySystem;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class FormFunction extends Inheritance {

    public void readSurvey() throws Exception {
        File file = new File("database.txt");
        if (!file.exists()) {
            file.createNewFile();
        } else {
            Scanner fileIn = new Scanner(file);
            
            while(fileIn.hasNext()) {
                char rGen = fileIn.next().charAt(0);
                int rAge = fileIn.nextInt();
                
                String rCourse = fileIn.next();
                int[] feedArr = new int[5];
                int i = 0;
                while(fileIn.hasNextInt())
                    feedArr[i++] = fileIn.nextInt();
                
                record.add(new Form(rGen, rAge, rCourse, feedArr));
            }
            fileIn.close();
        }

    }
    
    public void writeSurvey() throws Exception {
        PrintWriter pw = new PrintWriter("database.txt");
        for (Form i : record) {
            pw.println(i);
        }
        pw.close();
    }
   
    public void readQuestion() throws Exception {
        File file = new File("question.txt");
        if (!file.exists()) {
            file.createNewFile();
            resetQues();
            writeQuestion();
        } else {
            Scanner fileIn = new Scanner(file);
            int i = 0;
            while(fileIn.hasNextLine()) {
                question[i++] = fileIn.nextLine();
            }    
            fileIn.close();
        }
    }
    
    public void writeQuestion() throws Exception {
        PrintWriter pw = new PrintWriter("question.txt");
        for (int i=0;i<question.length;i++)
            pw.println(question[i]);
        pw.close();
    }
    
    public boolean printEdit() {
        System.out.println("Which question do you want to edit?");
        for (int i=0;i<question.length;i++) {
            System.out.println( (i+1) + " " + question[i]);
        }
        System.out.println("0 Quit");
        
        int option = errorTest(0, question.length);
        Scanner input = new Scanner(System.in);
        if (option != 0) {
            System.out.println("Enter your question: ");
            question[option-1] = input.nextLine();
            return true;
        }
        return false;
        
    }
    
}
