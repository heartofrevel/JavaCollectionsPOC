package com.heartofrevel.Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * The LinkedList class extends AbstractSequentialList and implements the List interface.
 * It provides a linked-list data structure.
 * Internally Java LinkedList is implemented using Doubly Linked List. So Java LinkedList represents it’s elements as Nodes.
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
        ArrayList tempArrayList = new ArrayList(Arrays.asList(1,2,3,4));
        LinkedList fromCollection = new LinkedList(tempArrayList);
        System.out.println(fromCollection);
    }
}
