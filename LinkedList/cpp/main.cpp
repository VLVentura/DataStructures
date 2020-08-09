#include <bits/stdc++.h>

#include "LinkedList.h"

using namespace std;

int main(){

    LinkedList<int> list;
    LinkedList<int> another_list(3);
    I_List<int> *test = new LinkedList<int>(1);

    cout << "list size: " << list.size() << endl;
    cout << "another_list size: " <<  another_list.size() << endl;

    cout << "list empty: " << list.empty() << endl;
    cout << "another_list size: " << another_list.empty() << "\n" << endl;

    list.insert(1);
    cout << "middle com um: " << list.middle() << endl;
    list.insert(2);
    list.insert(3);
    list.insert(4);
    list.insert(5);

    list.reverse();

    list.traverseList();
    cout << "\n";
    cout << "list size: " << list.size() << endl;
    cout << "middle: " << list.middle() << endl;
    cout << "\n";

    list.reverse();

    list.remove(1);
    list.traverseList();
    cout << "\n";
    cout << "list size: " << list.size() << endl;
    cout << "middle: " << list.middle() << endl;
    cout << "\n";
    
    list.remove(5);
    list.traverseList();
    cout << "\n";
    cout << "list size: " << list.size() << endl;
    cout << "middle: " << list.middle() << endl;
    cout << "\n";

    list.remove(3);
    list.traverseList();
    cout << "\n";
    cout << "list size: " << list.size() << endl;
    cout << "middle: " << list.middle() << endl;
    cout << "\n";

    cout << test->size() << endl;

    return 0;
}