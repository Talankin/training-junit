/**************************************
 * Created by dtalankin on 22.02.2016.
 */

package ru.dtalankin.trainings;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class RepeateUnstableRule implements TestRule{

    public Statement apply(Statement base, Description description) {
        return new RepeateUnstableStatement(base, description);
    }

}
