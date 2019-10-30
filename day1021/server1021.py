from flask import Flask, render_template, request
import matplotlib.pyplot as plt
from matplotlib import font_manager, rc, colors, cm
import bitUtil.stdt
app = Flask(__name__)

@app.route("/")
def index():
    return "<h1>hello Flask</h1>"

@app.route("/listStudent")
def listStudent():
    #arr = ["유관순", "홍길동","강감찬","이순신"]
    arr = bitUtil.stdt.listStudent()
    return render_template("listStudent.html",arr=arr)

@app.route("/search/<name>")
def searchStudentGet(name):
    arr = bitUtil.stdt.searchStudent(name)
    return render_template("searchStudent.html", arr=arr)

@app.route("/search", methods=['POST'])
def searchStudentPost():
    name = request.form['name']
    arr = bitUtil.stdt.searchStudent(name)
    return render_template("searchStudent.html", arr=arr)

@app.route("/delete", methods=['POST'])
def deleteStudent():
    name = request.form['name']
    arr = bitUtil.stdt.deleteStudent(name)
    return render_template()

@app.route("/chart")
def makeChart():
    data = [10,20,30,40,50]
    plt.plot(data)
    # plt.show()
    plt.savefig('static/chart.png')
    plt.close()
    return render_template("chart.html", fname="chart.png")

if __name__=="__main__":
    app.run()