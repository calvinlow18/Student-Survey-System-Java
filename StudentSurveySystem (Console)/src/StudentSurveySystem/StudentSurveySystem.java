package StudentSurveySystem;

public class StudentSurveySystem extends Inheritance {
    
    public static void main(String[] args) throws Exception{
        
        FormFunction formFunction = new FormFunction();
        formFunction.readQuestion();
        formFunction.readSurvey();
        int user = 0;
        Administrator admin = new Administrator();
        admin.read(); 
        do{
            clearScreen();
            System.out.println("Who are you?");
            System.out.println("1 Administrator");
            System.out.println("2 Student");
            System.out.println("0 Exit system");
            user = errorTest(0, 2);
            clearScreen();
            switch(user) {
            case 1:
                admin.login();
                break;
            case 2:
                do {
                    Student student = new Student();
                    student.chooseSubject();
                } while (repeat);
                break;
            }
            repeat = (user != 0);
        } while (repeat);
        formFunction.writeSurvey();
    }
}
