package practice.DSA.Arrays;

/*
The cost of stock on each day is given in an array price[]. Each day you may decide to either buy or sell the stock i at price[i], you can even buy and sell the stock on the same day. Find the maximum profit that you can get.
Note: A stock can only be sold if it has been bought previously and multiple stocks cannot be held on any given day.

https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/stock-buy-and-sell2615
https://www.geeksforgeeks.org/stock-buy-sell/
 */

public class _8_Stock_MultipleTransactionAllowed {
    public static void main(String[] args) {
        int prices[] = {1,5,3,8,12};
        System.out.println(maximumProfit(prices));

        prices = new int[]{100, 180, 260, 310, 40, 535, 695};
        System.out.println(maximumProfit(prices));
    }

    public static int maximumProfit(int prices[]) {
        // code here
        int profit=0,buyValue=-1, sellValue=-1;
        int n = prices.length;

        for(int i=0;i<n-1;i++){
            if(buyValue==-1 && prices[i]<prices[i+1] && i!=(n-1)){
                buyValue = prices[i];
                sellValue = -1;
            }
            else if(buyValue!=-1 && prices[i]>prices[i+1]){
                sellValue = prices[i];
                profit = calProfit(profit, buyValue, sellValue);
                buyValue = -1;
                sellValue = -1;
            }
        }

        if(buyValue!=-1 && sellValue==-1){
            sellValue = prices[n-1];
            profit = calProfit(profit, buyValue, sellValue);
        }

        return profit;
    }

    public static int calProfit(int profit, int buyValue, int sellValue){
        //System.out.println("Buy Value: "+buyValue);
        //System.out.println("Sell Value: "+sellValue);
        //System.out.println("Profit Before: "+profit);

        profit += sellValue - buyValue;

        //System.out.println("Profit After: "+profit);

        return profit;
    }
}
