#!/usr/bin/env python3.8
from queue import Queue

queue = Queue()

queue.push_back(1)
queue.push_back(2)
queue.push_back(3)
queue.push_back(4)
queue.push_back(5)

print("len:", len(queue))
print("front:", queue.front())

print(queue.pop_front())
print(queue.pop_front())
print(queue.pop_front())

print("len:", len(queue))
print("front:", queue.front())
print(queue.empty())