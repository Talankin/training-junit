/**************************************
 * Created by dtalankin on 12.02.2016.
 */

package ru.dtalankin.trainings;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileFixture {
    protected static Path tmpDir = null;
    protected static File subDir = null;
    protected static String notExistingDir = "qwerty";

    @BeforeClass
    public static void createTmpDirTest() throws IOException {
        System.out.println("SetUp Fixture");
        tmpDir = Files.createTempDirectory("tmpDir");
        subDir = new File(tmpDir.toFile(), "subdir");
        subDir.mkdir();
    }

    @AfterClass
    public static void deleteTmpDirTest(){
        System.out.println("TearDown Fixture");
        FileUtils.deleteQuietly(tmpDir.toFile());
    }

}
