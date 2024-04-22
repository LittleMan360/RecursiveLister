import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class RecursiveLister extends JFrame {
    private JButton startButton = new JButton("Start");
    private JButton quitButton = new JButton("Quit");
    private JTextArea textArea = new JTextArea();
    private JScrollPane scrollPane = new JScrollPane(textArea);

    public RecursiveLister() {
        setLayout(new BorderLayout());
        add(new JLabel("Recursive File Lister"), BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(quitButton);
        add(buttonPanel, BorderLayout.SOUTH);

        startButton.addActionListener((ActionEvent e) -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                listFiles(selectedFile);
            }
        });

        quitButton.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
    }


}