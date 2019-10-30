from pymongo import MongoClient
from bson.json_util import dumps
import pprint

client = MongoClient('localhost', 27017)

db = client.bit
students = db.student

#for collection in collection.find({}, {"_id":0}):
#    pprint.pprint(collection)
arr = students.find({"kor":{"$gte":90}}, {"kor":1, "name":1, "_id":0})
r= dumps(arr,ensure_ascii=False)
print(r)
#for student in students.find({"kor":{"$gte":90}}, {"kor":1, "name":1, "_id":0}):
#   print(student)