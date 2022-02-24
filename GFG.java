// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int[][] t;
    static int palindromicPartition(String str)
    {
        char[] s = str.toCharArray();
        int len = s.length;
        if(len==0)
            return 0;
        t = new int[len][len];
        for(int i=0;i<len;i++)
            for(int j=0;j<len;j++)
                t[i][j]=-1;
        return getPartitions(s,0,len-1);
    }
    
    static int getPartitions(char[] str,int beg, int end){
        if(t[beg][end]!=-1)
            return t[beg][end];
        if(isPalindrome(str,beg,end))
            return 0;
        if(end==beg+1)
            return 1;
        int minPartitions = Integer.MAX_VALUE;
        for(int i = beg;i<end;i++){
            int lValue = getPartitions(str,beg,i);
            int rValue = getPartitions(str,i+1,end);
            int tempAns = lValue+rValue+1;
            if(tempAns<minPartitions)
                minPartitions=tempAns;
        }
        t[beg][end]=minPartitions;
        return minPartitions;
    }
    
    static boolean isPalindrome(char[] str,int beg, int end){
        while(end>beg){
            if(str[beg]==str[end]){
                beg++;
                end--;
            }else
                break;
        }
        if(end>beg)
            return false;
        else 
            return true;
    }
}
