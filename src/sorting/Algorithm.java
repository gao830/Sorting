package sorting;

public class Algorithm {

	public static void main(String[] args) {
		int array[] = { 4, 6, -30, 20, 1 };
		// for (int element : array) {
		// System.out.print(element + " ");
		// }
		//
		// System.out.println();
		// for (int element : selectionSort(array)) {
		// System.out.print(element + " ");
		// }
		System.out.println(fibonacciDynamic(5));
		// System.out.println(binarySearch(array, 20));

	}

	public static int[] selectionSort(int array[]) {
		for (int i = 0; i < array.length - 1; i++) {
			int currentMin = array[i];
			int minIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (currentMin > array[j]) {
					currentMin = array[j];
					minIndex = j;
				}
			}
			if (minIndex != i) {
				array[minIndex] = array[i];
				array[i] = currentMin;

			}

		}

		return array;
	}

	public static boolean binarySearch(int array[], int key) {
		int lowIndex = 0;
		int highIndex = array.length - 1;
		int midIndex = 0;
		while (highIndex >= lowIndex) {
			midIndex = (lowIndex + highIndex) / 2;
			if (key == array[midIndex]) {
				return true;
			} else if (key > array[midIndex]) {
				lowIndex = midIndex + 1;
			} else {
				highIndex = midIndex - 1;
			}

		}

		return false;
	}

	// fibonacci using recursion
	public static int fibonacci(int index) {
		if (index == 0) {
			return 0;
		} else if (index == 1) {
			return 1;
		} else {
			return fibonacci(index - 1) + fibonacci(index - 2);
		}
	}
//fibonacci using dynamic programming 
	public static int fibonacciDynamic(int index) {
		int f0 = 0;
		int f1 = 1;
		int f2 = 1;
		if (index == 0) {
			return f0;
		} else if (index == 1) {
			return f1;
		} else if (index == 2) {
			return f2;
		} else {
			for (int i = 3; i <= index; i++) {
				f0 = f1;
				f1 = f2;
				f2 = f0 + f1;
			}
			return f2;
		}

	}

}
