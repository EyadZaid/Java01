package training.expires;

import java.util.HashMap;
import java.util.Map;

public class NonRepeatingNum {

    public static Integer first_non_repeating_num(int array[]){
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (var e : array){
            if (hashMap.containsKey(e)) {
                hashMap.put(e, hashMap.get(e) + 1);
            }
            else {
                hashMap.put(e, 1);
            }
        }

        for (var v : hashMap.entrySet()) {
            if (v.getValue() == 1) {
                return v.getKey();
            }
        }

        return null;
    }
}
