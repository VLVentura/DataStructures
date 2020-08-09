package HashTable;

import java.util.Objects;

public class HashTable<K, V> {

	private static final int TABLE_SIZE = 10;

	private K[] keys;
	private V[] values;

	private int numOfItems;
	private int capacity;

	public HashTable() {
		this.keys = (K[]) new Object[TABLE_SIZE];
		this.values = (V[]) new Object[TABLE_SIZE];
		this.capacity = TABLE_SIZE;
		this.numOfItems = 0;
	}

	public HashTable(int newCapacity) {
		this.keys = (K[]) new Object[newCapacity];
		this.values = (V[]) new Object[newCapacity];
		this.capacity = newCapacity;
		this.numOfItems = 0;
	}

	public int size() {
		return this.numOfItems;
	}

	public boolean isEmpty() {
		return this.numOfItems == 0;
	}

	public void remove(K key){
		if(key == null){
			return;
		}

		int index = hash(key);

		while(!keys[index].equals(key)){
			index = (index+1) % capacity;
		}

		--numOfItems;
		keys[index] = null;
		values[index] = null;

		while(keys[index] != null){
			K tempKey = keys[index];
			V tempValue = values[index];

			keys[index] = null;
			values[index] = null;

			--numOfItems;
			put(tempKey, tempValue);

			index = (index + 1) % capacity;
		}

		if(numOfItems <= capacity / 3){
			resize(capacity/2);
		}
	}

	public void put(K key, V value){
		if(key == null || value == null){
			return;
		}

		// The table is 75% full - we need to optimize
		if(numOfItems >= capacity * 0.75){
			resize(2*capacity);
		}

		int index = hash(key);

		while(keys[index] != null){
			// update the value
			if(keys[index].equals(key)){
				values[index] = value;
				return;
			}

			index = (index + 1) % capacity;
		}

		keys[index] = key;
		values[index] = value;
		++numOfItems;
	}

	private void resize(int newCapacity){
		HashTable<K, V> newTable = new HashTable<K, V>(newCapacity);

		for(int i = 0; i < capacity; ++i){
			if(keys[i] != null){
				newTable.put(keys[i], values[i]);
			}
		}

		keys = newTable.getKeys();
		values = newTable.getValues();
		capacity = newTable.getCapacity();
	}

	public V get(K key) {
		if (key == null) {
			return null;
		}

		int index = hash(key);

		while (keys[index] != null) {
			if (keys[index].equals(key)) {
				return values[index];
			}

			index = (index + 1) % capacity;
		}

		return null;
	}

	private int hash(K key) {
		return Math.abs(key.hashCode()) % capacity;
	}

	public K[] getKeys() {
		return keys;
	}

	public V[] getValues() {
		return values;
	}

	public int getCapacity() {
		return capacity;
	}
}
