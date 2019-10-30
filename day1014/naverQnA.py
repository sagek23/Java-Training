from builtins import print

import requests
import re

for i in range(1, 100):
    url = 'https://kin.naver.com/qna/kinupList.nhn?queryTime=2019-10-14%2009%3A32%3A01&page='
    url = url + str(i)

    text = requests.get(url).text

    title = re.findall('<a href="/qna/detail.nhn.+?>(.+?)</a>', text, re.DOTALL)
    fname = '../data/qna/qna' + str(i) + '.txt'
    file = open(fname, 'w', encoding='utf-8')
    for line in title:  # 배열에 있는 것을 str으로 하나씩 꺼내서 출력'
       file.write(line)
       file.write('\n')
    file.close()
    print(str(i)+"번째 페이지 수집")



print('리스트 파일 작성 완료')
