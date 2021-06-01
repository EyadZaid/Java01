package com.experis;

import java.util.HashSet;
import java.util.Set;

public class CountDistinct {

   public static int CountDistinctNumbers(int[] arr) {
       Set<Integer> s = new HashSet<Integer>();

       for (int i = 0 ; i < arr.length; i++) {
           s.add(Math.abs(arr[i]));
       }

       return s.size();
    }

}
