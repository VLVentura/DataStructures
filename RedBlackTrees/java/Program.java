import RedBlackTree.RedBlackTree;
import RedBlackTree.Tree;

public class Program {
	public static void main(String[] args) {

		Tree<Integer> rbt = new RedBlackTree<Integer>();

		/* Left heavy situation
		 * rbt.insert(10);
		 * rbt.insert(20);
		 * rbt.insert(30);
		 */

		/* Right heavy situation
		 * rbt.insert(10);
		 * rbt.insert(5);
		 * rbt.insert(1);
		 */

		/* Left-Right situation
		 * rbt.insert(10);
		 * rbt.insert(5);
		 * rbt.insert(6);
		 */

		/* Right-Left situation
		 * rbt.insert(10);
		 * rbt.insert(20);
		 * rbt.insert(15);
		 */
	}
}