/**
 * Copied from
 * https://stackoverflow.com/questions/2497063/how-to-get-the-capacity-of-the-arraylist-in-java
 */

package com.heartofrevel.Helpers;

import java.lang.reflect.Field;
import java.util.ArrayList;

public abstract class ArrayListHelper {

    static final Field field;
    static {
        try {
            field = ArrayList.class.getDeclaredField("elementData");
            field.setAccessible(true);
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    @SuppressWarnings("unchecked")
    public static <E> int getArrayListCapacity(ArrayList<E> arrayList) {
        try {
            final E[] elementData = (E[]) field.get(arrayList);
            return elementData.length;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}