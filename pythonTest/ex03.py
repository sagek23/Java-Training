import re
import requests

db = '''3412    Bob 123
    3834  Jonny 333
    1248   Kate 634
    1423   Tony 567
    2567  Peter 435
    3567  Alice 535
    1548  Kerry 534'''
str = '''<td>홍길동</td>
<td>이순신</td>
<td>유관순</td>
'''

temp = re.findall('Tony',db)
temp1 = re.findall('<td>(.+?)</td>',str) #정규표현식
temp2 = re.findall('[0-9]{4}',db)
#temp2 = re.findall('[0-9]...',db)
#temp2 = re.findall('[0-9]'*4,db)

temp3 = re.findall('[0-9]{3}([0-9])',db) #4자리번호 중 마지막번호 출력
temp4 = re.findall('[A-Za-z]+',db) #이름출력
temp5 = re.findall('([A-Z])[a-z]+',db) #이름 첫글자 출력
temp6 = re.findall('3[0-9].+?([A-Z][a-z]+).+?([0-9]{3})',db) #번호가 3으로 시작하는 사람들의 이름과 전화번호 출력

print(temp6)