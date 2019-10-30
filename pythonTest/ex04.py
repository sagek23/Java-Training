import re
import requests
url = 'http://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=108'
text = requests.get(url).text
seoul = re.findall('<city>서울</city>(.+?)</location>', text, re.DOTALL)
#re.DOTALL  정보가 여러줄에 걸쳐서 있을 때 사용
#print(seoul)
#print(type(seoul[0]))
sweather= re.findall('<tmEf>(.+?)</tmEf>.+?<tmn>(.+?)</tmn>.+?<tmx>(.+?)</tmx>',seoul[0],re.DOTALL)
print(type(sweather[0]))