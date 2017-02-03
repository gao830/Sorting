package sorting;

import java.util.ArrayList;

public class Heap {
//
	private ArrayList<Integer> arrayList = new ArrayList<>();

	public Heap() {

	}

	public Heap(int[] list) {
		for (int x : list) {
			arrayList.add(x);
		}
	}

	public void addItem(int item) {
		int parentIndex;
		arrayList.add(item);
		int currentIndex = arrayList.size() - 1;
		while (currentIndex > 0) {
			parentIndex = (currentIndex - 1) / 2;
			if (arrayList.get(currentIndex) > arrayList.get(parentIndex)) {
				int temp = arrayList.get(currentIndex);
				arrayList.set(currentIndex, arrayList.get(parentIndex));
				arrayList.set(parentIndex, temp);
			}

			currentIndex = parentIndex;
		}
	}

	public int removeItem() {
		int itemRemoved = arrayList.get(0);
		arrayList.set(0, arrayList.get(arrayList.size() - 1));
		arrayList.remove(arrayList.size() - 1);
		int currentIndex = 0;
		while (currentIndex < arrayList.size()) {

			int leftIndex = currentIndex * 2 + 1;
			int rightIndex = currentIndex * 2 + 2;
			if (rightIndex >= arrayList.size()) {
				break;
			}

			int maxIndex = leftIndex;
			// System.out.println(maxIndex);

			if (rightIndex < arrayList.size()) {
				if (arrayList.get(maxIndex) < arrayList.get(rightIndex)) {
					maxIndex = rightIndex;
				}
			}

			if (arrayList.get(currentIndex) < arrayList.get(maxIndex)) {
				int temp = arrayList.get(currentIndex);
				arrayList.set(currentIndex, arrayList.get(maxIndex));
				arrayList.set(maxIndex, temp);
				currentIndex = maxIndex;
			} else {
				break;
			}

		}

		return itemRemoved;
	}

	public void getList() {
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.print(arrayList.get(i) + " ");
		}
	}

}
