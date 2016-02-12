/**************************************
 * Created by dtalankin on 31.01.2016.
 */

package ru.dtalankin.trainings;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileTest extends FileFixture {

    @Test
    public void filePositiveTest1() throws IOException {
        File file = new File(tmpDir.toFile(), "file1.txt");
        file.createNewFile();
//        Assert.assertTrue(file.exists(), "File1 is not created");
    }

    @Test
    public void filePositiveTest2() throws IOException {
        File file = new File(subDir, "file2.txt");
        file.createNewFile();
//        Assert.assertTrue(file.exists(), "File2 is not created");
    }

    @Test
    public void filePositiveTest3() throws IOException {
        File file = new File(subDir, "file3.txt");
        file.createNewFile();
//        AssertJUnit.assertTrue("File4 does not exist", file.exists());
    }

    @Test
    public void fileNegativeTest4() throws IOException {
        File file = new File(tmpDir.toFile(), "file4.txt");
        file.createNewFile();
        file.createNewFile();
//        AssertJUnit.assertFalse("File3 created", file.createNewFile());
    }

    @Test
    public void fileNegativeTest5() throws IOException {
        File notExistingPath = new File(subDir, notExistingDir);
        File file = new File(notExistingPath, "file5.txt");
        file.createNewFile();
//        AssertionForExceptions verify = new AssertionForExceptions();
//        verify.assertExpectedException(file);
    }

}
