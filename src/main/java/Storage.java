import java.io.*;
import java.nio.file.*;

public class Storage {
    private final Path filePath;

    public Storage(String filePath) {
        this.filePath = Paths.get(filePath);
        checkFileAndFolderExists();
    }

    private void checkFileAndFolderExists() {
        try {
            if (!Files.exists(filePath.getParent())) {
                Files.createDirectories(filePath.getParent());
            }
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            }
        } catch (IOException e) {
            System.err.println("Eh you got an error creating data file: " + e.getMessage());
        }
    }

    
}
