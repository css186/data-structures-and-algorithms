// ChainedHashTable.java
package cse41321.Homework5;

import cse41321.containers.KeyValuePair;
import cse41321.containers.SinglyLinkedList;
import cse41321.exceptions.DuplicateKeyException;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ChainedHashTable<K, V> {
    // Table of buckets (an array of key-value pars)
    private SinglyLinkedList[] table;

    // Create size variable to store total numbers of elements in the table
    private int size;

    // Create two additional variable(maxLoadFactor and resizeMultiplier)
    private double maxLoadFactor;

    private double resizeMultiplier;

    public ChainedHashTable() {
    }

    @SuppressWarnings("unchecked")
    public ChainedHashTable(int buckets, double maxLoadFactor, double resizeMultiplier) {
        // Create table of empty buckets
        table = new SinglyLinkedList[buckets];
        for (int i = 0; i < table.length; ++i) {
            table[i] = new SinglyLinkedList<>();
        }

        size = 0;

        this.maxLoadFactor = maxLoadFactor;
        this.resizeMultiplier = resizeMultiplier;

    }

    public int getSize() {
        return size;
    }

    public double getMaxLoadFactor() {
        return maxLoadFactor;
    }

    public double getResizeMultiplier() {
        return resizeMultiplier;
    }

    public int getBucketsLength() {
        return table.length;
    }

    public double getLoadFactor() {
        return (double) getSize() / (double) table.length;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public void insert(K key, V value) throws
            IllegalArgumentException,
            DuplicateKeyException {
        if (key == null) {
            throw new IllegalArgumentException("key must not be null");
        }
        if (contains(key)) {
            throw new DuplicateKeyException();
        }

        getBucket(key).insertHead(new KeyValuePair<K, V>(key, value));
        ++size;

        // Compute current load factor
        double currentLF = getLoadFactor();

        // If current lf > max lf, then resize the hash table
        if (currentLF >= maxLoadFactor) {
            // Compute new length of buckets
            int newBuckets = (int) (getBucketsLength() * resizeMultiplier);
            resize(newBuckets);
        }
    }
    public void resize(int newBuckets) {

        // Create new table with new numbers of buckets
        SinglyLinkedList[] newTable = new SinglyLinkedList[newBuckets];

        // Initialized new table with empty buckets
        for (int i = 0; i < newBuckets; ++i) {
            newTable[i] = new SinglyLinkedList<>();
        }

        // Rehash all existing buckets from old table into new table
        for (SinglyLinkedList bucket : table) {
            SinglyLinkedList<KeyValuePair<K, V>>.Element elem = bucket.getHead();

            // while element exits, rehash and store into new table
            while (elem != null) {
                K key = elem.getData().getKey();
                V value = elem.getData().getValue();

                // Multiplication Method
                double newHashValue = Math.abs(key.hashCode()) * 0.618;
                double fraction = newHashValue - Math.floor(newHashValue);
                int newBucketIndex = (int) (fraction * newBuckets);

                // Division Method
                // int newBucketIndex = Math.abs(key.hashCode()) % newBuckets;

                newTable[newBucketIndex].insertHead(new KeyValuePair<>(key, value));
                elem = elem.getNext();
            }
        }

        // Point to new table
        table = newTable;
    }

    public V remove(K key) throws
            IllegalArgumentException,
            NoSuchElementException {
        if (key == null) {
            throw new IllegalArgumentException("key must not be null");
        }

        // If empty bucket
        SinglyLinkedList<KeyValuePair<K, V>> bucket = getBucket(key);
        if (bucket.isEmpty()) {
            throw new NoSuchElementException();
        }

        // If at head of bucket
        SinglyLinkedList<KeyValuePair<K, V>>.Element elem = bucket.getHead();
        if (key.equals(elem.getData().getKey())) {
            --size;
            return bucket.removeHead().getValue();
        }

        // Scan rest of bucket
        SinglyLinkedList<KeyValuePair<K, V>>.Element prev = elem;
        elem = elem.getNext();
        while (elem != null) {
            if (key.equals(elem.getData().getKey())) {
                --size;
                return bucket.removeAfter(prev).getValue();
            }
            prev = elem;
            elem = elem.getNext();
        }

        throw new NoSuchElementException();
    }

    public V lookup(K key) throws
            IllegalArgumentException,
            NoSuchElementException {
        if (key == null) {
            throw new IllegalArgumentException("key must not be null");
        }

        // Scan bucket for key
        SinglyLinkedList<KeyValuePair<K, V>>.Element elem =
                getBucket(key).getHead();
        while (elem != null) {
            if (key.equals(elem.getData().getKey())) {
                return elem.getData().getValue();
            }
            elem = elem.getNext();
        }

        throw new NoSuchElementException();
    }

    public boolean contains(K key) {
        try {
            lookup(key);
        } catch (IllegalArgumentException ex) {
            return false;
        } catch (NoSuchElementException ex) {
            return false;
        }

        return true;
    }

    private SinglyLinkedList<KeyValuePair<K, V>> getBucket(K key) {
        // Division method
        // return table[Math.abs(key.hashCode()) % table.length];

        // Multiplication method
        double hashValue = Math.abs(key.hashCode()) * 0.618;
        double fraction = hashValue - Math.floor(hashValue);
        int index = (int) (fraction * table.length);
        return table[index];
    }

    private class KeysIterator implements Iterator<K> {
        private int remaining;  // Number of keys remaining to iterate
        private int bucket;     // Bucket we're iterating
        private SinglyLinkedList<KeyValuePair<K, V>>.Element elem;
                                // Position in bucket we're iterating

        public KeysIterator() {
            remaining = ChainedHashTable.this.size;
            bucket = 0;
            elem = ChainedHashTable.this.table[bucket].getHead();
        }

        public boolean hasNext() {
            return remaining > 0;
        }

        public K next() {
            if (hasNext()) {
                // If we've hit end of bucket, move to next non-empty bucket
                while (elem == null) {
                    elem = ChainedHashTable.this.table[++bucket].getHead();
                }

                // Get key
                K key = elem.getData().getKey();

                // Move to next element and decrement entries remaining
                elem = elem.getNext();
                --remaining;

                return key;
            } else {
                throw new NoSuchElementException();
            }
        }
    }

    public Iterable<K> keys() {
        return new Iterable<K>() {
            public Iterator<K> iterator() {
                return new KeysIterator();
            }
        };
    }
}
