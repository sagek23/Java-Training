import requests
import re
url = 'https://comic.naver.com/webtoon/weekday.nhn'
text = requests.get(url).text

list =re.findall('<div class="thumb">.+?<a href="/webtoon.+?this.src.+?src="(.+?)" width="83".+?title="(.+?)".+?<span class="mask"></span>',text,re.DOTALL)
# print(list[0])
# url2,title = list[0]
# print(url2)
# print(title)
# print(len(list))

for data in list:
    url2, title = data
    title = title.replace(",","_")
    title = title.replace("?", "_")
    fname = '../Webtoon/'+title + ".jpg"
    f = open(fname,'wb')
    f.write(requests.get(url2).content)
    f.close()
    print(title,'파일저장')

    # print(url2)
    # print(title)
print('모두완료')