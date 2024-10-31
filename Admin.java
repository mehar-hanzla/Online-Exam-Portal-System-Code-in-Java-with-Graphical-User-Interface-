package OnlineQuizPortal;

public class Admin extends User {
    private QuestionManager questionManager;

    public Admin(String name, QuestionManager questionManager) {
        super(name);
        this.questionManager = questionManager;
    }

    @Override
    public void login() {
        System.out.println("Admin " + name + " logged in.");
    }

    public void addQuestion(String subject, String difficulty, String question, String answer) {
        questionManager.addQuestion(subject, difficulty, question, answer);
    }

    public void deleteQuestion(int index) {
        questionManager.deleteQuestion(index);
    }
}
