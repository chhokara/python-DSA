class Array:
    def __init__(self):
        self.capacity = 2
        self.length = 0
        self.arr = [0] * 2
    
    def pushback(self, n):
        if self.length == self.capacity:
            self.resize()

        self.arr[self.length] = n
        self.length += 1

    def resize(self):
        self.capacity = self.capacity * 2
        newArr = [0] * self.capacity

        for i in range(self.length):
            newArr[i] = self.arr[i]

        self.arr = newArr

    def popback(self):
        if self.length > 0:
            self.length -= 1

    def get(self, i):
        if i < self.length:
            return self.arr[i]

    def insert(self, n, i):
        if i < self.length:
            self.arr[i] = n
            return

    def print(self):
        for i in range(self.length):
            print(self.arr[i])