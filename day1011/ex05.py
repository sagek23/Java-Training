import re
import requests

#url = 'http://www.bcl.go.kr/site/program/libraryuse/readingroom?menuid=019006010&libraryset=4'
url = 'http://210.104.108.108/libseat/Seat_Info/1_readingroom.asp'
text = requests.get(url).text
emptySeat =  re.findall('<span.+?#FFFE91;.+?<font size ="2">(.+?)</td>',text)

print(emptySeat)
print(len(emptySeat))