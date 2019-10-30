from pymongo import MongoClient
from bson.json_util import dumps
client = MongoClient('localhost', 27017)

db = client.bit
collection = db.student
s = {
    "name":"김만두",
    "kor":100,
    "eng": 100,
    "math": 100
}
collection.insert_one(s)

print(s)

