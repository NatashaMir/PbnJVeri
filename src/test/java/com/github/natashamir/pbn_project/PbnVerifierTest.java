package com.github.natashamir.pbn_project;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PbnVerifierTest {


    @Test
    public void testActionVerifyVersion10(@TempDir Path tempDir) throws IOException {

        Path path = tempDir.resolve("result_checked_10.pbn");

        new PbnVerifier(false, "src/test/resources/correct_10.pbn", "-E"+path);

        List<String> expected = Files.readAllLines(Paths.get("src/test/resources/result_10.pbn"), StandardCharsets.ISO_8859_1);
        List<String> actual = Files.readAllLines(path, StandardCharsets.ISO_8859_1);

        assertEquals(expected, actual);
    }

    @Test
    public void testActionVerifyVersion20(@TempDir Path tempDir) throws IOException {

        Path path = tempDir.resolve("result_checked_20.pbn");

        new PbnVerifier(false, "src/test/resources/correct_20.pbn", "-E"+path, "-20");

        List<String> expected = Files.readAllLines(Paths.get("src/test/resources/result_20.pbn"), StandardCharsets.ISO_8859_1);
        List<String> actual = Files.readAllLines(path, StandardCharsets.ISO_8859_1);

        assertEquals(expected, actual);
    }

    @Test
    public void testActionVerifyVersion21(@TempDir Path tempDir) throws IOException {

        Path path = tempDir.resolve("result_checked_21.pbn");

        new PbnVerifier(false, "src/test/resources/correct_21.pbn", "-E"+path, "-21");

        List<String> expected = Files.readAllLines(Paths.get("src/test/resources/result_21.pbn"), StandardCharsets.ISO_8859_1);
        List<String> actual = Files.readAllLines(path, StandardCharsets.ISO_8859_1);

        assertEquals(expected, actual);
    }

    @Test
    public void testActionVerifyDifferentVersion(@TempDir Path tempDir) throws IOException {

        Path path = tempDir.resolve("result_checked_10_21.pbn");

        new PbnVerifier(false, "src/test/resources/correct_10.pbn", "-E"+path, "-21");

        List<String> expected = Files.readAllLines(Paths.get("src/test/resources/result_10_21.pbn"), StandardCharsets.ISO_8859_1);
        List<String> actual = Files.readAllLines(path, StandardCharsets.ISO_8859_1);

        assertEquals(expected, actual);
    }

}
