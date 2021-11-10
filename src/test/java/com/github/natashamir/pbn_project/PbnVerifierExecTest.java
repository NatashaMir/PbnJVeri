package com.github.natashamir.pbn_project;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PbnVerifierExecTest {

    @TempDir
    static Path tempDir;

    @Test
    public void testActionVerifierExecVersion10() throws IOException {

        Path path = tempDir.resolve(String.format("result_checked_10.pbn"));
        Path log = tempDir.resolve(String.format("result_checked_10.log"));
        int lPBN10 = PbnGen.VERSION_10;

        PbnVerify pbnVerifiy = new PbnVerify();

        PbnGen.SetVersion(lPBN10);

        try (RandomAccessFile r = new RandomAccessFile("src/test/resources/correct_10.pbn", "r");
             FileOutputStream oLoggingFos = new FileOutputStream(log.toString());
             FileOutputStream oExportFos = new FileOutputStream(path.toString());) {
            pbnVerifiy.exec(r, oExportFos, oLoggingFos, true, new PbnExport(true));
        }

        List<String> expected = Files.readAllLines(Paths.get("src/test/resources/result_10.pbn"), StandardCharsets.ISO_8859_1);
        List<String> actual = Files.readAllLines(path, StandardCharsets.ISO_8859_1);

        assertEquals(expected, actual);
    }

    @Test
    public void testActionVerifierExecXMLVersion10() throws IOException {
        //Path path = tempDir.resolve(String.format("result_checked_10.xml"));
        Path log = tempDir.resolve(String.format("result_checked_10_onegame.log"));
        int lPBN10 = PbnGen.VERSION_10;

        PbnVerify pbnVerifiy = new PbnVerify();

        PbnGen.SetVersion(lPBN10);

        try (RandomAccessFile r = new RandomAccessFile("src/test/resources/correct_10_onegame.pbn", "r");
             FileOutputStream oLoggingFos = new FileOutputStream(log.toString());
             FileOutputStream oExportFos = new FileOutputStream("result_10_onegame.xml");) {
            pbnVerifiy.exec(r, oExportFos, oLoggingFos, true, new XMLExport(true));
        }

        List<String> expected = Files.readAllLines(Paths.get("src/test/resources/result_10_onegame.xml"), StandardCharsets.ISO_8859_1);
        List<String> actual = Files.readAllLines(Paths.get("C:\\pbn\\PbnJVeri\\result_10_onegame.xml"), StandardCharsets.ISO_8859_1);

        assertEquals(expected, actual);
    }

}
