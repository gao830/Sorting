package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Test {
	public static void main(String[] args) {
		// ArrayList<String> collection1 = new ArrayList<>();
		// collection1.add("New York");
		// collection1.add("Atlanta");
		// collection1.add("Dallas");
		// collection1.add("Madison");
		//
		// System.out.println("A list of cities in collection1:");
		// System.out.println(collection1);
		//
		// System.out.println("\nIs Dallas in collection1? " +
		// collection1.contains("Dallas"));
		//
		// collection1.remove("Dallas");
		// System.out.println("\n" + collection1.size() + " cities are in
		// collection1 now");
		//
		// ArrayList<String> collection2 = new ArrayList<>();
		// collection2.add("Seattle");
		// collection2.add("Portland");
		// collection2.add("Los Angeles");
		// collection2.add("Atlanta");
		//
		// System.out.println("\nA list of cities in collection2:");
		// System.out.println(collection2);
		//
		// ArrayList<String> c1 = (ArrayList<String>) collection1.clone();
		// c1.addAll(collection2);
		// System.out.println("\nCities in collection1 or collection2: ");
		// System.out.println(c1);
		//
		// c1 = (ArrayList<String>) (collection1.clone());
		// c1.retainAll(collection2);
		// System.out.print("\nCities in collection1 and collection2: ");
		// System.out.println(c1);
		//
		// c1 = (ArrayList<String>) (collection1.clone());
		// c1.removeAll(collection2);
		// System.out.print("\nCities in collection1, but not in 2: ");
		// System.out.println(c1);

		// Collection<String> collection = new ArrayList<>();
		// collection.add("New York");
		// collection.add("Atlanta");
		// collection.add("Dallas");
		// collection.add("Madison");
		//
		// Iterator<String> iterator = collection.iterator();
		// for (String element: collection)
		// System.out.print(element.toUpperCase() + " ");
		// System.out.println();
		Queue<String> queue = new PriorityQueue<>(Collections.reverseOrder());
		queue.offer("1");
		queue.offer("2");
		queue.offer("3");
		queue.offer("4");
		// for (String element: queue) {
		// System.out.print(element+" ");
		// }

		System.out.println();
		// while (queue.size() > 0) {
		// System.out.print(queue.remove()+" ");
		// }
		// System.out.println(queue.isEmpty());
		Set<Integer> set = new TreeSet<>();
		ArrayList<String> arrayList = new ArrayList<>();
		String text = "Good morning. Have a good class. " + "Have a good visit. Have fun!";

		// Create a TreeMap to hold words as key and count as value
		Map<String, Integer> map = new TreeMap<>();

		String[] words = text.split("[\\s+\\p{P}]");
		for (int i = 0; i < words.length; i++) {
			String key = words[i].toLowerCase();

			if (key.length() > 0) {
				if (!map.containsKey(key)) {
					map.put(key, 1);
				} else {
					int value = map.get(key);
					value++;
					map.put(key, value);
				}
			}
		}

		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		System.out.println(map.values());
		System.out.println(map.keySet());
		for (Map.Entry<String, Integer> entry: entrySet) 
			System.out.println(entry.getValue() + "\t" + entry.getKey());

	}
}
