import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Paths;

public class FileReaderHelperTest {

    private final FileReaderHelper fileReaderHelper = new FileReaderHelper();

    @ParameterizedTest
    @CsvSource(delimiter = ',', value = {
            "txt/testLastLine1.txt, apply 9",
            "txt/testLastLine2.txt, ''",
            "txt/testLastLine3.txt, Is the man who thinks he can."
    })
    public void shouldLoadLastLineFromFile(String path, String expectedLastLine) throws URISyntaxException {
        // given
        File file = new File(Paths.get(getClass().getClassLoader()
                .getResource(path).toURI()).toUri());

        // when
        String lastLine = fileReaderHelper.getLastLine(file);

        // then
        Assertions.assertThat(lastLine).isEqualTo(expectedLastLine);
    }
}
