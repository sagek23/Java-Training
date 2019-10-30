def getMax(a,b):
    r=a
    if b>r:
        r=b
    return r

max = getMax(10,3)
#print(max)

def getSum(n):
    sum = 0
    i = 1
    for i in range(n+1):
        sum+=i
    return sum

ssum = getSum(10)
print(ssum)