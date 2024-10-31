package OnlineQuizPortal; // Update the package

import OnlineQuizPortal.Student; // Import the correct package
import OnlineQuizPortal.QuestionManager; // Import the correct package
import OnlineQuizPortal.Question; // Import the correct package

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class QuizWindow extends JFrame {
    private Student student;
    private QuestionManager questionManager;
    private ArrayList<Question> questions;
    private int currentQuestionIndex = 0;
    private int correctAnswers = 0;

    private JTextArea questionArea;
    private JTextField answerField;
    private JButton nextButton;
    private JLabel statusLabel;

    public QuizWindow(Student student, QuestionManager questionManager) {
        this.student = student;
        this.questionManager = questionManager;

        // Filter questions based on student's subject and difficulty
        questions = questionManager.getQuestionsBySubjectAndDifficulty(student.getSubject(), student.getDifficulty());

        setTitle("Quiz for " + student.getName());
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout
        setLayout(new GridLayout(4, 1));

        // Question Area
        questionArea = new JTextArea(3, 20);
        questionArea.setEditable(false);
        add(new JScrollPane(questionArea));

        // Answer Field
        answerField = new JTextField();
        add(answerField);

        // Next Button
        nextButton = new JButton("Next");
        add(nextButton);

        // Status Label
        statusLabel = new JLabel("Answer the question.");
        add(statusLabel);

        // Display the first question
        displayQuestion();

        // Add action listener for "Next" button
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
                if (currentQuestionIndex < questions.size() - 1) {
                    currentQuestionIndex++;
                    displayQuestion();
                } else {
                    statusLabel.setText("Quiz completed! Correct answers: " + correctAnswers);
                    nextButton.setEnabled(false);
                }
            }
        });
    }

    // Display the current question
    private void displayQuestion() {
        Question currentQuestion = questions.get(currentQuestionIndex);
        questionArea.setText(currentQuestion.getQuestionText());
        answerField.setText("");
    }

    // Check the answer provided by the user
    private void checkAnswer() {
        String userAnswer = answerField.getText().trim();
        String correctAnswer = questions.get(currentQuestionIndex).getAnswer().trim();

        if (userAnswer.equalsIgnoreCase(correctAnswer)) {
            correctAnswers++;
        }
    }
}
