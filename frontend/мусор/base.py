from flask import Flask
from flask import render_template

UPLOAD_FOLDER = './static/uploads'

app = Flask(__name__)
app.config['UPLOAD_FOLDER'] = UPLOAD_FOLDER

@app.route('/table')
def auto_answer():
    return render_template('table.html')



if __name__ == '__main__':
    app.run(port=8080, host='127.0.0.1')