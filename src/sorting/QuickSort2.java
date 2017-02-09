package sorting;

public class QuickSort2 {

	public static void quickSort(int[] list, int first, int last) {

		if (last > first) {
			int pivot = partition(list, first, last);
			quickSort(list, first, pivot - 1);
			quickSort(list, pivot + 1, last);
		}

	}

	public static int partition(int[] list, int first, int last) {
		int low = first + 1;
		int high = last;
		while (high > low) {
			while (low <= high && list[low] < list[first]) {
				low++;
			}
			while (low <= high && list[high] >= list[first]) {
				high--;
			}
			if (high > low) {
				int temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}
		while (list[high] >= list[first] && high > first) {

			high--;
		}
		if (list[first] > list[high]) {
			int temp = list[first];
			list[first] = list[high];
			list[high] = temp;
			return high;
		}
		return first;

	}

	public static void main(String[] args) {

		int[] array = { 10,-10,0,5,1,-2};
		quickSort(array, 0, array.length - 1);
		for (int x : array) {
			System.out.print(x + " ");
		}
	}

}
