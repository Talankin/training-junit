/**************************************
 * Created by dtalankin on 31.01.2016.
 */

package ru.dtalankin.trainings;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileTest extends FileFixture {

    // TODO test grouping. Lesson 2.3
    // TODO running with config (look at the 4th practice)

    @Test
    public void filePositiveTest1() throws IOException {
        String subPath = "subPath";
        File fullPath = new File(tmpDir.toFile(), subPath);
        fullPath.mkdir();
        File file = new File(fullPath, "file1.txt");
        file.createNewFile();
        Assert.assertTrue("File1 is not created", file.exists());
    }

    @Test
    public void filePositiveTest2() throws IOException {
        File file = new File(subDir, "file2.txt");
        file.createNewFile();
        Assert.assertTrue("File2 is not created", file.exists());
    }

    @Test
    public void filePositiveTest3() throws IOException {
        File file = new File(subDir, "file3.txt");
        file.createNewFile();
        Assert.assertTrue("File4 does not exist", file.exists());
    }

    @Test
    public void fileNegativeTest4() throws IOException {
        File file = new File(tmpDir.toFile(), "file4.txt");
        file.createNewFile();
        file.createNewFile();
        Assert.assertFalse("File3 created", file.createNewFile());
    }

    @Test
    @Ignore("fileNegativeTest5 is in develop yet")
    public void fileNegativeTest5() throws IOException {
        File notExistingPath = new File(subDir, notExistingDir);
        File file = new File(notExistingPath, "file5.txt");
        file.createNewFile();
        Assert.assertTrue("File5 does not exist", file.exists());
    }

}
