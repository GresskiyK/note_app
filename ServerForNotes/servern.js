const express = require("express");
const app = express();
var data="";
var check=0;
const bodyParser=require("body-parser");
const urlencodedParser=bodyParser.urlencoded({extended:false});
app.use(bodyParser.urlencoded({
    extended: true
}));
app.use(bodyParser.json());

const mongoose=require("mongoose");
mongoose.connect("mongodb://localhost:27017/notebase",{ useNewUrlParser:true});
const Schema = mongoose.Schema;
const userScheme=new Schema({
    name:String,
    password:String,
    passwordCheck:String,
    email:String
},{ versionKey: '' });
const User = mongoose.model("User",userScheme);

const noteScheme=new Schema({
    title:String,
    body:String,
    colorId:Number,
    email:String
},{ versionKey: '' });
const Note = mongoose.model("Note",noteScheme);


const MongoClient = require("mongodb").MongoClient; 
const url = "mongodb://localhost:27017/"; 
const mongoClient = new MongoClient(url); 



//Adding user
app.post("/addUser",function(request,response){
    
    mongoose.connection.collection['users']
    const user=new User({
    name:request.body.login.toString(),
    password:request.body.password.toString(),
    passwordCheck:request.body.passwordCheck.toString(),
    email:request.body.email.toString()});

    user.save(function(err){
        mongoose.disconnect();
        if(err) return console.log(err);
        response.send("Done");
    
    }); 

});

//Auth user
app.post("/userAuth",function(request,response){
    
    mongoClient.connect((err, client)=>{ 

        const db = client.db("notebase"); 
        const collection = db.collection("users"); 
        
        collection.find({password:request.body.password}).toArray (function(err, result){
    
        if(err){ 
        return console.log(err); 
        } 
        response.send("Done"); 
        client.close();
        });
    });
    

});


app.post("/notes", function(request,response){
    mongoClient.connect((err, client)=>{ 

        const db = client.db("notebase"); 
        const collection = db.collection("notes"); 
        
        collection.find({email:request.body.email}).toArray (function(err, result){
    
        if(err){ 
        return console.log(err); 
        } 
        console.log(request.body);
        response.send(result); 
        client.close();
        }); 
    });
    // mongoose.connection.collection['notes']
    // Note = mongoose.model("Note", noteScheme);
 
    // Note.find({email:request.body.email}, function(err, docs){
    
     
    // if(err) return console.log(err);
    // mongoose.disconnect();
    // response.send(docs);
    
   // });
        
});



//Adding note
app.post("/addNote",function(request,response){
 
    mongoose.connection.collection['notes']
    const note=new Note({
    title:request.body.title.toString(),
    body:request.body.body.toString(),
    email:request.body.email.toString()});

    note.save(function(err){
        mongoose.disconnect();
        if(err) return console.log(err);
        console.log("Сохранен обьект",note);
        response.send("Hello");
    });
});

app.get("/", function(request, response){
     
    response.send("Welcome!");
});

app.listen(5000, ()=>console.log("Сервер исправен"));