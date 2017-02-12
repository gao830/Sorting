package sorting;

import java.util.ArrayList;
import java.util.Arrays;

import com.sun.prism.TextureMap;

public class PickTopK {
	public static int[] list = { 4, 6, -30, 20, 1 };

	public static int count = 0;

	public static void main(String[] args) {

		int k = 3;

		ArrayList<Integer> arrayList = heapSort(list);

		quickSort(0, list.length - 1);
		for (int element : list) {
			System.out.print(element + " ");
		}
		// if (k <= list.length) {
		// int[] topKList = new int[k];
		// for (int i = 0; i < k; i++) {
		// topKList[i] = arrayList.get(i);
		// }
		// for (int element : topKList) {
		// System.out.print(element + " ");
		// }
		//
		// } else {
		// System.out.println("k is larger than the list size");
		// }

	}

	public static ArrayList<Integer> heapSort(int[] list) {

		ArrayList<Integer> arrayList = new ArrayList<>();
		ArrayList<Integer> arrayList1 = new ArrayList<>();
		// for (int element : list) {
		// arrayList.add(element);
		// }
		arrayList = heapify(list);
		// System.out.println(arrayList);
		// remove elements
		while (arrayList.size() > 0) {
			arrayList1.add(arrayList.get(0));
			arrayList.set(0, arrayList.get(arrayList.size() - 1));

			arrayList.remove(arrayList.size() - 1);

			int currentIndex = 0;
			while (currentIndex < arrayList.size()) {
				int leftChildIndex = 2 * currentIndex + 1;
				int rightChildIndex = 2 * currentIndex + 2;
				if (rightChildIndex < arrayList.size()) {
					int maxIndex = leftChildIndex;
					int maxValue = arrayList.get(maxIndex);

					if (arrayList.get(rightChildIndex) > maxValue) {
						maxIndex = rightChildIndex;
						maxValue = arrayList.get(maxIndex);
					}

					if (arrayList.get(currentIndex) < maxValue) {
						// swap
						int temp = arrayList.get(currentIndex);
						arrayList.set(currentIndex, maxValue);
						arrayList.set(maxIndex, temp);
						currentIndex = maxIndex;
					} else {
						break;
					}
				} else {
					break;
				}

			}
		}

		// System.out.println(arrayList1);
		return arrayList1;
	}

	public static ArrayList<Integer> heapify(int[] list) {
		ArrayList<Integer> tempList = new ArrayList<>();
		for (int element : list) {
			tempList.add(element);
			int currentIndex = tempList.size() - 1;
			while (currentIndex > 0) {
				int parentIndex = (currentIndex - 1) / 2;
				if (tempList.get(currentIndex) > tempList.get(parentIndex)) {
					int temp = tempList.get(parentIndex);
					tempList.set(parentIndex, tempList.get(currentIndex));
					tempList.set(currentIndex, temp);
				}
				currentIndex = parentIndex;
			}
		}
		return tempList;

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

	public static void quickSort(int start, int end) {

		if (start >= end)
			return;
		int left = start + 1;
		int right = end;
		int pivot = list[start];
		while (left < right) {
			while (list[left] >= pivot && left < right) {
				left++;
			}
			while (list[right] < pivot && right > left) {
				right--;
			}
			swap(left, right);
		}
		while (list[right] < pivot && right > start) {
			right--;
		}
		if (list[right] > pivot) {
			swap(start, right);
		}

		quickSort(start, right - 1);
		quickSort(right + 1, end);
	}

	public static void swap(int num1, int num2) {
		int temp = list[num1];
		list[num1] = list[num2];
		list[num2] = temp;
	}
}
