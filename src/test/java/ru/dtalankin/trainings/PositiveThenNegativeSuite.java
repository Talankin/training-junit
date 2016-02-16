/**************************************
 * Created by dtalankin on 14.02.2016.
 */

package ru.dtalankin.trainings;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ru.dtalankin.trainings.categories.BrokenTests;
import ru.dtalankin.trainings.categories.NegativeTests;
import ru.dtalankin.trainings.categories.PositiveTests;

@RunWith({Categories.class, Suite.class})
@Categories.IncludeCategory({PositiveTests.class, NegativeTests.class})
@Suite.SuiteClasses({FileTest.class, StringTest.class})
public class PositiveThenNegativeSuite {
}
