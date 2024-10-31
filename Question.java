package OnlineQuizPortal;


public class Question {
    private String subject;
    private String difficulty;
    private String questionText;
    private String answer;

    public Question(String subject, String difficulty, String questionText, String answer) {
        this.subject = subject;
        this.difficulty = difficulty;
        this.questionText = questionText;
        this.answer = answer;
    }

    public String getSubject() {
        return subject;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getAnswer() {
        return answer;
    }
}
