package com.automation.tests.officeHours;

import java.util.*;

public class OH3_SetQueue {
    public static void main(String[] args) {
   /*
            Under List Interface:
            - ArrayList (indexes, faster to read, slower when we
            do manipulations(remove or add elements))
            - Vector (same as ArrayList, but thread safe)
                - Stack (Last in First out (like a stack of paper))
            - LinkedList (node (each element reference to previous
            and next element in the list))
            (performance-sensitive, memory allocation)
            [2, 5, 3] -> [2, 3]
            [2] [5] [3]
         */
        /*
            Set Interface: (contain only unique values)
            HashSet: no indexes - faster because it is using hashing
            (it does not keep an order), allows 1 null
            TreeSet: sorted set - no nulls
            LinkedHashSet: keeps the order
         */
        HashSet<String> hashSet = new HashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        for (String each : Arrays.asList("Value5", "Value1", "Value3")){
            hashSet.add(each);
            treeSet.add(each);
            linkedHashSet.add(each);
        }
        System.out.println("hashset: " + hashSet);
        System.out.println("treeset: " + treeSet);
        System.out.println("LinkedHashSet: " + linkedHashSet);

//***************************************************************************************
        System.out.println("*******************************************");
        //Iterator

        Iterator<String> iteratorSet= hashSet.iterator();
        while(iteratorSet.hasNext()){
            System.out.println(iteratorSet.next());
        }

        System.out.println("*******************************************");
        ArrayList<Integer> dropdown= new ArrayList<>();
             dropdown.add(1);
             dropdown.add(2);
             dropdown.add(2);
             dropdown.add(3);
             dropdown.add(3);
        System.out.println("dropdown List: "+dropdown);

        HashSet <Integer> optionsSet= new HashSet<>(dropdown);
        System.out.println("OptionsSet HashSet: "+ optionsSet);

        if (optionsSet.size() == dropdown.size()){
            System.out.println("expected is the same as actual");
        }else {
            System.out.println("options contains duplicates");
        }

//***************************************************************************************
        System.out.println("*******************************************");

        /*
            Queue:
            - PriorityQueue - First in first out
                can accept duplicates, does not have index
            - ArrayDequeue - special in adding and removing
         */

        PriorityQueue <String> priorityQueue = new PriorityQueue<>();
                priorityQueue.add("John");
                priorityQueue.add("Kate");
                priorityQueue.add("Tom");

        System.out.println("Queue: " + priorityQueue);

        //peeking (.peek()) - it will check and return the first in a queue
        System.out.println("peek: " + priorityQueue.peek());

        System.out.println("queue after peek: " + priorityQueue);

        //polling will return the first value in a queue and remove it
        System.out.println("poll: "+priorityQueue.poll());
        System.out.println("queue after poll: " + priorityQueue);


        ArrayDeque <String> deque = new ArrayDeque<>();







    }
}
