package OnlineQuizPortal;  // Ensure that all files are in this package

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectPBL extends JFrame {
    private JTextField nameField;
    private JComboBox<String> subjectBox;
    private JComboBox<String> difficultyBox;
    private JButton loginButton;
    private QuestionManager questionManager;

    public ProjectPBL() {
        setTitle("Online Quiz Portal");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        questionManager = new QuestionManager(); // Initialize QuestionManager
        initializeQuestions(); // Add some predefined questions

        // Layout
        setLayout(new GridLayout(4, 2));

        // Name input
        add(new JLabel("Enter your name:"));
        nameField = new JTextField();
        add(nameField);

        // Subject selection
        add(new JLabel("Select Subject:"));
        String[] subjects = {"Java", "C++"};
        subjectBox = new JComboBox<>(subjects);
        add(subjectBox);

        // Difficulty selection
        add(new JLabel("Select Difficulty:"));
        String[] difficulties = {"Easy", "Hard"};
        difficultyBox = new JComboBox<>(difficulties);
        add(difficultyBox);

        // Login button
        loginButton = new JButton("Login as Student");
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String subject = subjectBox.getSelectedItem().toString();
                String difficulty = difficultyBox.getSelectedItem().toString();

                // Start quiz for student
                Student student = new Student(name);
                student.selectSubject(subject);
                student.selectDifficulty(difficulty);
                QuizWindow quizWindow = new QuizWindow(student, questionManager); // No need to import
                quizWindow.setVisible(true);
                dispose(); // Close login window
            }
        });

        // Set visibility
        setVisible(true);
    }

    // Predefined questions
    private void initializeQuestions() {
        questionManager.addQuestion("Java", "Easy", "What is Java?", "Programming Language");
        questionManager.addQuestion("Java", "Hard", "What is JVM?", "Java Virtual Machine");
        questionManager.addQuestion("C++", "Easy", "What is a class?", "Blueprint for objects");
        questionManager.addQuestion("C++", "Hard", "What is polymorphism?", "Ability to take many forms");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProjectPBL();
            }
        });
    }
}
