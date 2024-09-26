class ListNode:
    def __init__(self, val):
        self.val = val
        self.prev = None
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = ListNode(-1)
        self.tail = ListNode(-1)
        self.head.next = self.tail
        self.tail.prev = self.head

    def insertFront(self, val):
        newNode = ListNode(val)
        newNode.prev = self.head
        newNode.next = self.head.next

        self.head.next = newNode
        self.head.next.prev = newNode

    def insertEnd(self, val):
        newNode = ListNode(val)
        newNode.next = self.tail
        newNode.prev = self.tail.prev
        
        self.tail.prev.next = newNode
        self.tail.prev = newNode

    def removeFront(self):
        self.head.next = self.head.next.next
        self.head.next.next.prev = self.head

    def removeEnd(self):
        self.tail.prev = self.tail.prev.prev
        self.tail.prev.prev.next = self.tail

    def print(self):
        curr = self.head
        while curr:
            print(curr.val)
            curr = curr.next
