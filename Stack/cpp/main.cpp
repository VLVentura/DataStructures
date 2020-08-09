#include <bits/stdc++.h>

#include "Stack.h"

using namespace std;

int main(){

    Stack<int> stack;

    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);

    cout << stack.top() << endl;

    cout << stack.pop() << endl;
    cout << stack.pop() << endl;
    cout << stack.pop() << endl;

    cout << "size: " << stack.size() << endl;

    cout << "empty: " << stack.empty() << endl;


    return 0;
}