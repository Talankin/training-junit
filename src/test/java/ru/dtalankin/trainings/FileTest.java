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
import static ru.dtalankin.trainings.DataSource.Type.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(DataProviderRunner.class)
public class FileTest extends FileFixture {
    private final static String DATA_FILE = "/files.data";

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
    @UseDataProvider(value = "dataSourceLoader", location = UniversalDataProvider.class)
    @DataSource(value = DATA_FILE, type = RESOURCE)
    public void filePositiveTest2(String fileName) throws IOException {
        System.out.println("PositiveTest2");
        File file = new File(subDir, fileName);
        file.createNewFile();
        Assert.assertTrue("File2 is not created", file.exists());
    }

    @Test
    @Category({BrokenTests.class})
    @UseDataProvider("fileNameGenerator")
    public void filePositiveTest3(String fileName) throws IOException {
        System.out.println("PositiveTest3 - BrokenTest");
        File file = new File(subDir, fileName);
        file.createNewFile();
        Assert.assertTrue("File3 does not exist", file.exists());
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

    @DataProvider
    public static Object[][] fileNameGenerator() {
        List<Object[]> filesList = new ArrayList<Object[]>();
        for(int i=0; i<5; i++) {
            filesList.add(new Object[]{
                    generateRandomFileName()
            });
        }
        return (Object[][])filesList.toArray(new Object[][]{});
    }

    private static Object generateRandomFileName() {
        return "file" + (int)(Math.random()*100000) + ".txt";
    }

}
