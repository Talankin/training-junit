/**************************************
 * Created by dtalankin on 09.02.2016.
 */

package ru.dtalankin.trainings;


//abstract class ExceptionsAssert implements IAssert {
abstract class ExceptionsAssert {
    private final String message;

    public ExceptionsAssert (String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Object getActual() {
        return null;
    }

    public Object getExpected() {
        return null;
    }

    abstract public void doAssert();
}