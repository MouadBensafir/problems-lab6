package problem4;

import java.util.*;

public class ListPerformanceComparison {

    private static final int SIZE = 100_000;        // total elements
    private static final int OPERATIONS = 10_000;   // random operations to test

    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();


        System.out.println("---- Performance Comparison ----");
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            arrayList.add(random.nextInt(1000));
            linkedList.add(random.nextInt(1000));
        }

        System.out.println("---- Populate both lists ----");
        // 2️⃣ Random insertions and deletions
        testRandomInsertDelete(arrayList, "ArrayList");
        testRandomInsertDelete(linkedList, "LinkedList");

        // 3️⃣ Sequential insertions/deletions at beginning and end
        testSequentialInsertDelete(arrayList, "ArrayList");
        testSequentialInsertDelete(linkedList, "LinkedList");

        // 4️⃣ Random access test
        testRandomAccess(arrayList, "ArrayList");
        testRandomAccess(linkedList, "LinkedList");
    }

    // ------------------------------------------------------------

    private static void testRandomInsertDelete(List<Integer> list, String name) {
        Random random = new Random();
        long start = System.nanoTime();

        list.add(SIZE/2, random.nextInt(1000));
        list.remove(random.nextInt(SIZE));

        long end = System.nanoTime();
        System.out.printf("%s - Random insert/delete: %.3f ms%n",
                name, (end - start) / 1_000_000.0);
    }

    // ------------------------------------------------------------

    private static void testSequentialInsertDelete(List<Integer> list, String name) {
        long start = System.nanoTime();
        Random random = new Random();

        // Insertions at beginning and end
        if (list instanceof ArrayList arr) {
            arr.add(0, random.nextInt(1000));
            arr.add(SIZE-1, random.nextInt(1000));
        } else if (list instanceof LinkedList linkd) {
            linkd.addFirst(random.nextInt(1000));
            linkd.addLast(random.nextInt(1000));
        }

        // Deletions at beginning and end
        if (list instanceof ArrayList arr) {
            arr.remove(0);
            arr.remove(SIZE-1);
        } else if (list instanceof LinkedList linkd) {
            linkd.removeFirst();
            linkd.removeLast();
        }

        long end = System.nanoTime();
        System.out.printf("%s - Sequential insert/delete (start/end): %.3f ms%n",
                name, (end - start) / 1_000_000.0);
    }

    // ------------------------------------------------------------

    private static void testRandomAccess(List<Integer> list, String name) {
        Random random = new Random();
        long start = System.nanoTime();

        long sum = 0;
        // sum of the all elements in the list
        for (Integer num : list) {
            sum += num;
        }

        long end = System.nanoTime();
        System.out.printf("%s - Random access (get): %.3f ms%n",
                name, (end - start) / 1_000_000.0);
    }
}

/* Analysis of the results
These performance tests show the main differences between ArrayList and LinkedList.
ArrayList is much faster for random access because its elements are stored in memory using
direct indexing, whereas LinkedList must traverse nodes sequentially to reach a given element.


LinkedList is only faster for sequential insertions and deletions at the beginning or end of the list,
because it can update the first or last pointers directly, whereas ArrayList must shift elements when
modifying the start of the list.

In summary, ArrayList is preferable when fast random access is required, while LinkedList is favorable
when we have frequent insertions or deletions especially at the beginning or end of the list.

*/


