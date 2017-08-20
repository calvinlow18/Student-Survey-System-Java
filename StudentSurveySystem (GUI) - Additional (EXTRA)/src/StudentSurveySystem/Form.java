package StudentSurveySystem;

public class Form {
    
    private static int surveyID = 0;
    private int id;
    private char gender;
    private int age;
    private String course;
    private int[] ques = new int[5];

    public Form(char gender, int age, String prog, int[] ques) {
        this.id = ++surveyID;
        this.gender = gender;
        this.age = age;
        this.course = prog;
        for(int i=0;i<5;i++)
            this.ques[i] = ques[i];
    }

    public int getId() {
        return id;
    }

    public char getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public int getQues(int q) {
        return ques[q];
    }

    public String getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return String.format("%9s%12s%14s%7d%7d%7d%7d%7d", gender, age, course, ques[0], ques[1], ques[2], ques[3], ques[4]);
    }
    
}
