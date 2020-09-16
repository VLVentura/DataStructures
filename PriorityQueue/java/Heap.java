import java.util.ArrayList;
import java.util.List;

public class Heap<T extends Comparable<T>> {

	private List<T> heap;

	public Heap(){
		heap = new ArrayList<>();
	}

	public void insert(T data){
		heap.add(data);
		fixUp(heap.size() - 1);
	}

	private void fixUp(int index){
		int parentIndex = (index - 1) / 2;

		// If the child of a node if smaller we need to change them and we need to call the fixUp with the new parent
		// unless he is the root node (index = 0)
		if(index > 0 && heap.get(index).compareTo(heap.get(parentIndex)) > 0){
			swap(index, parentIndex);
			fixUp(parentIndex);
		}
	}

	public T peek(){
		return heap.get(0);
	}

	public T poll(){
		T max = peek();

		swap(0, heap.size() - 1);
		heap.remove(heap.size() - 1);

		fixDown(0);
		return max;
	}

	private void fixDown(int index){
		int indexLeft = 2 * index + 1;
		int indexRight = 2 * index + 2;

		// In a max heap, the parent node is always greater than the children
		int indexLargest = index;

		// If the left children is greater than the parent: largest is in the left node
		if(indexLeft < heap.size() && heap.get(indexLeft).compareTo(heap.get(indexLargest)) > 0){
			indexLargest = indexLeft;
		}
		// If the right children is greater than the parent: largest is in the right node
		if(indexRight < heap.size() && heap.get(indexRight).compareTo(heap.get(indexLargest)) > 0){
			indexLargest = indexRight;
		}
		// We do not want to swap items with themselves
		if(index != indexLargest){
			swap(index, indexLargest);
			fixDown(indexLargest);
		}
	}

	private void swap(int index1, int index2){
		T temp = heap.get(index1);
		heap.set(index1, heap.get(index2));
		heap.set(index2, temp);
	}

	public void heapSort(){
		int size = heap.size();

		for(int i = 0; i < size; ++i){
			T max = poll();
			System.out.print(max + " ");
		}
	}

	public int size(){
		return heap.size();
	}
}
