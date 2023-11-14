package com.GFG.Recursion;

public class RopeCuttingProblem {
    public static int noOfCuts(int n,int a, int b,int c){
        if(n==0){
            return 0;
        }
        if(n<=-1){
            return -1;
        }
        int maxCuts = Math.max(noOfCuts(n-a, a, b ,c),
                Math.max(noOfCuts(n-b , a ,b ,c),
                noOfCuts(n-c , a ,b ,c)));
        if(maxCuts == -1){
            return -1;
        }
        return maxCuts+1;
    }

    public static void main(String[] args) {
        System.out.println(noOfCuts(5,6,6,8));
    }
}
