package cse41321.Homework5;

public class Main {
    public static void main(String[] args) {

        Integer[] data = {1, 2, 3, 4, 5};

        ChainedHashTable<Integer, Integer> table = new ChainedHashTable<>(5, 0.5, 2.0);

        System.out.println("buckets: " + table.getBucketsLength());
        System.out.println("elements: " + table.getSize());
        System.out.println("lf: " + table.getLoadFactor());
        System.out.println("max lf: " + table.getMaxLoadFactor());
        System.out.println("resize multiplier: " + table.getResizeMultiplier());
        System.out.println("=========");

        for (Integer i : data) {
            table.insert(i, i);
            System.out.println("buckets: " + table.getBucketsLength());
            System.out.println("elements: " + table.getSize());
            System.out.println("lf: " + table.getLoadFactor());
            System.out.println("max lf: " + table.getMaxLoadFactor());
            System.out.println("resize multiplier: " + table.getResizeMultiplier());
            System.out.println("=========");
        }

        System.out.println(table.lookup(5)); // 5
        System.out.println(table.lookup(6)); // NoSuchElementException

    }
}
