/**************************************
 * Created by dtalankin on 31.01.2016.
 */

package ru.dtalankin.trainings;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class StringTest {
    private String str1 = "qwerty";

    @Test
    public void test1 ()
    {
        assertThat("Strings are not equal",str1.equals("qwerty"));
    }

    @Test
    public void test2 ()
    {
        assertThat("String is empty",str1.length() > 0);
    }

}
