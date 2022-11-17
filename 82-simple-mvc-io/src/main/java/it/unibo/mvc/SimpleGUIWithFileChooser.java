package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.BorderLayout;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame();
    private static final int PROPORTION = 5;
    private final Controller controller = new Controller();

    /**
     * Create a new SimpleGUIWithFileChooser.
     */
    private SimpleGUIWithFileChooser() {
        final JPanel mainPanel = new JPanel();
        final JPanel buttonPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        buttonPanel.setLayout(new BorderLayout());
        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        final JTextArea textArea = new JTextArea();

        final JTextField pathText = new JTextField(controller.getPath());
        pathText.setEditable(false);
        final JButton browse = new JButton("Browse...");
        final JButton save = new JButton("Save");
        buttonPanel.add(pathText, BorderLayout.CENTER);
        buttonPanel.add(browse, BorderLayout.LINE_END);
        mainPanel.add(textArea, BorderLayout.CENTER);
        mainPanel.add(save, BorderLayout.SOUTH);
        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent arg0) {
                try {
                    controller.writeToFile(textArea.getText());
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(frame, e, "Error", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace(); // NOPMD: allowed as this is just an exercise
                }
            }

        });


        browse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent arg0) {
                //Open JFileChooser
                final JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Select a file");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                final int userSelection = fileChooser.showSaveDialog(frame);
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    controller.setFile(fileChooser.getSelectedFile());
                    pathText.setText(controller.getPath());
                } else if (userSelection == JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(frame, "No file selected", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        });
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("SimpleGUI");
    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setLocationByPlatform(true);
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setVisible(true);
    }

    /**
     * Launch the application.
     * @param args ignored
     */
    public static void main(final String[] args) {
        new SimpleGUIWithFileChooser().display();
    }
}
