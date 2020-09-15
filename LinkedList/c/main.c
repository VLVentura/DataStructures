#include <stdio.h>
#include <stdlib.h>

#include "LinkedList.h"

int main(){
    
    Node *root = createList();

    root = insertAtEnd(root, 1);
    root = insertAtEnd(root, 2);
    root = insertAtEnd(root, 2);
    root = insertAtEnd(root, 3);
    root = insertAtEnd(root, 4);

    root = removeNode(root, 2);
    
    root = reverse(root);
    traverse(root);
    root = reverse(root);
    traverse(root);

    root = removeNode(root, 1);
    root = removeNode(root, 4);

    traverse(root);

    printf("middle: %d\n", middle(root));
    printf("%d\n", isEmpty());
    printf("%d\n", size());

    return 0;
}