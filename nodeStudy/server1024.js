var http = require("http");
var express = require("express");
var app = express();
app.use(express.static("public"))
app.use(express.bodyParser())
app.use(app.router)

const url = 'mongodb://localhost:27017';
const dbName = 'bit';
const MongoClient = require('mongodb').MongoClient;

var ObjectID = require('mongodb').ObjectID

app.all("/blogDelete", function(req, res){

  var q = {_id:new ObjectID(req.param("id"))}
  var id = req.param("id");
  const MongoClient = require('mongodb').MongoClient;
  const assert = require('assert');

  // Connection URL
  const url = 'mongodb://localhost:27017';

  // Database Name
  const dbName = 'bit';

  // Create a new MongoClient
  const client = new MongoClient(url);

  // Use connect method to connect to the Server
  client.connect(function(err, client) {
    assert.equal(null, err);
    console.log("Connected correctly to server");
    const db = client.db(dbName);
    const col = db.collection('articles');
        // Remove a single document
        col.deleteOne(q, function(err, r) {
            res.send("1");
        });
    });
      
});

app.post("/blogUpdate", function(req, res){
  var title = req.param("title");
  var content = req.param("content");
  var doc = {title:title, content:content} //객체생성
  var q = {_id:new ObjectID(req.param("id"))}
  var id = req.param("id");
  console.log(id)

  const MongoClient = require('mongodb').MongoClient;
  const assert = require('assert');

  // Connection URL
  const url = 'mongodb://localhost:27017';

  // Database Name
  const dbName = 'bit';

  // Create a new MongoClient
  const client = new MongoClient(url);

  // Use connect method to connect to the Server
  client.connect(function(err, client) {
    assert.equal(null, err);
    console.log("Connected correctly to server");

    const db = client.db(dbName);

    const col = db.collection('articles');
    
      // Modify and return the modified document
      col.findOneAndUpdate(q, {$set:doc}, {
          returnOriginal: false
        , upsert: true
      }, function(err, r) {
        res.send("1");
      });
    });
});

app.post("/comment", function(req, res){
    var name = req.param("commentor_name");
    var commentor_email = req.param("commentor_email");
    var comment = req.param("comment");
    var id = req.param("id");
    //console.log("코멘트 id확인"+id);
    var posted_at = new Date();
    var doc = {comment:{name:name, commentor_email:commentor_email, comment:comment, posted_at:posted_at}}
    var doc2 = {"$push":doc}
    var q = {_id:new ObjectID(id)} //where절에 넣을 조건


    const MongoClient = require('mongodb').MongoClient;
    const assert = require('assert');

    // Connection URL
    const url = 'mongodb://localhost:27017';

    // Database Name
    const dbName = 'bit';

    // Create a new MongoClient
    const client = new MongoClient(url);

    // Use connect method to connect to the Server
    client.connect(function(err, client) {
      assert.equal(null, err);
      console.log("Connected correctly to server");

      const db = client.db(dbName);

      const col = db.collection('articles');
      
        // Modify and return the modified document
        col.findOneAndUpdate(q, doc2, {
            returnOriginal: false
          , upsert: true
        }, function(err, r) {
          res.send(doc.comment);
        });
      });
});


app.all("/blogDetail", function(req, res){
    var id = new ObjectID(req.param("id")) //id는 ObjectID로 만들어야함

    const MongoClient = require('mongodb').MongoClient;
    const assert = require('assert');

    // Connection URL
    const url = 'mongodb://localhost:27017';

    // Database Name
    const dbName = 'bit';

    // Create a new MongoClient
    const client = new MongoClient(url);
    
    var q = {_id:id}

    // Use connect method to connect to the Server
    client.connect(function(err, client) {
    assert.equal(null, err);
    console.log("Connected correctly to server");

    const db = client.db(dbName);

    const col = db.collection('articles');

        // Get first two documents that match the query
        col.find(q).toArray(function(err, docs) {
        client.close();
        res.send(docs[0]);
        });
    });
});

app.all("/blogList", function(req, res){
    const MongoClient = require('mongodb').MongoClient;
    const assert = require('assert');

    // Connection URL
    const url = 'mongodb://localhost:27017';

    // Database Name
    const dbName = 'bit';

    // Create a new MongoClient
    const client = new MongoClient(url);

    // Use connect method to connect to the Server
    client.connect(function(err, client) {
    assert.equal(null, err);
    console.log("Connected correctly to server");

    const db = client.db(dbName);

    const col = db.collection('articles');

        // Get first two documents that match the query
        col.find({}).toArray(function(err, docs) {
        client.close();
        res.send(docs);
        });
    });
});

app.post("/blogInsert", function(req, res){
    var title = req.param("title");
    var content = req.param("content");
    var saved_at = new Date();
    var doc = {title:title, content:content, saved_at:saved_at} //객체생성

    const MongoClient = require('mongodb').MongoClient;
    const assert = require('assert');

    // Connection URL
    const url = 'mongodb://localhost:27017';

    // Database Name
    const dbName = 'bit';

    // Create a new MongoClient
    const client = new MongoClient(url);

    // Use connect method to connect to the Server
    client.connect(function(err, client) {
    assert.equal(null, err);
    console.log("Connected correctly to server");

    const db = client.db(dbName);

    // Insert a single document
    db.collection('articles').insertOne(doc, function(err, r) {
        assert.equal(null, err);
        assert.equal(1, r.insertedCount);
        client.close();
        var str = "<p>Article saved. <a href='blogInsert.html'>Write another one?</a></p>";
        res.send(str);
    });
  });
});




http.createServer(app).listen(52273, function(){
    console.log("서버가 가동되었습니다.");
});

