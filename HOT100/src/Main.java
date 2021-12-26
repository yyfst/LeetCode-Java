import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("-----------test---------------");
        testThreeSum();

    }

    public static void testThreeSum() {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        LeetCode15 lc= new LeetCode15();
        List<List<Integer>> result =  lc.threeSum(nums);
        System.out.println(result);
    }
}
