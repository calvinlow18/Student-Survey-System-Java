package StudentSurveySystem;

import java.util.Scanner;

public class Student extends Inheritance {

    private char gen;
    private int age;
    private String course;
    
    public void printSurvey() throws Exception {
        clearScreen();
        System.out.println("Survey Subject : " + course);
        System.out.println();
        System.out.println("Your survey id is " + (record.size()+1) + ".\n");
        System.out.println();
        
        int[] fA = new int[5];
        
        for (int i=0;i<5;i++) {
            do {
                System.out.print(question[i] + " (1 - 5 ONLY) : ");
                fA[i] = errorTest(1, 5);
                System.out.println();
            } while (repeat);
            
        }
        record.add(new Form(gen, age, course, fA));
        System.out.println("Thank you :)");
        cmdToQuit();
    }
    
    public void chooseSubject() throws Exception {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("What is your gender? (M/F)");
            gen = input.next().charAt(0);
            input.nextLine();
            if (gen == 'M' || gen == 'F')
                repeat = false;
            else 
                repeat = true;
        } while (repeat);
        System.out.println();
        do {
            System.out.println("How old are you?");
            age = errorTest(1, 100);
        } while (repeat);
        System.out.println();
        
        do{
            clearScreen();
            System.out.println("Subject");
            int stuSub = printCourse();
            if (stuSub!=0) {
                course = assignCourse(stuSub);
                printSurvey();
                repeat = true;
            } else
                repeat = false;
        } while (repeat);
    }
    
}
