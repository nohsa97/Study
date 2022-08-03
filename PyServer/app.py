import pymysql

conn= pymysql.connect(host='127.0.0.1',
                user='root',
                password='root',
                db='testdb',
                charset='utf8')

curs = conn.cursor()

sqlz = 'create DATABASE'

curs.execute(sqlz)

conn.commit()
conn.close()