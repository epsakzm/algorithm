import sys
x = int(sys.stdin.readline())
dp = [-1 for i in range(x+1)]
# dp = []
dp[1] = 0
dp[2] = 1
dp[3] = 1
dp[4] = 2
dp[5] = 3
dp[6] = 2

for i in range(7, x+1):
    dp[i] = dp[i-1] + 1
    if i % 2 == 0:
        dp[i] = min(dp[i//2] + 1, dp[i])
    if i % 3 == 0:
        dp[i] = min(dp[i//3] + 1, dp[i])

print(dp[x])