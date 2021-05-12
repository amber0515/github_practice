package basic.array;

/**
 * @description: 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * @author: amber
 * @time: 2021-5-12 14:59
 */

public class InvertArray {

    public static void main(String[] args) {

    }

    /**
     * 空间复杂度不为O(1)的额外数组法
     */
    public static void extraArrayRotate(int[] nums, int k) {
        int length = nums.length;
        if (length < 2) {
            return;
        }
        int[] temp = new int[length];
        for (int i = 0; i < length; i++) {
            temp[i] = nums[i];
        }
        for (int i = 0; i < length; i++) {
            nums[(i + k) % length] = temp[i];
        }
    }

    /**
     * 没想到道理的凑巧解法
     * 自反转：（元素右移）
     * 1. 反转所有顺序
     * 2. 左边k个元素回正（如元素左移，则右边k个元素回正）
     * 3. 余下元素回正
     */
    public static void autoRotate(int[] nums, int k) {
        int length = nums.length;
        if (length < 2) {
            return;
        }
        //注意 k >length 的情况
        k %= length;
        //全部旋转
        selfRotate(nums, 0, length - 1);
        selfRotate(nums, 0, k - 1);
        selfRotate(nums, k, length - 1);
    }

    private static void selfRotate(int[] nums, int start, int end) {
        int d = end - start;
        if (d < 1) {
            return;
        }
        for (int i = start; i < end; i++) {
            int temp = nums[i];
            nums[i] = nums[end];
            nums[end--] = temp;
        }
    }

}
