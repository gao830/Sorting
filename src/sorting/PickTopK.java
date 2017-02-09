package sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class PickTopK {
	public static int[] list = { -1, 10, 2, 5, 6, 1, 0 };

	public static void main(String[] args) {

		int k = 3;

		heapSort(list);
		// for (int element : list) {
		// System.out.print(element + " ");
		// }
		// for(int element: list){
		// System.out.print(element+" ");
		// }
		// selectionSort(list);
		// if (k <= list.length) {
		// int[] topKList = new int[k];
		// for (int i = 0; i < k; i++) {
		// topKList[i] = list[i];
		// }
		// for (int element : topKList) {
		// System.out.print(element + " ");
		// }
		//
		// } else {
		// System.out.println("k is larger than the list size");
		// }

	}

	public static void heapSort(int[] list) {
		heapify(list);
		ArrayList<Integer> arrayList = new ArrayList<>();
		ArrayList<Integer> arrayList1 = new ArrayList<>();
		for (int element : list) {
			arrayList.add(element);
		}
		System.out.println(arrayList);
		// remove elements
		while (arrayList.size() > 0) {
			arrayList1.add(arrayList.get(0));
			arrayList.set(0, arrayList.get(arrayList.size() - 1));
			
			arrayList.remove(arrayList.size() - 1);
			
			int currentIndex = 0;
			while (currentIndex < arrayList.size() - 1) {
				int leftChildIndex = 2 * currentIndex + 1;
				int rightChildIndex = 2 * currentIndex + 2;
				
				int maxIndex = leftChildIndex;
				int maxValue = arrayList.get(maxIndex);

				if (arrayList.get(rightChildIndex) > maxValue) {
					maxIndex = rightChildIndex;
					maxValue = arrayList.get(rightChildIndex);
				}

				if (arrayList.get(currentIndex) < maxValue) {
					// swap
					int temp = arrayList.get(currentIndex);
					arrayList.set(currentIndex, maxValue);
					arrayList.set(maxIndex, temp);
					currentIndex = maxIndex;
				}

			}
		}

	}

	public static void heapify(int[] list) {
		int[] tempList = new int[list.length];
		for (int i = 0; i < list.length; i++) {
			tempList[i] = list[i];
			int childIndex = i;
			int parentIndex = (childIndex - 1) / 2;

			while (childIndex > 0) {

				if (tempList[parentIndex] < tempList[childIndex]) {
					int temp = tempList[childIndex];
					tempList[childIndex] = tempList[parentIndex];
					tempList[parentIndex] = temp;
				}
				parentIndex = (childIndex - 1) / 2;
				childIndex = parentIndex;

			}
		}

		for (int i = 0; i < list.length; i++) {
			list[i] = tempList[i];
		}

	}

	public static void selectionSort(int[] list) {
		int size = list.length;
		for (int i = 0; i < size - 1; i++) {
			int currentMax = list[i];
			int currentMaxIndex = i;
			for (int j = i + 1; j < size; j++) {
				if (currentMax < list[j]) {
					currentMax = list[j];
					currentMaxIndex = j;
				}
			}
			if (currentMaxIndex != i) {
				swap(currentMaxIndex, i);
			}

		}

	}

	public static void swap(int num1, int num2) {
		int temp = list[num1];
		list[num1] = list[num2];
		list[num2] = temp;
	}
}
