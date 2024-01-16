package File;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileWriter {

    public FileWriter() {
        // Constructor
    }

    public String getFileName(String path) {
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

        return file.getName();
    }

    public void createFileInPackageAndWriteLines(String[][] code, String oldFilePath) {
        // Validate the path
        if (code[1] == null || code[1].length == 0) {
            throw new IllegalArgumentException("Invalid lines");
        }

        String newFileName = getFileName(oldFilePath) + ".compiled";
        String newFilePath = "Package/" + newFileName;

        // Create a File object
        File file = new File(newFilePath);
        // ...

        String[] newLines = code[1];
        for (int i = 0; i < newLines.length; i++) {
            if (onlyCosists(code[0][i], "0")) {
                newLines[i] = code[0][i];
                continue;
            }
            newLines[i] = newLines[i] + " -> " + code[0][i];
        }

        try {
            // Convert lines to byte array
            byte[] bytes = String.join("\n", newLines).getBytes();

            // Write all bytes to the file
            Path filePath = file.toPath();
            Files.write(filePath, bytes, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            // Handle IOException
            throw new RuntimeException("Error writing file", e);
        }
    }

    private Boolean onlyCosists(String input, String allowed) {
        for (int i = 0; i < input.length(); i++) {
            if (!allowed.contains(input.charAt(i) + "")) {
                return false;
            }
        }
        return true;
    }
}
