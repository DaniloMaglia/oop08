package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * A SimpleController for input output into the standard output.
 *
 */
public final class SimpleController implements Controller {
    private String currentString;
    private final List<String> stringHistory;

    /**
     * Create a new SimpleController.
     */
    public SimpleController() {
        this.stringHistory = new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setNextString(final String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        this.stringHistory.add(s);
        this.currentString = s;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public String getNextString() {
        return this.currentString;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getStringHistory() {
        // I create a copy of the list to avoid other classes to modify the list directly
        final List<String> copy = new ArrayList<>();
        for (final String s : this.stringHistory) {
            copy.add(s);
        }
        return copy;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void printCurrentString() {
        if (this.currentString == null) {
            throw new IllegalStateException();
        }
        System.out.println(this.currentString); //NOPMD
    }

}
