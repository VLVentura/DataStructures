#include <bits/stdc++.h>

#include "Queue.h"

using namespace std;

int main(){

    Queue<int> queue;

    queue.push_back(1);
    queue.push_back(2);
    queue.push_back(3);
    queue.push_back(4);
    queue.push_back(5);
    queue.push_back(6);

    cout << queue.front() << endl;
    cout << queue.pop_front() << endl;
    cout << queue.pop_front() << endl;
    cout << queue.pop_front() << endl;
    cout << queue.front() << endl;
    
    cout << "size: " << queue.size() << endl;
    cout << "empty: " << queue.empty() << endl;

    return 0;
}