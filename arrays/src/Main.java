import java.util.*;

public class Main {




    final static String TYPE = "type";
    final static String COLOR = "color";
    final static String NAME = "name";

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        List<Integer> list = new ArrayList<>();
        int ruleIndex;
        if (Objects.equals(ruleKey, TYPE)) {
            ruleIndex = 0;
        } else if (Objects.equals(ruleKey, COLOR)) {
            ruleIndex = 1;
        } else {
            ruleIndex = 2;
        }

        int cnt = 0;
        for (List<String> itemList : items) {
            if (Objects.equals(itemList.get(ruleIndex), ruleValue)) {
                cnt++;
            }
        }
        return cnt;
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[][] data = new int[n][2];
        for (int i = 0; i < n; i++) {
            data[i][0] = nums[i];
            data[i][1] = i;
        }
        Arrays.sort(data, Comparator.comparingInt(data2 -> data2[0]));

        int[] ret = new int[n];
        int prev = -1;
        for (int i = 0; i < n; i++) {
            if (prev == -1 || data[i][0] != data[i - 1][0]) {
                prev = i;
            }
            ret[data[i][1]] = prev;
        }
        return ret;
    }

    public int[] smallerNumbersThanCurrent2(int[] nums) {
        final int maxNum = 100;
        int[] tmp = new int[maxNum+1];
        for (int num : nums) {
            tmp[num]++;
        }

        for (int i = 1; i < tmp.length; i++) {
            tmp[i] += tmp[i-1];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < tmp.length; i++) {
            res[i] = nums[i] ==0 ? 0 : tmp[nums[i] - 1];
        }
        return res;
    }

    public static void main(String[] args) {

        int[][] input=new int[][]{
            {1,1,0,0,0},
                {1,1,1,1,0},
                    {1,0,0,0,0},
                        {1,1,0,0,0},
                            {1,1,1,1,1}
        };

        kWeakestRows(input, 3);

        int []arr = {-2,1,-3,4,-1,2,1,-5,4};
        int res = maxSubArray(arr);
    }

    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        int []dp = new int[len];
        dp[0]=nums[0];
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            int tmp = dp[i-1];
            int curNum = nums[i];
            dp[i] = Math.max(tmp,tmp+ curNum);
            res = Math.max(dp[i], res);
        }

        return res;
    }


    private static int[] getZerosAndOnes1(String str) {
         int []nums = new int[2];
         for (int i = 0; i < str.length(); i++) {
             int ch = str.charAt(i) - '0';
             if (ch == 0) {
                 nums[0]++;
             } else if (ch == 1) {
                 nums[1]++;
             }
         }
         return nums;
    }

    private static int[] getZerosAndOnes2(String str) {
        int[] zerosOnes = new int[2];
        int length = str.length();
        for (int i = 0; i < length; i++) {
            zerosOnes[str.charAt(i) - '0']++;
        }
        return zerosOnes;
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        int row = mat.length;
        int col = mat[0].length;

        int[]res = new int[k];
        int[][] arr = new int[col+1][row+1];
        int num=0;
        for (int i=0;i<row;i++) {
            int tmp=0;
            for (int j=0;j<col;j++) {
                if(mat[i][j]==1) {
                    tmp++;
                } else {
                    arr[tmp][i+1]=i+1;
                    if (tmp>0) {
                        num++;
                        res[i]=res[i]>j?j:res[i];
                    }
                    if (num==k){
                        return res;
                    }
                    break;
                }
            }
        }
        return res;
    }
}
