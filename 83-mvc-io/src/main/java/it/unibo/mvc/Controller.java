package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {
    /**
     * Set the next string to be printed.
     * @param s
     * @throws NullPointerException
     */
    void setNextString(String s);
    /**
     * Get the next string to be printed.
     * @return the next string to be printed
     */
    String getNextString();
    /**
     * Get the history of the strings printed.
     * @return the history of the strings printed
     */
    List<String> getStringHistory();
    /**
     * Print the current string.
     * @throws IllegalStateException
     */
    void printCurrentString(); 
}
