def getSumFact(n):
    sum, r = 0, 1
    for i in range(1, n+1):
        sum += i
        r*=i
    return sum, r

a, b = getSumFact(5)
#print(a)
#print(b)
c = getSumFact(5) #받는 변수를 하나로 하면 tuple로 반환
#print(c)


def getMaxMinTotAvg(n):
    max = n[0]
    min = n[0]
    sum = 0
    avg= 0
    for i in range(len(n)):
        sum +=n[i]
        avg = sum/len(n)
        if n[i] > max:
            max = n[i]
        elif n[i] < min:
            min = n[i]
    return max, min, sum, avg

n = [1, 3, 5, 7]
d = getMaxMinTotAvg(n)
print(d)
