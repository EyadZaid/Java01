package com.experis;

import java.util.HashSet;
import java.util.Set;

public class CountDistinct {

   public static int CountDistinctNumbers(int[] arr) {
       Set<Integer> set = new HashSet<Integer>();

       for (int i = 0 ; i < arr.length; i++) {
           set.add(Math.abs(arr[i]));
       }

       return set.size();
    }

}
