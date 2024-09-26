# recursive
def factorial(n):
    if n <= 1:
        return 1

    return n * factorial(n - 1)

# iterative
def factorialIterative(n):
    res = 1
    while n > 1:
        res = res * n
        n -= 1
    return res