package StudentSurveySystem;

public class DataAnalysis extends Inheritance {
    
    private int[] Gender = new int[2];
    private int[] Age = new int[11];
    private int[][] Feedback = new int[5][6];
    private int genderOption;
    private int quesLength;
    private String subid;

    
    
    public void setGenderOption(int genderOption) {
        this.genderOption = genderOption;
    }

    public void setSubid(String subid) {
        this.subid = subid;
    }
    
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
        GenderAnalysis();
        String header = String.format("%6s%9s%6s%14s%6s%6s%6s%6s%6s\n","ID", "Gender", "Age", "Course", "Q1", "Q2", "Q3", "Q4", "Q5");
        System.out.println(header);
        
        switch(genderOption) {
            case 1:
                for (Form x : record) {
                    if (x.getGender() == 'M' && x.getCourse().contentEquals(subid))
                        System.out.println(String.format("%6s", x.getId()) + x);
                }
                System.out.print("\nTotal : " + Gender[0]);
                break;
            case 2:
                for (Form x : record) {
                    if (x.getGender() == 'F' && x.getCourse().contentEquals(subid))
                        System.out.println(String.format("%6s", x.getId()) + x);
                }
                System.out.print("\nTotal : " + Gender[1]);
                break;
            case 3:
                for (Form x : record)
                    if (x.getCourse().contentEquals(subid))
                        System.out.println(String.format("%6s", x.getId()) + x);
                System.out.print("\nTotal : " + (Gender[0]+Gender[1]));
                break;
        }
        
    }
    
    public void generateReport() {
        for(int i=0;i<5;i++) {
            if (question[i].length()>quesLength)
                quesLength = question[i].length();
        }
        GenderAnalysis();
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
}
