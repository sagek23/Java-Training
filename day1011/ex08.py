import requests
import re

url = 'https://kin.naver.com/qna/list.nhn'

text = requests.get(url).text
#print(text)
title = re.findall('<a href="/qna/detail.nhn.+?>(.+?)</a>',text,re.DOTALL)

file = open('../data/qna.txt','w',encoding='utf-8')
for str in title: #배열에 있는 것을 str으로 하나씩 꺼내서 출력
    file.write(str)
    file.write('\n')
file.close()
print('리스트 파일 작성 완료')
