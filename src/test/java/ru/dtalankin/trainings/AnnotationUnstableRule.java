/**************************************
 * Created by dtalankin on 22.02.2016.
 */

package ru.dtalankin.trainings;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class AnnotationUnstableRule extends TestWatcher {
    @Override
    protected void starting(Description description) {
        if(description.getAnnotation(Unstable.class) != null) {
            System.out.println("Annotation is working ...");
        }
    }
}
