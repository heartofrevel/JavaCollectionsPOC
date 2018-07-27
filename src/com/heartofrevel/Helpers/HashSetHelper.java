package com.heartofrevel.Helpers;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Map;

public class HashSetHelper {
    public static Map getInternalMap(HashSet set) throws Exception {
        // reflection stuff
        Field field = set.getClass().getDeclaredField("map");
        field.setAccessible(true);

        // get the internal map
        @SuppressWarnings("unchecked")
        Map interalMap = (Map) (field.get(set));

        return interalMap;
    }
}
