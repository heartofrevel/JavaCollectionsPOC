package com.heartofrevel.Collections.SetImplementations;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 This class extends HashSet, but adds no members of its own.
 LinkedHashSet maintains a linked list of the entries in the set, in the order in which they were inserted.
 This allows insertion-order iteration over the set.
 That is, when cycling through a LinkedHashSet using an iterator, the elements will be returned in the order in which they were inserted.
 The hash code is then used as the index at which the data associated with the key is stored. The transformation of the key into its hash code is performed automatically.
 */

public class LinkedHashSetPOC {
    public static void main(String[] args) {
        /**
         *LinkedHashSet(int capacity)
         This constructor initializes the capacity of the linkedhashset to the given integer value capacity.
         The capacity grows automatically as elements are added to the HashSet.

         *LinkedHashSet(int capacity, float fillRatio)
         This constructor initializes both the capacity and the fill ratio
         (also called load capacity) of the hash set from its arguments.
         */

        LinkedHashSet linkedHashSet = new LinkedHashSet(5,0.8f);
        HashSet normalHashSet = new HashSet();
        for (int i=0; i<10e5; i++){
            normalHashSet.add(i);
            linkedHashSet.add(i);
        }
        Iterator itHashSet = normalHashSet.iterator();
        Iterator itLinkedHashSet = linkedHashSet.iterator();

        int itHashSetFirstValue = (int)itHashSet.next();
        while (itHashSet.hasNext()){
            int nextVal = (int)itHashSet.next();
            if(nextVal != itHashSetFirstValue+1){
                System.out.println("Hash Set doesn't maintain Insertion Order");
                break;
            }else {
                itHashSetFirstValue = nextVal;
            }
        }

        int itLinkeHashSetFirstValue = (int)itLinkedHashSet.next();
        while (itLinkedHashSet.hasNext()){
            int nextVal = (int)itLinkedHashSet.next();
            if(nextVal != itLinkeHashSetFirstValue+1){
                System.out.println("Linked Hash Set doesn't maintain Insertion Order");
                break;
            }else {
                itLinkeHashSetFirstValue = nextVal;
            }
        }
        //From the above example you can see, Linked Hash Set maintain insertion order
        //as compared to HashSet.

    }
}
