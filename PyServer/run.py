from flask import Flask, render_template

from flask import render_template

from jsonProcess import getMovie



app = Flask(__name__)

@app.route('/')
def home():
    return '홍석이의 던파 api 가져오기'

@app.route('/user/<1stchar>')
def user():
    return render_template('data.py')

if __name__ == '__main__':
    app.run('0.0.0.0', port=5000, debug=True)