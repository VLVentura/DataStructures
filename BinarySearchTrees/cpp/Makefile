COMPILER = g++ -std=c++11 -O2
FLAG = -Wall

bst: main.cpp I_Tree.h BinarySearchTree.h BinarySearchTree.cpp Node.h Node.cpp
	$(COMPILER) $(FLAG) main.cpp BinarySearchTree.h -o bst	

clean:
	rm bst

run:
	./bst