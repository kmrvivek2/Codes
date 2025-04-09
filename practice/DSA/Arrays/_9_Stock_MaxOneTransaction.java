package practice.DSA.Arrays;

/*
Given an array prices[] of length n, representing the prices of the stocks on different days. The task is to find the maximum profit possible by buying and selling the stocks on different days when at most one transaction is allowed. Here one transaction means 1 buy + 1 Sell. If it is not possible to make a profit then return 0.
Note: Stock must be bought before being sold.

https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/buy-stock-2
 */

public class _9_Stock_MaxOneTransaction {
    public static void main(String[] args) {
        int prices[] = {7, 10, 1, 3, 6, 9, 2};
        System.out.println(maximumProfit(prices));

        prices = new int[]{7, 6, 4, 3, 1};
        System.out.println(maximumProfit(prices));

        prices = new int[]{1, 3, 5, 7, 9, 11};
        System.out.println(maximumProfit(prices));
    }

    public static int maximumProfit(int prices[]) {
        // Code here
        int profit=0, minPrice=prices[0];

        for(int i=0;i<prices.length;i++){
            minPrice = Math.min(minPrice, prices[i]);
            profit = Math.max(profit, prices[i]-minPrice);
        }

        return profit;
    }

}
