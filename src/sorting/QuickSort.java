package sorting;

public class QuickSort {
	static int[] arr = { -1, 10, 2, -5, 6, 10, 0, 7 };

	public static void swap(int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	public static void quick_sort_recursive(int start, int end) {
		if (start >= end)
			return;
		int mid = arr[start];
		int left = start+1, right = end ;
		while (left < right) {
			while (arr[left] < mid && left < right)
				left++;
			while (arr[right] >= mid && left < right)
				right--;
			swap(left, right);
		}
		if (arr[right] < arr[start])
			swap(right, start);
		else
			left++;
		
		quick_sort_recursive(start, right - 1);
		quick_sort_recursive(right + 1, end);
	}

	public static void sort(int[] arrin) {
		arr = arrin;
		quick_sort_recursive(0, arr.length - 1);
	}

	public static void main(String[] args) {

		sort(arr);
		for(int x: arr){
			System.out.print(x+" ");
		}
		

	}

}
