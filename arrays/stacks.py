class Stack:
    def __init__(self):
        self.stack = []
    
    # Time - O(1)
    def push(self, n):
        self.stack.append(n)

    # Time - O(1)
    def pop(self):
        return self.stack.pop()

    # Time - O(1)
    def peek(self):
        return self.stack[-1]