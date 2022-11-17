package it.unibo.mvc;

import javax.swing.JFrame;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    private final SimpleController controller = new SimpleController();
    private static final int PROPORTION = 5;
    /**
     * Create a new SimpleGUI.
     */
    private SimpleGUI() {
        final JPanel mainPanel = new JPanel();
        final JPanel buttonPanel = new JPanel();
        final JTextArea textArea = new JTextArea();
        final JButton print = new JButton("Print");
        final JButton history = new JButton("Show history");
        mainPanel.setLayout(new BorderLayout());
        buttonPanel.setLayout(new BorderLayout());
        mainPanel.add(textArea, BorderLayout.CENTER);
        buttonPanel.add(print, BorderLayout.WEST);
        buttonPanel.add(history, BorderLayout.EAST);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        print.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent arg0) {
                controller.setNextString(textArea.getText());
                controller.printCurrentString();
            }
        });

        history.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent arg0) {
                final List<String> history = controller.getStringHistory();
                // I clear the text area before adding strings to it
                textArea.setText("");
                for (final String s : history) {
                    textArea.append(s + "\n");
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
