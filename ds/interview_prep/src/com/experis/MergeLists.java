package com.experis;

import java.util.ArrayList;
import java.util.List;

public class MergeLists {

    public static List<Integer> mergeLists(List<Integer> l1, List<Integer> l2) {
        assert l1 != null && l2 != null;
        List<Integer> result = new ArrayList<>();

        int i = 0, j = 0;
        int sizeL1 = l1.size();
        int sizeL2 = l2.size();
        int a, b;

        while (i < sizeL1 && j < sizeL2) {
            a = l1.get(i);
            b = l2.get(j);
            if (a < b) {
                result.add(a);
                i++;
            } else {
                result.add(b);
                j++;
            }
        }

        while (i < sizeL1) {
            result.add(l1.get(i++));
        }

        while (j < sizeL2) {
            result.add(l2.get(j++));
        }

        return result;
    }
}
