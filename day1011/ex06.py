import requests
import re

url = 'http://susaek.sen.es.kr/dggb/module/mlsv/selectMlsvDetailPopup.do?mlsvId=1222957'
text = requests.get(url).text

lunch = re.findall('<th scope="row">식단</th>.+?<td class="ta_l">(.+?)</td>',text,re.DOTALL)
lunch = lunch[0].strip()
#print(lunch)

f = open('../data/todayMenu.txt','w',encoding='utf-8')
f.write(lunch)
f.close()
print('수색초등학교 오늘의 메뉴 수집완료')
