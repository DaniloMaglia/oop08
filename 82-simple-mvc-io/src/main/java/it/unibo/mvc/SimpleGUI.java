package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

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
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    private static final int PROPORTION = 5;
    private final Controller controller = new Controller();
    /**
     * Create a new SimpleGUI.
     */
    private SimpleGUI() {
        final JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        final JTextArea textArea = new JTextArea();
        final JButton save = new JButton("Save");
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

        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("SimpleGUI");
    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
    /**
     * Launch the application.
     * @param args ignored
     */
    public static void main(final String[] args) {
        new SimpleGUI().display();
    }

}
