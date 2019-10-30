package com.bit.mongoDB.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.mongoDB.vo.Student;
import com.mongodb.*;
import com.mongodb.client.MongoClients;
//import com.mongodb.clientMongoClient;
//import com.mongodb.MongoClient;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Indexes;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.*;
import org.bson.Document;
import org.bson.types.ObjectId;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

@Controller
public class IndexController {
	
	String r  = null;
	@ResponseBody
	@RequestMapping("/searchStudent")
	public String searchStudent()
	{
		Block<Document> printBlock = new Block<Document>() {
		       @Override
		       public void apply(final Document document) {
		           r+= document.toJson()+",";
		       }
		};
		MongoClient mongoClient = MongoClients.create();
		MongoDatabase database = mongoClient.getDatabase("bit");
		MongoCollection<Document> collection = database.getCollection("student");
		collection.createIndex(Indexes.text("name"));
		return r;
	}
	
	@ResponseBody
	@RequestMapping("/listStudent")
	public String listStudent()
	{
		r = "[";
		Block<Document> printBlock = new Block<Document>() {
		       @Override
		       public void apply(final Document document) {
		           r+= document.toJson()+",";
		       }
		};
		
		MongoClient mongoClient = MongoClients.create();
		MongoDatabase database = mongoClient.getDatabase("bit");
		MongoCollection<Document> collection = database.getCollection("student");
		collection.find().forEach(printBlock);
		r = r.substring(0, r.length()-1);
		r+="]";
		
		return r;
	}
	
	@ResponseBody
	@RequestMapping("/insertStudent")
	public String insertStudent(Student s)
	{
		String r = null;
		
		MongoClient mongoClient = MongoClients.create();
		MongoDatabase database = mongoClient.getDatabase("bit");
		MongoCollection<Document> collection = database.getCollection("student");
		
		Document document = new Document();		
		document.append("name", s.getName());
		document.append("kor", s.getKor());
		document.append("eng", s.getEng());
		document.append("math",s.getMath());
		
		collection.insertOne(document);
		r=document.toJson();
		return r;
	}
	@RequestMapping("/index.do")
	public void index()
	{
		
	}
}
