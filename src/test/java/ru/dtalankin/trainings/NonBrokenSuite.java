/**************************************
 * Created by dtalankin on 14.02.2016.
 */

package ru.dtalankin.trainings;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ru.dtalankin.trainings.categories.BrokenTests;

@Suite.SuiteClasses({FileTest.class, StringTest.class})
@RunWith(Categories.class)
@Categories.ExcludeCategory(BrokenTests.class)
public class NonBrokenSuite {
}
