package basic.array;

import java.util.Arrays;

/**
 * @description: 给定一个整数数组，判断是否存在重复元素。
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * <p>
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 * @author: amber
 * @time: 2021-5-13 15:39
 */

public class JudgeDuplicates {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(stupidJudge(nums));
    }

    /**
     * 超时
     */
    public static boolean stupidJudge(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return false;
        }
        for (int i = 0; i < length -1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean sortThenJudge(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return false;
        }
        //Quick sort
        Arrays.sort(nums);
        for (int i = 0; i < length -1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static boolean hashThenJudge(int[] nums) {

        return false;
    }

}
