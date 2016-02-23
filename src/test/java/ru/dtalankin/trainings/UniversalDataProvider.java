/**************************************
 * Created by dtalankin on 23.02.2016.
 */

package ru.dtalankin.trainings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.tngtech.java.junit.dataprovider.DataProvider;
import org.junit.runners.model.FrameworkMethod;

public class UniversalDataProvider {
    @DataProvider
    public static Object[][] dataSourceLoader(FrameworkMethod testMethod) throws IOException {
        DataSource dataSource = testMethod.getAnnotation(DataSource.class);
        if (dataSource == null) {
            throw new Error("Test method has no @DataSource annotation: " + testMethod.getName());
        }
        switch (dataSource.type()) {
            case RESOURCE:
                return loadDataFromResource(dataSource.value());
            case FILE:
                return loadDataFromFile(dataSource.value());
            default:
                throw new Error("Data source type is not supported: " + dataSource.type());
        }
    }

    private static Object[][] loadDataFromResource(String value) throws IOException {
        return loadDataFromInputStream(UniversalDataProvider.class.getResourceAsStream(value));
    }

    private static Object[][] loadDataFromFile(String value) throws IOException {
        return loadDataFromInputStream(new FileInputStream(new File(value)));
    }

    private static Object[][] loadDataFromInputStream(InputStream input) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(input));
        List<Object[]> userData = new ArrayList<Object[]>();
        String line = buffer.readLine();
        while (line != null) {
            userData.add(line.split(";"));
            line = buffer.readLine();
        }
        buffer.close();

        return (Object[][]) userData.toArray(new Object[][]{});
    }

}
