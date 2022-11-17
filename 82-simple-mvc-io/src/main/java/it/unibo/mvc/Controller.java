package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private File file;
    Controller() {
        this.file = new File(System.getProperty("user.home") + File.separator + "output.txt");
    }

    /**
     * set the file to write to.
     * @param file
     */
    void setFile(final  File file) {
        this.file = file;
    }

    /**
     * Get the file to write to.
     * @return the file to write to.
     *
     */
    File getFile() {
        return file;
    }
    /**
     * Get the file path.
     * @return the file path.
     */
    String getPath() {
        return file.getAbsolutePath();
    }

    /**
     * Write a String to the file.
     * @throws IOException
     *
     * @param s
     */
    void writeToFile(final String s) throws IOException {
        try (PrintStream ps = new PrintStream(file, StandardCharsets.UTF_8.name())) {
            ps.println(s);
        }
    }


}
