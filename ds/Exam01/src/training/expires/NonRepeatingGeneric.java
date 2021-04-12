package training.expires;

import java.util.HashMap;
import java.util.Map;

public class NonRepeatingGeneric {

    public static <T> T first_non_repeating(T array[]){
        Map<T, Integer> hashMap = new HashMap<>();
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
