import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int index = 0; index < nums.length; index++) {
            if (index > 0 && (nums[index] == nums[index - 1])) {
                continue;
            }

            int left = index + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[index] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                    continue;
                }

                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[index]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                }
                left++;
                while (nums[left] == nums[left - 1] && left < right) {
                    left++;
                }

            }
        }

        return result;
    }
}
