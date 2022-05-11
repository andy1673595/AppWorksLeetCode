package java.array;

public class IntersectionOfTwoArrays350 {

    // ver 1 暴力解 O(N^2)
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] tmpRepeatNum = new int[1001];
        int repeatCount = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j] && nums1[i] >= 0) {
                    tmpRepeatNum[repeatCount] = nums1[i];
                    repeatCount++;
                    nums1[i] = -1;
                    nums2[j] = -1;
                    break;
                }
            }
        }
        int[] repeatNum = clone(tmpRepeatNum, repeatCount);
        return repeatNum;
    }
    public int[] clone(int[] num, int count) {
        int [] cloneArray = new int[count];
        for (int i = 0; i < count; i++) {
            cloneArray[i] = num[i];
        }
        return cloneArray;
    }

}
