package OnlineQuizPortal;

import java.util.ArrayList;

public class QuestionManager {
    private ArrayList<Question> questions;

    public QuestionManager() {
        questions = new ArrayList<>();
    }

    public void addQuestion(String subject, String difficulty, String questionText, String answer) {
        questions.add(new Question(subject, difficulty, questionText, answer));
    }

    public void deleteQuestion(int index) {
        if (index >= 0 && index < questions.size()) {
            questions.remove(index);
        }
    }

    public ArrayList<Question> getQuestionsBySubjectAndDifficulty(String subject, String difficulty) {
        ArrayList<Question> filteredQuestions = new ArrayList<>();
        for (Question q : questions) {
            if (q.getSubject().equalsIgnoreCase(subject) && q.getDifficulty().equalsIgnoreCase(difficulty)) {
                filteredQuestions.add(q);
            }
        }
        return filteredQuestions;
    }
}
