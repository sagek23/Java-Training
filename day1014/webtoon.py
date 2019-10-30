from builtins import print

import requests
import re
urln = 'https://comic.naver.com/webtoon/weekday.nhn'
text = requests.get(urln).text
imgF = re.findall('<img onerror="this.src=.+?src="(.+?)"', text, re.DOTALL)
#imgId = re.findall('<img onerror="this.src=.+?/webtoon/(.+?)/thumbnail/',text, re.DOTALL)
fname = re.findall('<img onerror="this.src=.+?title="(.+?)"',text, re.DOTALL)
for i in range(len(imgF)):
    url = imgF[i]
    finame = fname[i].strip()
    finame = finame.replace(",","_")
    finame = finame.replace("?", "_")
    f = open('../data/webtoon/'+finame+'.jpg','wb')
    f.write(requests.get(url).content)
    f.close()
    print(url)
print('이미지 다운 완료')