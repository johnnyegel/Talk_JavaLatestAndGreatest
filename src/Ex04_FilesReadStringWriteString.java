import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
        // Create a text reader, which may fail with a FileNotFoundException
        try (BufferedReader textReader = new BufferedReader(new FileReader(filename))) {
            StringBuilder str = new StringBuilder();

            // Read-line can throw IOException
            String line = textReader.readLine();
            while (line != null) {
                str.append(line).append("\n");
                line = textReader.readLine();
            }

            // Finalization of reader is handled for us
            return Optional.of(str.toString());
        }
        catch (IOException ex) {
            // Return empty if an exception happened
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
