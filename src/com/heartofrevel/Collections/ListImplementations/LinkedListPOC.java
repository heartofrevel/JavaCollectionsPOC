package com.heartofrevel.Collections.ListImplementations;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.*;

/**
 * The LinkedList class extends AbstractSequentialList and implements the ListImplementations interface.
 * It provides a linked-list data structure.
 * Internally Java LinkedList is implemented using Doubly Linked ListImplementations. So Java LinkedList represents it’s elements as Nodes.
 * In JVM, LinkedList does NOT store it’s elements in consecutive order.It stores it’s elements at any available space and they are connected each other using Left and Right side Node portions
 */
public class LinkedListPOC {
    public static void main(String[] args) {
        /**
         LinkedList( )
         This constructor builds an empty linked list.
         */
        LinkedList normalList = new LinkedList();

        /**
         LinkedList(Collection c)
         This constructor builds a linked list that is initialized with the elements
         of the collection c.
         Will throw NullPointerException when passed null collection.
         */
        ArrayList tempArrayList = new ArrayList(Arrays.asList("Second", "Third", "Fourth"));
        LinkedList fromCollection = new LinkedList(tempArrayList);
        System.out.println(fromCollection);

        /**
         void add(int index, Object element)
         Inserts the specified element at the specified position index in this list.
         Throws IndexOutOfBoundsException if the specified index is out of range (index < 0 || index > size()).
         */
        try {
            System.out.println(normalList.size());
            normalList.add(1, "First");
        }catch(IndexOutOfBoundsException e){
            System.out.println("Index Out of Bound Exception thrown.");
        }
        normalList.add(0, "Zeroth");
        System.out.println(normalList);

        /**
         boolean add(Object o)
         Appends the specified element to the end of this list.
        */
        normalList.add("First");
        System.out.println(normalList);

        /*
         boolean addAll(Collection c)
         Appends all of the elements in the specified collection to the end of this list,
         in the order that they are returned by the specified collection's iterator.
         Throws NullPointerException if the specified collection is null.

         boolean addAll(int index, Collection c)
         Inserts all of the elements in the specified collection into this list, starting at the specified position.
         Throws NullPointerException if the specified collection is null.
        */
        normalList.addAll(2, tempArrayList);
        System.out.println("After addAll : "+normalList);

        /*
         void addFirst(Object o)
         Inserts the given element at the beginning of this list.

         void addLast(Object o)
         Appends the given element to the end of this list.
        */
        normalList.addFirst("-One");
        normalList.addLast("Fifth");
        System.out.println("After addFirst and addLast : "+normalList);

        /**
        void clear()
        Removes all of the elements from this list.
        */
        System.out.println("LinkedList before clear : "+fromCollection);
        fromCollection.clear();
        System.out.println("LinkedList after clear : "+fromCollection);

        /**
         * Object clone()
            Returns a shallow copy of this LinkedList.

         *boolean contains(Object o)
            Returns true if this list contains the specified element.
            More formally, returns true if and only if this list contains at least one element e such that
            (o==null ? e==null : o.equals(e)).

         *Object get(int index)
            Returns the element at the specified position in this list.
            Throws IndexOutOfBoundsException if the specified index is out of range (index < 0 || index >= size()).

         *int indexOf(Object o)
            Returns the index in this list of the first occurrence of the specified element, or -1 if the list does not contain this element.

         *int lastIndexOf(Object o)
            Returns the index in this list of the last occurrence of the specified element, or -1 if the list does not contain this element.

         *Object remove(int index)
            Removes the element at the specified position in this list. Throws NoSuchElementException if this list is empty.
            Throws IndexOutOfBoundsException if the specified index is out of range
            (index < 0 || index >= size()).

         *boolean remove(Object o)
            Removes the first occurrence of the specified element in this list.
            Throws NoSuchElementException if this list is empty.

         *Object set(int index, Object element)
             Replaces the element at the specified position in this list with the specified element.
             Throws IndexOutOfBoundsException if the specified index is out of range (index < 0 || index >= size()).

         *int size()
            Returns the number of elements in this list.

         *Object[] toArray()
            Returns an array containing all of the elements in this list in the correct order.
            Throws NullPointerException if the specified array is null.

         *Object[] toArray(Object[] a)
            Returns an array containing all of the elements in this list in the correct order;
            the runtime type of the returned array is that of the specified array.

         The above methods have same implementations that we have seen in ArrayList.
         */

        /**
         *ListIterator listIterator(int index)
             Returns a list-iterator of the elements in this list (in proper sequence), starting at the specified position in the list.
            Throws IndexOutOfBoundsException if the specified index is out of range (index < 0 || index >= size()).
         */
        ListIterator itr = normalList.listIterator(2);
        while(itr.hasNext()){
            System.out.print(itr.next()+" ");
        }

        /**
         * Object removeFirst()
            Removes and returns the first element from this list. Throws NoSuchElementException if this list is empty.

         *Object removeLast()
            Removes and returns the last element from this list. Throws NoSuchElementException if this list is empty.
         */
        System.out.println();
        System.out.println("Before removeFirst and removeLast : "+normalList);
        normalList.removeFirst();
        normalList.removeLast();
        System.out.println("After removeFirst and removeLast : "+normalList);

    }
}
