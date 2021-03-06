package basic.array;

/**
 * @description: 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 解题思路：
 * 双指针
 *
 *
 * @author: amber
 * @time: 2021-5-11 15:01
 */

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 2, 3, 4, 5, 5, 6};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[left] == nums[right]) {
                continue;
            } else {
                left++;
                nums[left] = nums[right];
            }
        }
        return ++left;
    }
}
