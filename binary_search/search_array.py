def binarySearch(arr, target):
    L, R = 0, len(arr) - 1

    while L <= R:
        mid = (L + R) // 2
        if arr[mid] < target:
            L = mid + 1
        elif arr[mid] > target:
            R = mid - 1
        else:
            return mid

    return - 1
