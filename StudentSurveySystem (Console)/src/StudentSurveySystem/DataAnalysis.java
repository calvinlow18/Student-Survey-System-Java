package StudentSurveySystem;

public class DataAnalysis extends Inheritance {
    
    private int[] Gender = new int[2];
    private int[] Age = new int[11];
    private int[][] Feedback = new int[5][6];
    private int genderOption;
    private int quesLength;
    private String subid;
    
    public void Initialise(){
        for(int i=0;i<11;i++) {
            Age[i] = 0;
        }
        for(int i=0;i<5;i++) {
            for (int j=0;j<6;j++) {
                Feedback[i][j] = 0;
            }
        }
    }
    
    public void GenderAnalysis() {
        Gender[0] = 0;
        Gender[1] = 0;
        
        for(Form x : record) {
            
            if (x.getCourse().matches(subid)) {
                if (x.getGender() == 'M')
                    ++Gender[0];
                else
                    ++Gender[1];
            }

        }
    }
    
    public void AgeAnalysis() {

        switch(genderOption) {
            case 1:
                for(Form x : record)
                    if (x.getGender() == 'M' && x.getCourse().contentEquals(subid))
                        ++Age[(int) ((x.getAge()) / 10)];
                break;
            case 2:
                for(Form x : record)
                    if (x.getGender() == 'F' && x.getCourse().contentEquals(subid))
                        ++Age[(int) ((x.getAge()) / 10)];
                break;
            case 3:
                for(Form x : record)
                    if(x.getCourse().contentEquals(subid))
                        ++Age[(int) ((x.getAge()) / 10)];
                break;
        }
    }
    
    public void fqAnalysis(int r) {
        switch(genderOption) {
            case 1:
                for(Form x : record)
                    if (x.getGender() == 'M' && x.getCourse().contentEquals(subid))
                        ++Feedback[r][x.getQues(r)];
                break;
            case 2:
                for(Form x : record)
                    if (x.getGender() == 'F' && x.getCourse().contentEquals(subid))
                        ++Feedback[r][x.getQues(r)];
                break;
            case 3:
                for(Form x : record)
                    if (x.getCourse().contentEquals(subid))
                        ++Feedback[r][x.getQues(r)];
                break;
        }
    }
    
    public void printAge(){
        AgeAnalysis();
        System.out.println("Age 1-9   : " + Age[0]);
        System.out.println("Age 10-19 : " + Age[1]);
        System.out.println("Age 20-29 : " + Age[2]);
        System.out.println("Age 30-39 : " + Age[3]);
        System.out.println("Age 40-49 : " + Age[4]);
        System.out.println("Age 50-59 : " + Age[5]);
        System.out.println("Age 60-69 : " + Age[6]);
        System.out.println("Age 70-79 : " + Age[7]);
        System.out.println("Age 80-89 : " + Age[8]);
        System.out.println("Age 90-99 : " + Age[9]);
        System.out.println("Age 100   : " + Age[10]);
    }
    
    public void printQues(int r) {
        fqAnalysis(r);
        System.out.println("Data Analysis for Question " + (r+1));
        for (int i=1;i<6;i++)
            System.out.println("Rate " + i + ": " + Feedback[r][i]);
    }
    
    public void printAll() {
        System.out.println("ID\tGender\tAge\tCourse\tQ1\tQ2\tQ3\tQ4\tQ5");
        
        switch(genderOption) {
            case 1:
                for (Form x : record) {
                    if (x.getGender() == 'M' && x.getCourse().contentEquals(subid))
                        System.out.println(x.getId() + "\t" + x);
                }
                break;
            case 2:
                for (Form x : record) {
                    if (x.getGender() == 'F' && x.getCourse().contentEquals(subid))
                        System.out.println(x.getId() + "\t" + x);
                }
                break;
            case 3:
                for (Form x : record)
                    if (x.getCourse().contentEquals(subid))
                        System.out.println(x.getId() + "\t" + x);
                break;
        }
    }
    
