#include <stdio.h>
#include <stdlib.h>

#include "LinkedList.h"

int main(){
    
    Node *root = createList();

    root = insert(root, 1);
    root = insert(root, 2);
    root = insert(root, 2);
    root = insert(root, 3);
    root = insert(root, 4);

    root = removeNode(root, 2);
    
    root = reverse(root);
    traverseList(root);
    root = reverse(root);
    traverseList(root);

    root = removeNode(root, 1);
    root = removeNode(root, 4);

    traverseList(root);

    printf("middle: %d\n", middle(root));
    printf("%d\n", emptyList());
    printf("%d\n", sizeList());

    return 0;
}