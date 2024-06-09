package jaemin.map;



public interface Map<K, V> extends Iterable<Pair<K, V>> {
    void put(K key, V value);
    V get( K key) throws KeyNotFoundException;
    int size();
    void remove(K key);

    @SuppressWarnings("serial")
	class KeyNotFoundException extends Exception {
        public KeyNotFoundException(Object k) {
            super(String.format("key = %s", k));
        }
    }
}