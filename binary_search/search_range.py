def isCorrect(n):
    if n > 10:
        return 1
    elif n < 10:
        return -1
    else:
        return 0

def binarySearch(low, hi):
    while low <= hi:
        mid = (low + hi) // 2
        if isCorrect(mid) > 0:
            hi = mid - 1
        elif isCorrect < 0:
            low = mid + 1
        else:
            return mid
    return -1