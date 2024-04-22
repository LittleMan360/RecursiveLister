import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

//
public class RecursiveLister extends JFrame {

    // text area
    private final JTextArea textArea = new JTextArea();

    // constructor
    public RecursiveLister() {
        // set layout
        setLayout(new BorderLayout());
        add(new JLabel("Recursive File Lister"), BorderLayout.NORTH);
        // scroll pane
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        //  buttons
        JButton startButton = new JButton("Start");
        buttonPanel.add(startButton);
        JButton clearButton = new JButton("Clear");
        buttonPanel.add(clearButton);
        JButton quitButton = new JButton("Quit");
        buttonPanel.add(quitButton);
        add(buttonPanel, BorderLayout.SOUTH);


        // add action listeners
        startButton.addActionListener((ActionEvent e) -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                listFiles(selectedFile);
            }
        });

        // clear button clears the text area
        clearButton.addActionListener((ActionEvent e) -> textArea.setText(""));

        // quit button ends the program
        quitButton.addActionListener((ActionEvent e) -> System.exit(0));
    }

    // list files
    private void listFiles(File file) {
        textArea.append(file.getPath() + "\n");
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    listFiles(f);
                }
            }
        }
    }

    // main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RecursiveLister frame = new RecursiveLister();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setVisible(true);
        });
    }
}