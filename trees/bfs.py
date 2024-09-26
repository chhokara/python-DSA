def bfs(root):
    queue = dequeue()

    if root:
        queue.append(root)

    while len(queue) > 0:
        for i in range(len(queue)):
            curr = queue.popleft()
            print(curr.val)
            if curr.left:
                queue.append(curr.left)
            if curr.right:
                queue.append(curr.right)