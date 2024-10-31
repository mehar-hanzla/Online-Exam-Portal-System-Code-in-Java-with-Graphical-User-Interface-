package OnlineQuizPortal;

public class Student extends User {
    private String subject;
    private String difficulty;

    public Student(String name) {
        super(name);
    }

    @Override
    public void login() {
        System.out.println("Student " + name + " logged in.");
    }

    public void selectSubject(String subject) {
        this.subject = subject;
    }

    public void selectDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getSubject() {
        return subject;
    }

    public String getDifficulty() {
        return difficulty;
    }
}
