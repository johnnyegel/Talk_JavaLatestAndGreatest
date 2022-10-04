package demo;

import java.io.*;
import java.util.Optional;

/**
 * Demonstrate try-with-resources from Java 9s
 */
public class Ex02_TryWithResources {

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
            // Create a text reader, which may fail with a FileNotFoundException
            BufferedReader textReader = new BufferedReader(new FileReader(filename));
            try {
                StringBuilder str = new StringBuilder();

                // Read-line can throw IOException
                String line = textReader.readLine();
                while (line != null) {
                    str.append(line).append("\n");
                    line = textReader.readLine();
                }

                return Optional.of(str.toString());
            } finally {
                // REALLY IMPORTANT to close our resource after use!
                textReader.close();
            }
        }
        catch (IOException ex) {
            // Return empty if an exception happened
            return Optional.empty();
        }
    }

    /**
     * Runs the demonstration
     * @param args we don't need no stinkin' args
     */
    public static void main(String[] args) {
        System.out.println("Example 01: Try with resources demonstration");
        System.out.println();

        Optional<String> text = loadExampleText("resources/exampletext.txt");
        System.out.println(text.orElse("... Bu-Bu :-/ ..."));
    }
}
