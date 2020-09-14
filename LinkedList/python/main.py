#!/usr/bin/env python3.8
from linked_list import LinkedList

llist = LinkedList(7)

llist.insert(1)
llist.insert(2)

llist.traverse_list()
print()
print("len:", len(llist))
print("middle:",llist.middle())

llist.insert(3)
llist.insert(4)
llist.insert(5)

llist.reverse()
llist.traverse_list()

print()
print("len:", len(llist))
print("middle:",llist.middle())

llist.remove(5)
llist.reverse()
llist.traverse_list()
print()
print("len:", len(llist))
print("middle:",llist.middle())

llist.remove(1)
llist.traverse_list()
print()
print("len:", len(llist))
print("middle:",llist.middle())

llist.remove(3)
llist.traverse_list()
print()

print("len:", len(llist))
print("middle:",llist.middle())
print(llist.empty())