def find_pairs_with_sum(nums, target):
    pairs = []
    num_counts = {}

    for num in nums:
        complement = target - num
        if complement in num_counts:
            pairs.extend([(complement, num)] * num_counts[complement])
        
        if num in num_counts:
            num_counts[num] += 1
        else:
            num_counts[num] = 1

    return pairs

# Example usage:
nums = [3,3,3,3,1,1,5,5]
target = 6
print(find_pairs_with_sum(nums, target))
