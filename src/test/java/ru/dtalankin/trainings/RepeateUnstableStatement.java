/**************************************
 * Created by dtalankin on 22.02.2016.
 */

package ru.dtalankin.trainings;

import org.junit.Assert;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;


public class RepeateUnstableStatement extends Statement {
    private final Statement base;
    private Description desc;

    public RepeateUnstableStatement(Statement base, Description desc) {
        this.base = base;
        this.desc = desc;
    }

    @Override
    public void evaluate() throws Throwable {
        int allowedAttempts = AnnotationUnstableRule.annotationValue;
        for (int i=0; i<allowedAttempts; i++) {
            try {
                base.evaluate();
                break;
            } catch (Throwable t) {
                System.out.println("Failed on " + (i+1) + " attempt: " + desc);
                if (i == allowedAttempts-1) Assert.fail();
            }
        }

    }
}
