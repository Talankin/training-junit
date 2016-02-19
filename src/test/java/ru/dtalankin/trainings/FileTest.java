/**************************************
 * Created by dtalankin on 31.01.2016.
 */

package ru.dtalankin.trainings;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import ru.dtalankin.trainings.categories.BrokenTests;
import ru.dtalankin.trainings.categories.NegativeTests;
import ru.dtalankin.trainings.categories.PositiveTests;

import java.io.File;
import java.io.IOException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(DataProviderRunner.class)
public class FileTest extends FileFixture {
    @DataProvider
    public static Object[][] paths() {
        return new Object[][] {
                {"dir1", "abracadabra.txt"},
                {"dir2", "tumtumtum.txt"}
        };
    }

    @Test
    @Category(PositiveTests.class)
    @UseDataProvider("paths")
    public void filePositiveTest1(String subPath, String fileName) throws IOException {
        System.out.println("PositiveTest1");
        File fullPath = new File(tmpDir.toFile(), subPath);
        fullPath.mkdir();
        File file = new File(fullPath, fileName);
        file.createNewFile();
        Assert.assertTrue("File1 is not created", file.exists());
    }

    @Test
    @Category(PositiveTests.class)
    public void filePositiveTest2() throws IOException {
        System.out.println("PositiveTest2");
        File file = new File(subDir, "file2.txt");
        file.createNewFile();
        Assert.assertTrue("File2 is not created", file.exists());
    }

    @Test
    @Category({BrokenTests.class})
    public void filePositiveTest3() throws IOException {
        System.out.println("PositiveTest3 - BrokenTest");
        File file = new File(subDir, "file3.txt");
        file.createNewFile();
        Assert.assertTrue("File4 does not exist", file.exists());
    }

    @Test
    @Category({NegativeTests.class})
    public void fileNegativeTest4() throws IOException {
        System.out.println("NegativeTest4");
        File file = new File(tmpDir.toFile(), "file4.txt");
        file.createNewFile();
        file.createNewFile();
        Assert.assertFalse("File4 created", file.createNewFile());
    }

    @Test
    @Category({NegativeTests.class})
    public void fileNegativeTest5() throws IOException {
        System.out.println("NegativeTest5");
        File notExistingPath = new File(subDir, notExistingDir);
        File file = new File(notExistingPath, "file5.txt");
        file.createNewFile();
        Assert.assertTrue("File5 does not exist", file.exists());
    }

    @Test
    @Ignore("fileNegativeTest6 is in develop yet")
    @Category({NegativeTests.class})
    public void fileNegativeTest6() throws IOException {
        System.out.println("NegativeTest6");
        File notExistingPath = new File(subDir, notExistingDir);
        File file = new File(notExistingPath, "file6.txt");
        file.createNewFile();
        Assert.assertTrue("File5 does not exist", file.exists());
    }

}
