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


app.all("/update", function(req,res){

    console.log("upddate call");
    try{
        var name = req.param("name");
        var kor = Number(req.param("kor"));
        var eng = Number(req.param("eng"));
        var math = Number(req.param("math"));
        
        var doc = {name:name, kor:kor, eng:eng, math:math};      
        var _id = new ObjectID(req.param("_id"))
        var q = {_id:_id}

    }catch(e)
    {
        console.log(e);
    }

    console.log(doc);
    const assert = require('assert');
    const client = new MongoClient(url);

    // Use connect method to connect to the Server
    client.connect(function(err, client) {
    assert.equal(null, err);
    console.log("Connected correctly to server");

    const db = client.db(dbName);
    const col = db.collection('student');
    
        // Modify and return the modified document
        col.findOneAndUpdate(q, {$set: doc}, {
            returnOriginal: false
        , upsert: true
        }, function(err, r) {
        assert.equal(null, err);        
        res.send(doc);
        });
    });
});


app.all("/delete", function(req,res){
    try{
        var _id = new ObjectID(req.param("_id"))
        var q = {_id:_id}
    }catch(e){
        console.log(e);
    }
    const assert = require('assert');
    const client = new MongoClient(url);
    client.connect(function(err, client) {
    assert.equal(null, err);
    const db = client.db(dbName);

    const col = db.collection('student');    
        col.findOneAndDelete(q, {            
        }
        , function(err, r) {
            assert.equal(null, err);
            assert.ok(r.value.b == null);
            client.close();
            res.send(q);
        });
    });
});


app.all("/list", function(req,res){   
    const assert = require('assert');
    const client = new MongoClient(url);    

    // Use connect method to connect to the Server
    client.connect(function(err, client) {
        assert.equal(null, err);
        console.log("Connected correctly to server");

        const db = client.db(dbName);
        const col = db.collection('student');        
            // Get first two documents that match the query
            col.find().toArray(function(err, docs) {                   
            client.close();
            res.send(docs);
            });
        });
});


app.all("/insert",function(req,res){
    try{
        var name = req.param("name");
        var kor = Number(req.param("kor"));
        var eng = Number(req.param("eng"));
        var math = Number(req.param("math"));
        
        var doc = {name:name, kor:kor, eng:eng, math:math};        
        const assert = require('assert');
        const client = new MongoClient(url);

        // Use connect method to connect to the Server
        client.connect(function(err, client) {
        assert.equal(null, err);
        console.log("Connected correctly to server");

        const db = client.db(dbName);

        // Insert a single document
        db.collection('student').insertOne(doc, function(err, r) {
            assert.equal(null, err);
            assert.equal(1, r.insertedCount);
            client.close();

            res.send(doc);
        });
        });

    }catch(e)
    {
        console.log(e);
    }
});


http.createServer(app).listen(52273, function(){
    console.log("서버가 가동되었습니다.");
});

