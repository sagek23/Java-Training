'''
java의 collection Set, List, Map
python의 collection list, tuple, set, dictionary
                    []      ()   {}     {}
list는 값 변경 가능, tuple은 불가
set은 중복을 허용하지 않는다
'''

a = [1,3,5,7,3]
print(type(a))
print(a)
b = (1,3,5,7,3)
print(type(b))
print(b)
a[0] = 100
#b[0] = 100 tuple은 값 변경 불가
print(a[0])
print(b[0])
#c = {1,3,5,7,3}
#print(type(c))
#print(c)