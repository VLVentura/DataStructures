#!/usr/bin/env python3.8
from stack import Stack

stack = Stack()

stack.push(1)
stack.push(2)
stack.push(3)
stack.push(4)
stack.push(5)

print(len(stack))
print(stack.empty())
print("top:", stack.top())

print(stack.pop())
print(stack.pop())
print(stack.pop())
print("len: ", len(stack))