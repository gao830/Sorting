package sorting;

public class Sorting {

	
	public static void main(String[] args) {

		int[] list = { 2, 3, 5, 6, 1, -2, 3, 14, 12 };
		mergeSort(list);
		for (int i = 0; i < list.length; i++)
			System.out.print(list[i] + " ");

		// int array[] = { 2, 5, 1, 9, 8, 16 };
		// for (int x : array) {
		// System.out.print(x + " ");
		// }
		// System.out.println();
		// for (int y : bubbleSort(array)) {
		// System.out.print(y + " ");
		// }
	}

	public static int[] insertionSort(int list[]) {
		for (int i = 1; i < list.length; i++) {
			int current = list[i];
			int j = 0;
			for (j = i - 1; j >= 0 && list[j] > current; j--) {
				list[j + 1] = list[j];
			}
			list[j + 1] = current;
		}
		return list;
	}

	public static int[] bubbleSort(int list[]) {
		boolean tester = true;
		for (int i = 1; i < list.length && tester; i++) {
			tester = false;
			for (int j = 0; j < list.length - i; j++) {
				if (list[j] > list[j + 1]) {
					int temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
					tester = true;
				}
			}
		}
		return list;
	}

	public static void mergeSort(int list[]) {
		if (list.length > 1) {
			int[] leftList = new int[list.length / 2];
			System.arraycopy(list, 0, leftList, 0, list.length / 2);
			mergeSort(leftList);

			int length = list.length - list.length / 2;
			int[] rightList = new int[length];
			System.arraycopy(list, list.length/2 , rightList, 0, length);
			mergeSort(rightList);

			merge(leftList, rightList, list);
		}

	}

	public static void merge(int leftList[], int rightList[], int list[]) {
		int index1 = 0, index2 = 0, index3 = 0;
		while (index1 < leftList.length && index2 < rightList.length) {
			if (leftList[index1] < rightList[index2]) {
				list[index3++] = leftList[index1++];
			} else {
				list[index3++] = rightList[index2++];
			}
		}
		while (index1 < leftList.length) {
			list[index3++] = leftList[index1++];
		}

		while (index2 < rightList.length) {
			list[index3++] = rightList[index2++];
		}

	}

}
