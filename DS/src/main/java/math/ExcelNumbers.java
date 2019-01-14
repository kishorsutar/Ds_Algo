package math;


import java.util.ArrayList;
import java.util.Collections;

public class ExcelNumbers {

    public static void main(String[] args) {
       System.out.println( plusOne(new ArrayList<Integer>(){
           {
               add(1);
               add(1);
               add(1);
               add(3);
               add(2);
               add(1);
               add(1);
               add(2);
               add(5);
               add(9);
               add(6);
               add(5);

//               add(5);
//               add(5); 1, 1, 1, 3, 2, 1, 1, 2, 5, 9, 6, 5
           }
       }));
    }

         static int titleToNumber (String s) {
            int result = 0;
            for (int i = 0; i < s.length(); i++) {
                result *= 26;
                System.out.println(s.charAt(i) - 'A');
                result += s.charAt(i) - 'A' + 1;

            }

            return result;
        }

        static int palindrome(int a) {

            System.out.println("Re,"+a%10);
String value = "124";
            char[] values = value.toCharArray();
            return a/10;
        }


    public static ArrayList<Integer> plusOne(ArrayList<Integer> a) {

        ArrayList<Integer> resultList = new ArrayList<Integer>();

        StringBuilder str = new StringBuilder();

        for(int i = 0; i < a.size(); i++) {
            str.append(a.get(i));
        }

        int newInt = Integer.valueOf(str.toString()) + 1;
//        String value = String.valueOf(newInt);
//        char[] values = value.toCharArray();

       /* for(int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            System.out.println();
            System.out.println(Integer.valueOf(values[i]));
            resultList.add(Integer.valueOf(values[i]));

        }*/
int r = 0;
int q = 0;
        while(newInt > 0 ) {
            r = newInt%10;
            resultList.add(r);
            newInt = newInt/10;
        }
        Collections.reverse(resultList);

        return resultList;


    }

}
