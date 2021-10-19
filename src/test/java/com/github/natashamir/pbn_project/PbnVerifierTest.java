package com.github.natashamir.pbn_project;

import java.io.File;
import org.junit.jupiter.api.Test;

public class PbnVerifierTest {

    @Test
    public void testReadFileWithClassLoader(){
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource("lorem_ipsum.txt").getFile());
        assertTrue(file.exists());

    }

}
