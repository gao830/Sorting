package sorting;

public class HeapSort {

	public static void main(String[] args) {
		int[] array = { -1, 10, 2, 5, 6, 1, 0 };
		Heap heap = new Heap();
		for (int x : array) {
			heap.addItem(x);
		}
		// heap.getList();

		heap.getList();
		System.out.println();
		for (int i = array.length - 1; i >= 0; i--) {
			array[i] = heap.removeItem();
		}
		for (int x : array) {
			System.out.print(x + " ");
		}

	}

}
