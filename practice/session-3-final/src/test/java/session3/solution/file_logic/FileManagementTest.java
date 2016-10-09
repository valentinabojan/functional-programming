package session3.solution.file_logic;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class FileManagementTest {

    @Test
    public void givenASourceDirectoryAndAnExtension_whenGettingFilesRecursively_thenTheCorrectFilesAreReturned() throws IOException {
        List<Path> expectedResult = asList(
                ".\\src\\main\\java\\session3\\solution\\business_logic\\EmployeeComparatorBuilder.java",
                ".\\src\\main\\java\\session3\\solution\\business_logic\\EmployeeManagement.java",
                ".\\src\\main\\java\\session3\\solution\\entity\\Employee.java",
                ".\\src\\main\\java\\session3\\solution\\entity\\Genre.java",
                ".\\src\\main\\java\\session3\\solution\\file_logic\\FileManagement.java",
                ".\\src\\main\\java\\session3\\solution\\stream_logic\\StreamLogic.java",
                ".\\src\\test\\java\\session3\\solution\\business_logic\\EmployeeComparatorBuilderTest.java",
                ".\\src\\test\\java\\session3\\solution\\business_logic\\EmployeeManagementTest.java",
                ".\\src\\test\\java\\session3\\solution\\file_logic\\FileManagementTest.java",
                ".\\src\\test\\java\\session3\\solution\\stream_logic\\StreamLogicTest.java",
                ".\\src\\test\\java\\StreamFilterTest.java"
        ).stream().map(Paths::get).collect(toList());

        List<Path> actualResult = new FileManagement().getFiles("./src", ".java");

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}