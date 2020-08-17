package algo;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        test1();
        //System.out.println(longestPalindromicSubstring("aa"));
//        System.out.println(longestPalindromicSubstring("abcdefghfedcbaa"));
//        System.out.println(longestPalindromicSubstring("ab12365456321bb"));
    }

    static void test1(){
        List<Integer> x = new ArrayList<>();
        System.out.println("testthis is testtest and you can do testestest aliright".indexOf("test",37));

        System.out.println("test".substring(0,1));
        char[] arr= "beginners".toCharArray();
        System.out.println("beginners".lastIndexOf(arr[1]));
    }

    public static String longestPalindromicSubstring(String str) {
        char[] arr = str.toCharArray();
        int len = str.length();
        int maxlen= 0;
        String ans ="";

        for(int i=0; i<len; i++){
            //get last index of current char
            char c = arr[i];
            int j = str.lastIndexOf(arr[i]);
            int startId=-1, endId=-1;
            //if it's single character
            if(i == j && maxlen<=1){
                maxlen = Math.max(maxlen, 1);
                ans = str.substring(i, j+1);
            }
            //if there is another character
            else{
                int start = i, n=1;
                int end =j;
                while(start<=end){
                    if(arr[start]==arr[end]){
                        n++;
                        start++;
                        end--;
                    }
                    else{
                        n=0;
                        break;
                    }
                }
                if(n >0 && maxlen< n){
                    startId= i;
                    endId= j;
                    ans = str.substring(startId, endId+1);
                    maxlen =n;
                }
            }
        }
        return ans;
    }
}
