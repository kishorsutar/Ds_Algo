package algo;

import java.util.*;

public class MoviesOnFlight {
    public static void main(String[] args) {
        List<Integer> movie_duration1 = new ArrayList<Integer>(Arrays.asList(90, 85, 75, 60, 120, 150, 125));
        List<Integer> movie_duration2 = new ArrayList<Integer>(Arrays.asList(90, 85, 75, 60, 155, 150, 125));
        List<Integer> movie_duration3 = new ArrayList<Integer>(Arrays.asList(990, 85, 75, 60, 120,110,110, 150, 125));

        int[] res1 = movieLength(movie_duration1, 250);
        System.out.println("[" + res1[0] + "," + res1[1] + "]");
        int[] res2 = movieLength(movie_duration2, 250);
        System.out.println("[" + res2[0] + "," + res2[1] + "]");
        int[] res3 = movieLength(movie_duration3, 250);
        System.out.println("[" + res3[0] + "," + res3[1] + "]");

    }

    static int[] movieLength(List<Integer> movieList, int duration) {
        int d = duration - 30;
        // key - movie duration, value - index of the dur in array
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < movieList.size(); i++) {
            map.put(movieList.get(i), i);
        }
        Collections.sort(movieList);

        int left = 0;
        int right = movieList.size() - 1;
        int[] res = new int[2];
        int maxTime = 0;
        while (left < right) {
            int movieTime = movieList.get(left) + movieList.get(right);

            if (movieTime <= d) {
                if (maxTime < movieTime) {
                    maxTime = movieTime;
                    if (map.get(movieList.get(left)) != map.get(movieList.get(right)))                     {
                        res[0] = map.get(movieList.get(left));
                        res[1] = map.get(movieList.get(right));
                    }
                }
                left++;
            } else {
                right--;
            }
        }

        return res;
    }
}
