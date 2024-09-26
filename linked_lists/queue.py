class ListNode:
    def __init__(self, val):
        self.val = val
        self.next = None

class Queue:
    def __init__(self):
        self.left = self.right = None

    def enqueue(self, val):
        newNode = ListNode(val)

        if self.right:
            self.right.next = newNode
            self.right = self.right.next
        else:
            self.left = self.right = newNode

    def dequeue(self):
        if not self.left:
            return None

        val = self.left.val
        self.left = self.left.next
        if not self.left:
            self.right = None
        return val

    def print(self):
        curr = self.left
        while curr:
            print(curr.val)
            curr = curr.next

