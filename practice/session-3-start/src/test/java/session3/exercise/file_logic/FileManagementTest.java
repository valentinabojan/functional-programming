package session3.exercise.file_logic;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class FileManagementTest {

    private static final String SEPARATOR = File.separator;

    @Test
    public void givenASourceDirectoryAndAnExtension_whenGettingFilesRecursively_thenTheCorrectFilesAreReturned() throws IOException {
        List<Path> expectedResult = asList(
                "." + SEPARATOR + "src" + SEPARATOR + "main" + SEPARATOR + "java" + SEPARATOR + "session3" + SEPARATOR + "exercise" + SEPARATOR + "business_logic" + SEPARATOR + "EmployeeComparatorBuilder.java",
                "." + SEPARATOR + "src" + SEPARATOR + "main" + SEPARATOR + "java" + SEPARATOR + "session3" + SEPARATOR + "exercise" + SEPARATOR + "business_logic" + SEPARATOR + "EmployeeManagement.java",
                "." + SEPARATOR + "src" + SEPARATOR + "main" + SEPARATOR + "java" + SEPARATOR + "session3" + SEPARATOR + "exercise" + SEPARATOR + "entity" + SEPARATOR + "Employee.java",
                "." + SEPARATOR + "src" + SEPARATOR + "main" + SEPARATOR + "java" + SEPARATOR + "session3" + SEPARATOR + "exercise" + SEPARATOR + "entity" + SEPARATOR + "Genre.java",
                "." + SEPARATOR + "src" + SEPARATOR + "main" + SEPARATOR + "java" + SEPARATOR + "session3" + SEPARATOR + "exercise" + SEPARATOR + "file_logic" + SEPARATOR + "FileManagement.java",
                "." + SEPARATOR + "src" + SEPARATOR + "main" + SEPARATOR + "java" + SEPARATOR + "session3" + SEPARATOR + "exercise" + SEPARATOR + "stream_logic" + SEPARATOR + "StreamLogic.java",
                "." + SEPARATOR + "src" + SEPARATOR + "test" + SEPARATOR + "java" + SEPARATOR + "session3" + SEPARATOR + "exercise" + SEPARATOR + "business_logic" + SEPARATOR + "EmployeeComparatorBuilderTest.java",
                "." + SEPARATOR + "src" + SEPARATOR + "test" + SEPARATOR + "java" + SEPARATOR + "session3" + SEPARATOR + "exercise" + SEPARATOR + "business_logic" + SEPARATOR + "EmployeeManagementTest.java",
                "." + SEPARATOR + "src" + SEPARATOR + "test" + SEPARATOR + "java" + SEPARATOR + "session3" + SEPARATOR + "exercise" + SEPARATOR + "file_logic" + SEPARATOR + "FileManagementTest.java",
                "." + SEPARATOR + "src" + SEPARATOR + "test" + SEPARATOR + "java" + SEPARATOR + "session3" + SEPARATOR + "exercise" + SEPARATOR + "stream_logic" + SEPARATOR + "StreamLogicTest.java",
                "." + SEPARATOR + "src" + SEPARATOR + "test" + SEPARATOR + "java" + SEPARATOR + "StreamFilterTest.java"
        ).stream().map(Paths::get).collect(toList());

        List<Path> actualResult = new FileManagement().getFiles("./src", ".java");

        assertThat(actualResult).containsAll(expectedResult);
    }
}