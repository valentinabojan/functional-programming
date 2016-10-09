package session3.solution.file_logic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileManagement {

    // TODO 4: Get all the file paths from source directory (recursively) that have a certain extension
    // Hint: study Files.walk() method
    public List<Path> getFiles(String sourceDirectory, String extension) throws IOException {
        return Files
                .walk(Paths.get(sourceDirectory))
                .filter(path -> path.toString().endsWith(extension))
                .collect(Collectors.toList());
    }
}
