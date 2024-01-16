package File;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader {

    public FileReader() {
        // Constructor
    }

    public String[] getLinesMayFile(String path) {
        // Validate the path
        if (path == null || path.isEmpty() || !path.endsWith(".may")) {
            throw new IllegalArgumentException("Invalid path");
        }

        // Create a File object
        File file = new File(path);

        // Check if the file exists
        if (!file.exists()) {
            throw new IllegalArgumentException("File does not exist");
        }

        try {
            // Read all lines from the file
            Path filePath = file.toPath();
            List<String> lines = Files.readAllLines(filePath);

            // Convert the List to an array and return
            return lines.toArray(new String[0]);
        } catch (IOException e) {
            // Handle IOException
            throw new RuntimeException("Error reading file", e);
        }
    }
}
