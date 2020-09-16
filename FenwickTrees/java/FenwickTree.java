public class FenwickTree {
	private int[] fenwickTree;

	public FenwickTree(int[] array){
		// the size of the fenwick tree is the size of the original array + 1 because the first item is 0
		this.fenwickTree = new int[array.length + 1];
		construct(array);
	}

	public int rangeSum(int startIndex, int endIndex){
		return sum(endIndex) - sum(startIndex - 1);
	}

	public int sum(int index){
		// indexes start with 0 but in the implementation we start with 1
		index++;

		int sum = 0;

		while(index > 0){
			sum += this.fenwickTree[index];
			// go to the parent and keep going (items on the left)
			index = parent(index);
		}

		return sum;
	}

	private void construct(int[] array){
		for(int i = 1; i <= array.length; ++i){
			update(i, array[i - 1]);
		}
	}

	private void update(int index, int num){
		// have to check all the ranges that include the index
		while(index < this.fenwickTree.length){
			this.fenwickTree[index] += num;
			// index of the items on the right
			index = next(index);
		}
	}

	// index of the item on the left (child)
	public int next(int index){
		return index + (index & (-index));
	}

	// index of the item on the right (parent)
	public int parent(int index){
		return index - (index & (-index));
	}
}
