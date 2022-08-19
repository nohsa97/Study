from unicodedata import name
from fastapi import FastAPI
from typing import Optional
from fastapi.responses import FileResponse
from pydantic import BaseModel


#인스턴스 생성
app = FastAPI()

fake_items_db = [{"item_name": "Foo"}, {"item_name": "Bar"}, {"item_name": "Baz"}]


class user(BaseModel):
    name : str
    id : str

@app.get("/")
def root():
    return FileResponse('index.html')

@app.get("/item/{item_id}")
async def root(item_id: int):
    return {"message": item_id}

@app.get("/data")
def ros():
    sts = "sss"
    return  sts

@app.get("/data/")
def data(in1:str,in2: Optional[str] = None):
    if in2 :
        return in1+in2
    else :
        return "in2가 없어요"+in1

@app.post("/send")
def ross(data:user):
    data.update("asd")
    print(data)
    return "전송완료"

@app.get("/items/")
async def read_item(skip: int, limit: int):
    return fake_items_db[skip : skip+limit]