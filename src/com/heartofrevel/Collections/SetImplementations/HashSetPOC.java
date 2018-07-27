package com.heartofrevel.Collections.SetImplementations;

import com.heartofrevel.Helpers.HashSetHelper;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.*;

/**
 HashSet extends AbstractSet and implements the Set interface.
 It creates a collection that uses a hash table for storage.
 A hash table stores information by using a mechanism called hashing.
 In hashing, the informational content of a key is used to determine a unique value,
 called its hash code.
 The hash code is then used as the index at which the data associated with the key is
 stored. The transformation of the key into its hash code is performed automatically.
 HashSet does not allow duplicate elements that means you can not store duplicate values in HashSet.
 HashSet permits to have a single null value.
 Actually the value we insert in HashSet acts as key to the map Object and for its value
 java uses a constant variable. So in key-value pair all the keys will have same value.
 So, Like a Map cannot have duplicate keys and HashSet values are keys to internal map
 object, so HashSet cannot have duplicate values
 Whenever you insert an element into HashSet using add() method, it actually creates an
 entry in the internally backing HashMap object with element you have specified as it’s
 key and constant called “PRESENT” as it’s value.
 This “PRESENT” is defined in the HashSet class as below.
 private static final Object PRESENT = new Object();
 public boolean add(E e)
 {
 return map.put(e, PRESENT)==null;
 }
 */
public class HashSetPOC {
    public static void main(String[] args) {
        /** Constructors
         *HashSet( )
            This constructor constructs a default HashSet.

         *HashSet(Collection c)
            This constructor initializes the hash set by using the elements of the collection c.

         *HashSet(int capacity)
            This constructor initializes the capacity of the hash set to the given integer value capacity. The capacity grows automatically as elements are added to the HashSet.

         *HashSet(int capacity, float fillRatio)
            This constructor initializes both the capacity and the fill ratio (also called
            load capacity) of the hash set from its arguments.
            Here the fill ratio must be between 0.0 and 1.0, and it determines how full the
            hash set can be before it is resized upward. Specifically,
            when the number of elements is greater than the capacity of the hash set
            multiplied by its fill ratio, the hash set is expanded.
         */
        HashSet defaultSet = new HashSet();
        HashSet usingCollection = new HashSet(new ArrayList(Arrays.asList("First, Second")));
        HashSet usingCapacity = new HashSet(5);
        HashSet withCapaAndFillRatio = new HashSet(5, 0.8f);
        //Here HashSet will be expanded when 5*0.8 = 4 elements are filled.

        /**
         boolean add(Object o)
         Adds the specified element to this set if it is not already present.
         */
        defaultSet.add("First");
        defaultSet.add("First");
        defaultSet.add(null);
        defaultSet.add(null);
        //Duplicate adds doesn't throw an exception but it doesn't add duplicate values.
        System.out.println(defaultSet);

        /**
         * The below code makes use of Helper Class HashSetHelper to get the internal Map
         * used in the HashSet. The Helpers class use Reflection APIs to accomplish it.
         * You will see below that values inserted in HashSet are used as keys in HashMap
         * and they have a constant object as value.
         */
        Map internalMap = new HashMap();
        try{
            internalMap = HashSetHelper.getInternalMap(defaultSet);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(internalMap);

        /**
         *void clear()
            Removes all of the elements from this set.

         *boolean contains(Object o)
            Returns true if this set contains the specified element.

         *boolean isEmpty()
            Returns true if this set contains no elements.

         *int size()
            Returns the number of elements in this set (its cardinality).

         *Iterator iterator()
            Returns an iterator over the elements in this set.
         */

        /**
         *Object clone()
            Returns a shallow copy of this HashSet instance: the elements themselves are not cloned.
         */
        HashSet<StringBuilder> toCloneSet = new HashSet<>();
        StringBuilder sb = new StringBuilder("Hello");
        toCloneSet.add(sb);
        HashSet<StringBuilder> tempObject = (HashSet<StringBuilder>)toCloneSet.clone();
        System.out.println("Before updating elements of base set : "+tempObject);
        for (StringBuilder element: toCloneSet) {
            element.append(" World");
        }
        System.out.println("After updating elements of base set : "+tempObject);
        //As you see above clone method doesnt clone the elements of set.
        //So base set and new set both reference to same elements and if i change the element
        //value from base set, it will also reflect in new set.



        /**
         *boolean remove(Object o)
            Removes the specified element from this set if it is present.
            You can only remove using Object not by index.
         */
        defaultSet.remove(null);
        System.out.println(defaultSet);

    }
}
