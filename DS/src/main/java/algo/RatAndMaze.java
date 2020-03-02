package algo;

public class RatAndMaze {


    public static void main(String[] args) {
        int[][] mazeArray = {{0, 1, 0}, {0, 1, 1 }, {0, 0, 0}};


        for (int i = 0; i < mazeArray.length; i++) {
            for (int j = 0; j < mazeArray[i].length; j++) {
                if(mazeArray[i][j] == 0 && j < mazeArray[i].length-1 && mazeArray[i][j+1] == 0) {
                    System.out.println("Moved Right" + mazeArray[i][j]);
                    mazeArray[i][j] = 2;
                } else if (mazeArray[i][j] == 0 && i < mazeArray.length-1 && mazeArray[i+1][j] == 0) {
                    System.out.println("Moved down" + mazeArray[i][j]);
                    mazeArray[i][j] = 2;
                    break;
                } else if(i == mazeArray.length-1 && j == mazeArray[i].length-1) {
                    System.out.println("Solved the puzzle");
                    mazeArray[i][j] = 2;
                    break;
                }
            }
        }

        for (int i = 0; i < mazeArray.length; i++) {
            for (int j = 0; j < mazeArray[i].length; j++) {
               System.out.print(mazeArray[i][j]);
            }
            System.out.println();
        }

    }

    /*private static void recursiveMethod(int i, int j, int[][] inputArray) {
        if(isBlocked()) {
            if(j-1 == 2) {
                recursiveMethod(i, j - 1, inputArray);
            } else if(i-1 == 2) {
                recursiveMethod(i-1, j, inputArray);
            }
        } else {
            if (inputArray[i][j] == 0 && j < inputArray[i].length - 1 && inputArray[i][j + 1] == 0) {
                System.out.println("Moved Right" + inputArray[i][j]);
                inputArray[i][j] = 2;
            } else if (inputArray[i][j] == 0 && i < inputArray.length - 1 && inputArray[i+1][j] == 0) {
                System.out.println("Moved Down" + inputArray[i][j]);
                inputArray[i][j] = 2;
            }
        }
        }

    }

    private static boolean isBlocked() {
    }*/
}
