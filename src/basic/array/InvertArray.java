package basic.array;

import java.util.Arrays;

/**
 * @description: 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * <p>
 * 解法：
 * 1. 额外数组：性能佳，空间次
 * 2. 三次自旋转：性能最佳，空间最佳
 * 3. 约瑟夫环：次之
 * @author: amber
 * @time: 2021-5-12 14:59
 */

public class InvertArray {

    public static void main(String[] args) {
        int[] nums = {-1, -100, 3, 99};
        int k = 2;
        extraArrayRotate(nums, k);
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
        System.out.println(Arrays.toString(nums));
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

    /**
     * 约瑟夫环交换
     * trap：如果(k + i * k) % length被整除，交换元素就会一直打转。例：4个元素，k=2.
     */
    public static void josephusRing(int[] nums, int k) {
        int length = nums.length;
        if (length < 2 || k < 1) {
            return;
        }
        int hold = nums[0], index = 0;
        //防止原地循环：设置状态数组，如果该元素被换过，则指针指向下一个元素。
        boolean[] exchanged = new boolean[length];

        for (int i = 0; i < length; i++) {
            index = (index +  k) % length;
            if (!exchanged[index]) {
                int temp = nums[index];
                nums[index] = hold;
                hold = temp;
                exchanged[index] = true;
            } else {
                //指针指向下一个元素，并保存。
                index = (index + 1) % length;
                hold = nums[index];
                //只更新了hold与指针位置，不算一次循环。
                i--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

}
