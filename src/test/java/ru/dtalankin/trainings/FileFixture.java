/**************************************
 * Created by dtalankin on 12.02.2016.
 */

package ru.dtalankin.trainings;

import org.apache.commons.io.FileUtils;
import org.junit.ClassRule;
import org.junit.rules.ExternalResource;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileFixture {
    protected static Path tmpDir = null;
    protected static File subDir = null;
    protected static String notExistingDir = "qwerty";

    @ClassRule
    public static ExternalResource fileRule = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            System.out.println("SetUp Fixture");
            tmpDir = Files.createTempDirectory("tmpDir");
            subDir = new File(tmpDir.toFile(), "subdir");
            subDir.mkdir();
        }

        @Override
        protected void after() {
            System.out.println("TearDown Fixture");
            FileUtils.deleteQuietly(tmpDir.toFile());
        }
    };

}
