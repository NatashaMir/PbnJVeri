package com.github.natashamir.pbn_project;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PbnVerifierTest {

    @Test
    public void testActionVerify() {
        new PbnVerifier(false, "src/test/resources/correct_10.pbn", "-Eresult_10.pbn");

        try {

            InputStream inputStream1 = new FileInputStream("src/test/resources/result_10.pbn");
            InputStream inputStream2 = new FileInputStream("C:\\pbn\\PbnJVeri\\result_10.pbn");

            assertTrue(IOUtils.contentEquals(inputStream1, inputStream2));

        } catch (IOException e) {
            System.out.println("IOException opening input stream");
            e.printStackTrace();
        }

    }

}
