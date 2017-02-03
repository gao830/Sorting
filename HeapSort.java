package collection;

public class HeapSort {

	public static void main(String[] args) {
		int[] array = { -22, 0, 11, 1, 88, 19, -5,-1 };
		Heap heap = new Heap();
		for (int x : array) {
			heap.addItem(x);
		}
		// heap.getList();

		for (int i = array.length - 1; i >= 0; i--) {
			array[i] = heap.removeItem();
		}
		for (int x : array) {
			System.out.print(x + " ");
		}

	}

}
