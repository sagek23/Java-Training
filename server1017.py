from flask import Flask, render_template, request
import bitUtil.stu
app = Flask(__name__)

@app.route("/grade", methods=['GET'])
def insertForm():
    return render_template("enterGrade.html")
@app.route("/grade", methods=['POST'])
def enterStudent():
    name  = request.form['name']
    kor = int(request.form['kor'])
    eng = int(request.form['eng'])
    math = int(request.form['math'])
    doc = {"name": name, "kor": kor, "eng": eng, "math": math}
    bitUtil.stu.setStudent(doc)

    return render_template("enterGrade.html")

@app.route("/info", methods=['POST'])
def searchStudentPost():
    name = request.form['name']
    s = bitUtil.stu.getStudent(name)
    return render_template("student.html", s=s)

@app.route("/info/<name>") #get방식
def infoStudent(name):
    s = bitUtil.stu.getStudent(name)
    print(s)
    return render_template("student.html", s=s)



@app.route('/hello/<name>')
def hello(name):
    return render_template('hello.html', name=name)

@app.route("/listStudent")
def listStudent():
    return bitUtil.stu.listStudent()

@app.route("/")
def index():
    return "hello"

if __name__=="__main__":
    app.run()