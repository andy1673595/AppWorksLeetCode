package java.array;

public class MoveZeroes283 {
    public void moveZeroes(int[] nums) {
        int numZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                numZero++;
            } else {
                if (numZero > 0) {
                    nums[i - numZero] = nums[i];
                    nums[i] = 0;
                }
            }
        }
    }
}
