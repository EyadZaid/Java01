package training.expires;

public class TrappedAreaWater {

    public static int trappedArea(int[] arr) {
        int leftMax = 0, rightMax = 0, result = 0;
        int lo = 0, hi = arr.length - 1;

        while (lo <= hi) {
            if (arr[lo] < arr[hi]) {
                if (arr[lo] > leftMax) {
                    leftMax = arr[lo];
                }
                else {
                    result += leftMax - arr[lo];
                }
                    lo++;
            }
            else {
                if (arr[hi] > rightMax) {
                    rightMax = arr[hi];
                }
                else {
                    result += rightMax - arr[hi];
                }
                hi--;
            }
        }
        return result;
    }


}
