class Sorting {

public static void main(String[] args) {
	System.out.println("Test sorting");
	int[] test = new int[]{3,6,1,8,0,2};

	for (int i : test ) {
		System.out.println(i);	
	}
		bubbleSort(test);
}

// input
// output
// special cases 
// error handling
private static void bubbleSort(int[] inputArray) {
	for(int i = 0; i < inputArray.length; i++) {
		for (int j = 0; j < i; j++) {
			if(inputArray[j] < inputArray[j+1]) {
				swap(inputArray, j+1, j);
			}
		}
	}
	System.out.println("Test ouptut");
	for (int i : inputArray ) {
		System.out.println(i);	
	}
	
}

private static void swap(int[] testArray, int i, int j) {
	int temp = testArray[j];
	testArray[j] = testArray[i];
	testArray[i] = temp;
}

} 