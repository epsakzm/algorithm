import sys

input = sys.stdin.readline

n = int(input())
cd = []

for i in range(1, n + 1):
    cd.append(i)

print(cd)
while (len(cd) > 1):
    print(cd.pop())
    cd.pop()
    if len(cd) == 0:
        break
    print("cd2: " + str(cd.pop()))
    cd.append(cd.pop())

print(cd[0])