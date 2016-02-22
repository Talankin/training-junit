/**************************************
 * Created by dtalankin on 22.02.2016.
 */

package ru.dtalankin.trainings;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class AnnotationUnstableRule extends TestWatcher {
    public static int annotationValue = 0;

    @Override
    protected void starting(Description description) {
        if(description.getAnnotation(Unstable.class) != null) {
            annotationValue = description.getAnnotation(Unstable.class).value();
            System.out.println("Annotation is working ...");
        }
    }
}
