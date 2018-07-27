/**
 The ArrayList class extends AbstractList and implements the ListImplementations interface.
 ArrayList supports dynamic arrays that can grow as needed.

 Standard Java arrays are of a fixed length.
 After arrays are created, they cannot grow or shrink, which means that you must know
 in advance how many elements an array will hold.

 Array lists are created with an initial size. When this size is exceeded,
 the collection is automatically enlarged.
 When objects are removed, the array may be shrunk.
 */
package com.heartofrevel.Collections.ListImplementations;

import com.heartofrevel.Helpers.ArrayListHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListPOC {
    public static void main(String[] args) {
        ArrayList<Integer> normalList = new ArrayList();
        ArrayList usingCapacity = new ArrayList(2);

        //Lets print Size and Capacity of both ArrayList
        System.out.println("normalList : Size : "+normalList.size());
        System.out.println("usingCapacity : Size : "+usingCapacity.size());


        /**
         * void add(int index, Object element)
         * Inserts the specified element at the specified position index in this list.
         * Throws IndexOutOfBoundsException if the specified
         * index is out of range (index < 0 || index > size()).
         */
        try {
            normalList.add(1, 2);
        }catch(IndexOutOfBoundsException e){
            System.out.println("This throws index out of bound exception as normalList" +
                    " size is 0");
        }

        try{
            usingCapacity.add(0,1);
            System.out.println("This doesn't throw exception as its capacity is 2.");
        }catch(IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

        /**
         boolean add(Object o)
         Appends the specified element to the end of this list.
         */
        normalList.add(1); //This won't throw an exception as we are appending to list not inserting at specific index.
        normalList.add(2);
        System.out.println(normalList);

        normalList.add(1, 5); //This will work now as index 1 exist.
        //You can see it automatically moved the element at index 1 to index 2.
        System.out.println(normalList);


        /**
         boolean addAll(Collection c)
         Appends all of the elements in the specified collection to the end of this list,
         in the order that they are returned by the specified collection's iterator.
         Throws NullPointerException, if the specified collection is null.

         Let us add some values to "usingCapacity" list and then add all elements of
         "usingCapacity" to "normalList"
         */
        usingCapacity.add(14);
        List emptyList= null;
        try {
            normalList.addAll(emptyList);
        }catch(NullPointerException ex){
            System.out.println("Null Pointer Exception");
        }catch (Exception e){
            System.out.println("Exception");
        }
        normalList.addAll(usingCapacity);
        System.out.println(normalList);
        System.out.println("No Exception as collection argument to add all is not null");

        /**
         boolean addAll(int index, Collection c)
         Inserts all of the elements in the specified collection into this list,
         starting at the specified position.
         Throws NullPointerException if the specified collection is null.
         */
        normalList.addAll(0, usingCapacity);
        System.out.println(normalList);

        /**
         void clear()
         Removes all of the elements from this list.
         */
        usingCapacity.clear();
        System.out.println(usingCapacity);

        /**
         Object clone()
         Returns a shallow copy of this ArrayList.
         */
        Object shallowObject = normalList.clone();
        //This shallowObject won't have any of the list Interface method.
        //Type Casting is needed.
        List castedList = (List) shallowObject;
        System.out.println(castedList.size());

        /**
         boolean contains(Object o)
         Returns true if this list contains the specified element.
         More formally, returns true if and only if this list contains at least one
         element e such that (o==null ? e==null : o.equals(e)).
         */
        System.out.println(normalList.contains(2));
        System.out.println(normalList.contains(null));
        //System.out.println(emptyList.contains(null));

        /**
         void ensureCapacity(int minCapacity)
         Increases the capacity of this ArrayList instance,
         if necessary, to ensure that it can hold at least the number of elements
         specified by the minimum capacity argument.
         */
        /** Please check below
         The performance benefit is realised in cases where you are about to add
         multiple elements to the list and know how many you're going to be adding.
         By calling ensureCapacity(int) you cause the underlying array to be resized
         once instead of potentially many times.
         Note however, that in reality you should rarely need to call this method;
         typically you will either instantiate the ArrayList with a known capacity,
         or in cases where the list size is unknown you should probably be considering
         using a LinkedList instead.
         Also note that the resize strategy of ArrayList is typically implemented in
         such a way that array copies are a rare operation (e.g. the capacity may
         increase by 50% every time the array becomes full).
         In other words, even if you do not call ensureCapacity in advance you are
         unlikely to notice any slow-down within your code.
         */
        ArrayList newListToEnsureCapacity = new ArrayList(3);
        newListToEnsureCapacity.add(2);
        newListToEnsureCapacity.add(3);
        newListToEnsureCapacity.add(2);
        newListToEnsureCapacity.ensureCapacity(1000000);
        final long startTime = System.nanoTime();
        for (int i=0; i<1000000; i++){
            newListToEnsureCapacity.add(i);
        }
        System.out.println(System.nanoTime() - startTime);

        /**
         Object get(int index)
         Returns the element at the specified position in this list.
         Throws IndexOutOfBoundsException if the specified index is out of range
         (index < 0 || index >= size()).
         */
        System.out.println(normalList.get(2));
        try{
            normalList.get(100000000);
        }catch(IndexOutOfBoundsException e){
            System.out.println("Index is out of bound");
        }

        /**
         int indexOf(Object o)
         Returns the index in this list of the first occurrence of the specified
         element, or -1 if the ListImplementations does not contain this element.
         */
        System.out.println(normalList.indexOf(1));
        System.out.println(normalList.indexOf(null));

        //Trying to add null to ArrayList
        normalList.add(null);
        System.out.println(normalList + " Size : "+normalList.size());
        //null is added to list and increases the size also.It will also be factored when
        //using for loop

        /**
         int lastIndexOf(Object o)
         Returns the index in this list of the last occurrence of the specified
         element, or -1 if the list does not contain this element.
         */
        System.out.println(normalList.lastIndexOf(1));

        /**
         Object remove(int index)
         Removes the element at the specified position in this list.
         Throws IndexOutOfBoundsException if the index out is of range
         (index < 0 || index >= size()).
         */
        Object returnObject = normalList.remove(0);
        System.out.println(normalList+" Removed Object : "+returnObject);
        //Remove Using element
        normalList.remove(new Integer(14));
        System.out.println(normalList);

        /**
         protected void removeRange(int fromIndex, int toIndex)
         Removes from this ListImplementations all of the elements whose index is between fromIndex,
         inclusive and toIndex, exclusive.
         */
        /*
        Since it's a protected method, you cannot directly use it.You either need to
        create a subclass of ArrayList to use it or place your code in the sames package
        as ArrayList.
        We will use subList to create a sublist and clear() to clear which internally calls
        removeRange
        */
        normalList.subList(1,3).clear();
        System.out.println(normalList);

        /**
         Object set(int index, Object element)
         Replaces the element at the specified position in this list with the specified element.
         Throws IndexOutOfBoundsException if the specified index is out of range (index < 0 || index >= size()).
         */
        normalList.set(0, 123);
        System.out.println(normalList);

        /**
         Object[] toArray()
         Returns an array containing all of the elements in this list in the correct
         order. Throws NullPointerException if the specified array is null.
         */
        Object[] normalListArray = normalList.toArray();
        System.out.println(Arrays.toString(normalListArray));

        /**
         Object[] toArray(Object[] a)
         Returns an array containing all of the elements in this list in the correct
         order; the runtime type of the returned array is that of the specified array.

         If the passed array has enough space, then elements are stored in this array itself.
         If the passed array doesn’t have enough space, a new array is created with same type and size of given list.
         If the passed array has more space, the array is first filled with list elements, then null values are filled.
         */
        Integer[] newIntArray = new Integer[2];
        newIntArray[0]=100;
        newIntArray = normalList.toArray(newIntArray);
        System.out.println(Arrays.toString(newIntArray));

        /**
         void trimToSize()
         Trims the capacity of this ArrayList instance to be the list's current size.
         I have added code to get the capacity of ArrayList using Reflection APIs in Helper package.
         This code is copied from StackOverflow
         */
        ArrayList capacityList = new ArrayList(100);
        System.out.println(ArrayListHelper.getArrayListCapacity(capacityList));
        capacityList.add(1);
        capacityList.add("Integer");
        capacityList.trimToSize();
        System.out.println(ArrayListHelper.getArrayListCapacity(capacityList));
        //As you can see that our capacityList capacity is trimmed to it's size.
    }
}
