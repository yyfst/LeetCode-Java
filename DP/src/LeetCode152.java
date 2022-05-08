public class LeetCode152 {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] dpMax = new int[len];
        int[] dpMin = new int[len];

        dpMax[0] = nums[0];
        dpMin[0] = nums[0];

        int res = dpMax[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] >= 0) {
                dpMax[i] = Math.max(dpMax[i - 1] * nums[i], nums[i]);
                dpMin[i] = Math.min(dpMin[i - 1] * nums[i], nums[i]);
            } else {
                dpMax[i] = Math.max(dpMin[i - 1] * nums[i], nums[i]);
                dpMin[i] = Math.min(dpMax[i - 1] * nums[i], nums[i]);
            }

            res = Math.max(res, dpMax[i]);
        }


        return res;
    }
}
