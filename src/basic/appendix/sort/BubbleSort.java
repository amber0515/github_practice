package basic.appendix.sort;

/**
 * @description:
 *
 * 冒泡排序：
 * 每次循环后，最后一个一定是数列中的最大项，因此内循环次数 -i。
 *
 * @author: amber
 * @time: 2021-5-13 16:48
 */

public class BubbleSort {


    public static void sort(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
