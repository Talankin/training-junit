/**************************************
 * Created by dtalankin on 22.02.2016.
 */

package ru.dtalankin.trainings;

import org.junit.Rule;
import org.junit.rules.RuleChain;

public class StringTestFixture {

    public RepeateUnstableRule repeateUnstableRule = new RepeateUnstableRule();
    public AnnotationUnstableRule annotationUnstableRule = new AnnotationUnstableRule();

    @Rule
    public RuleChain ruleChain = RuleChain
            .outerRule(annotationUnstableRule)
            .around(repeateUnstableRule);
}
