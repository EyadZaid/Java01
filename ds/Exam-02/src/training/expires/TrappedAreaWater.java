package training.expires;

public class TrappedAreaWater {

    public static int trappedArea(int[] arr) {
        int res = 0;

        for (int i = 1; i < arr.length - 1; i++) {
            int left = arr[i];

            for(int j = 0; j < i; j++) {
                left = Math.max(left, arr[j]);
            }

            int right = arr[i];
            for(int j = i + 1; j < arr.length; j++) {
                right = Math.max(right, arr[j]);
            }

            res += Math.min(left, right) - arr[i];
        }
        return res;
    }

}
