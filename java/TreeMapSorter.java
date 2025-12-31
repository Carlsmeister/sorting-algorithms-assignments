import java.util.TreeMap;

public class TreeMapSorter implements IntSorter {

    @Override
    public void sort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }

        TreeMap<Integer, Integer> counts = new TreeMap<>();

        for (int value : a) {
            counts.put(value, counts.getOrDefault(value, 0) + 1);
        }

        int index = 0;

        for (var entry : counts.entrySet()) {
            int key = entry.getKey();
            int count = entry.getValue();

            for (int i = 0; i < count; i++) {
                a[index++] = key;
            }
        }
    }
}
