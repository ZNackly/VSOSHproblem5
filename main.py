inf = 10_000000
times = [[0] * 3 for _ in range(4)]


route = [
   [],
   [[1], [0, 3, 2]],
   [[1, 2], [0, 3]],
   [[0], [1, 2, 3]]
]


def calc_route(v):
   tm = 0
   for ind in v:
       r, g, w = times[ind][0], times[ind][1], times[ind][2]
       if w > g:
           return inf
       tmp = tm % (r + g)
       if tmp < r:
           tm += r - tmp
           tmp = r
       if w > r + g - tmp:
           tm += -tmp + r + g + r + w
       else:
           tm += w
   return tm




ang = int(input())
if ang == 12:
   print("0")
   exit()
if ang == 23:
   ang = 1
if ang == 34:
   ang = 2
if ang == 41:
   ang = 3


for i in range(4):
   times[i] = list(map(int, input().split()))


ans = inf
for v in route[ang]:
   ans = min(ans, calc_route(v))


print(ans)

