package demo.solutions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

/**
 * Demonstrates simplification of reading and writing text files
 * Further simplification from example 02
 */
public class Ex04_FilesReadStringWriteString {

    /**
     * Loads the example file as a String and returns it
     *
     * If anything goes wrong, and optional empty is returned in stead
     *
     * @param filename The filename to load
     * @return The file as a String
     */
    static Optional<String> loadExampleText(String filename) {
        try {
            return Optional.of(Files.readString(Path.of(filename)));
        } catch (IOException e) {
            return Optional.empty();
        }
    }

    /**
     * Runs the demonstration
     * @param args for cranks
     */
    public static void main(String[] args) {
        System.out.println("Example 01: Try with resources demonstration");
        System.out.println();

        Optional<String> text = loadExampleText("resources/exampletext.txt");
        System.out.println(text.orElse("... Boo-Boo :-/ ..."));
    }
}
