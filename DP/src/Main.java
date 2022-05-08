import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LeetCode647 lc = new LeetCode647();
        int res = lc.countSubstrings("abc");
        System.out.println(res);

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");


        System.out.println("---------------");

        LeetCode673 leetCode673 = new LeetCode673();
        int[] nums = new int[]{
                10,10
        };

        leetCode673.findNumberOfLIS(nums);

    }
}
