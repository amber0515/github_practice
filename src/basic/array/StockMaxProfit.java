package basic.array;

/**
 * @description:
 * @author: amber
 * @time: 2021-5-11 15:49
 */

public class StockMaxProfit {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(greedyAlogorithm(prices));
    }

    /**
     * 1. 定义动态状态
     * dp[i][0] 的值为第i天手里没股票的最大利润
     * dp[i][1] 的值为第i天手里有股票的最大利润
     * 2. 编写递推方程
     * 第i天手里没有股票-> 1.前一天手里有股票，i日把手里的股票卖了：dp[i][0] = dp[i-1][1] + prices[i]
     * 2.前一天手里没有股票，i日没有行动 dp[i][0] = dp[i-1][0]
     * 推出：dp[i][0] = max(dp[i-1][1] + prices[i], dp[i-1][0])
     * 第i天手里有股票->   1.前一天手里有股票，i日没有行动 dp[i][1] = dp[i-1][1]
     * 2.前一天手里没有股票，i日买入股票 dp[i][1] = dp[i-1][0] - prices[i]
     * 推出：dp[i][1] =max(dp[i-1][1], dp[i-1][0] - prices[i])
     * 3. 确定边界条件
     * 第一天没有行动：dp[0][0] = 0;
     * 第一天买股票：dp[0][1] = -prices[0]
     * 4. 确定返回结果
     * 最后一天的最大利润一定是清仓：return dp[prices.length -1][0];
     */
    public static int dynamicMaxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int days = prices.length;
        int[][] dp = new int[days][2];
        //初始状态
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        //动态规划
        for (int i = 1; i < days; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    /**
     * 根据此题情况的优化
     *
     * @return
     */
    public static int updateDynamic(int[] prices) {
        int days = prices.length;
        if (days < 2) {
            return 0;
        }
        //初始状态
        int uHold = 0;
        int hold = -prices[0];
        //动态规划
        for (int i = 1; i < days; i++) {
            uHold = Math.max(hold + prices[i], uHold);
            hold = Math.max(hold, uHold - prices[i]);
        }
        return uHold;
    }

    /**
     * 具体思路：找到所有连续盈利的上升段，加和自然就是最大利润。
     */
    public static int greedyAlogorithm(int[] prices) {
        int days = prices.length;
        if (days < 2) {
            return 0;
        }
        int total = 0, index = 0;
        while (index < days -1) {
            //找到下跌或不盈利的最后点（index值 >= index+1值），指针后移。
            if (index < days -1 && prices[index] >= prices[index +1]) {
                index++;
            }
            int min = prices[index];
            //找到上涨的最后点
            if (index < days -1 && prices[index] < prices[index +1]) {
                index++;
            }
            int max = prices[index];
            total += max - min;
        }
        return total;
    }
}
