import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode131 {
    public List<List<String>> partition(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        List<List<String>> lists = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(String.valueOf(s.charAt(i)));
            dp[i][i] = true;
        }
        lists.add(list);
        list.clear();

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return Collections.emptyList();
    }
}