    public void generateReport() {
        for(int i=0;i<5;i++) {
            if (question[i].length()>quesLength)
                quesLength = question[i].length();
        }
        System.out.println("Overall Analysis for "+ subid + "\n");
        System.out.println("MALE\n");
        System.out.println("Number of male student : " + Gender[0]);
        System.out.println("Feedback from male student");
        genderOption = 1;
        report();
        System.out.println("FEMALE\n");
        System.out.println("\nNumber of female student : " + Gender[1]);
        System.out.println("Feedback from female student");
        genderOption = 2;
        report();
        System.out.println("ALL\n");
        System.out.println("\nNumber of students : " + (Gender[0]+Gender[1]));
        System.out.println("Feedback from all student");
        genderOption = 3;
        report();
    }
    
    public void report() {
        Initialise();
        printAge();
        for (int i=0;i<5;i++)
            fqAnalysis(i);
        space(quesLength);
        System.out.println("R1\t" + "R2\t"+ "R3\t" + "R4\t" + "R5");
        for (int i=0;i<5;i++) {
            System.out.print(question[i]);
            space(quesLength-question[i].length());
            for (int j=1;j<6;j++)
                System.out.print(Feedback[i][j] + "\t");
            System.out.println();
        }
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------------");
    }
    
    public void space(int s) {
        for(int i=0;i<s;i++)
            System.out.print(" ");
        System.out.print("\t");
    }
    
    public void mainAnalysis() throws Exception {
        do {
            clearScreen();
            System.out.println("Data Analysis for " + subid);
            System.out.println("1 Male");
            System.out.println("2 Female");
            System.out.println("3 All");
            System.out.println("4 Generate Report");
            System.out.println("0 Exit");
            genderOption = errorTest(0, 4);
            if (genderOption != 0) {
                quesAnalysis();
                repeat = true;
            } else {
                repeat = false;
            }
        } while(repeat);
        
    }
    
    public void courseAnalysis() throws Exception {
        do {
            clearScreen();
            System.out.println("Course Analysis (Total = " + record.size() +" student feedback(s))");
            int courseOption = printCourse();
            if (courseOption != 0) {
                subid = assignCourse(courseOption);
                GenderAnalysis();
                mainAnalysis();
                repeat = true;
            } else {
                repeat = false;
            }
        } while(repeat);
        
    }
    
    public void quesAnalysis() throws Exception {
        do {
            clearScreen();
            Initialise();
            if (genderOption>=1 && genderOption<=3) {
                switch(genderOption) {
                    case 1:
                        System.out.println("All Male students' Feedback(s) Analysis (Total Male student = " + Gender[0] + ")");
                        break;
                    case 2:
                        System.out.println("All Female students' Feedback(s) Analysis (Total Female student = " + Gender[1] + ")");
                        break;
                    case 3:
                        System.out.println("All Feedback(s) Analysis (Total = " + (Gender[0]+Gender[1]) + ")");
                        break;
                }
                System.out.println("1 Age");
                for (int i=0;i<question.length;i++) {
                    System.out.println( (i+2) + " " + "Question " + (i+1) + " : " + question[i]);
                }
                switch(genderOption) {
                    case 1:
                        System.out.println("7 List All Males' Feedback(s)");
                        break;
                    case 2:
                        System.out.println("7 List All Females' Feedback(s)");
                        break;
                    case 3:
                        System.out.println("7 List All Feedback(s)");
                        break;
                }
                System.out.println("0 Exit");
                int option2 = errorTest(0, 7);
                clearScreen();
                switch (option2) {
                    case 1:
                        printAge();
                        cmdToQuit();
                        break;
                    case 2:
                        printQues(0);
                        cmdToQuit();
                        break;
                    case 3:
                        printQues(1);
                        cmdToQuit();
                        break;
                    case 4:
                        printQues(2);
                        cmdToQuit();
                        break;
                    case 5:
                        printQues(3);
                        cmdToQuit();
                        break;
                    case 6:
                        printQues(4);
                        cmdToQuit();
                        break;
                    case 7:
                        printAll();
                        cmdToQuit();
                        break;
                    default:
                        break;
                }
                clearScreen();
                repeat = (option2 != 0);
            } else if (genderOption == 4) {
                generateReport();
                cmdToQuit();
            } else {
                break;
            }
            
        } while (repeat);
    }
}
