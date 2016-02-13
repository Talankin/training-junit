/**************************************
 * Created by dtalankin on 31.01.2016.
 */

package ru.dtalankin.trainings;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;


public class StringTest {
    private String str1 = "qwerty";

    @Test
    public void test1 ()
    {
        Assert.assertThat(str1, is("qwerty"));
    }

    @Test
    public void test2 ()
    {
        Assert.assertThat(str1, endsWith("ty"));
    }

}
