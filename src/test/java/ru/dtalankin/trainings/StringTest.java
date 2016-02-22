/**************************************
 * Created by dtalankin on 31.01.2016.
 */

package ru.dtalankin.trainings;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import ru.dtalankin.trainings.categories.*;

import static org.hamcrest.CoreMatchers.*;


public class StringTest extends StringTestFixture {
    private String str1 = "qwerty";
    private static int attempt = 1;

    @Test
    @Category(PositiveTests.class)
    public void test1()
    {
        System.out.println("PositiveStringTest1");
        Assert.assertThat(str1, is("qwerty"));
    }

    @Test
    @Category(PositiveTests.class)
    public void test2()
    {
        System.out.println("PositiveStringTest2");
        Assert.assertThat(str1, endsWith("ty"));
    }

    @Test
    @Unstable(4)
    public void unstableTest3() {
        if(attempt == 3) {
            System.out.println("UnstableStringTest3");
        } else {
            attempt++;
            Assert.fail();
        }
    }

}
