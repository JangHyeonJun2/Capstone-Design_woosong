# Capstone-Design_woosong

## 스마트 주차장 챗봇 그리고 자율주행 

__현재 진행률__   **100%**

### 진행흐름

- 현재 작성한 Flask 서버와 카카오톡 서버간에 데이터를 주고 받는다. Flask 서버에 사용자가 원하는 조건에 대한 응답을 지정해놓고카카오톡 플러스 친구로 다른 이용자가 보내는 문장을 카카오톡 서버에서 Flask로 json 타입으로 전송해준다.    

- 이 json 타입의 데이터를 Flask 서버가 받고 , 그 중 content 즉 플러스 친구로 받은 문장 또는 단어에 대하여 조건에 맞는 응답을 다시 카카오톡 서버로 보내주고 플러스 친구에 보여주게 된다. 

![사진1](https://user-images.githubusercontent.com/38535971/69373121-77320680-0ce6-11ea-820b-2f493275f4c1.PNG)



### 스마트 주차장 챗봇 소스코드

```python
from flask import Flask, request, jsonify
import sys
app = Flask(__name__)

@app.route('/keyboard')
def Keyboard():
    dataSend = {
    }
    return jsonify(dataSend)

@app.route('/message', methods=['POST'])
def Message():
    content = request.get_json()
    content = content['userRequest']
    content = content['utterance']
    if content == u"안녕":
        dataSend = {
            "version": "2.0",
            "template": {
                "outputs": [
                    {
                        "carousel": {
                            "type" : "basicCard",
                            "items": [
                                {
                                    "title" : "",
                                    "description" : "안녕"
                                }
                            ]
                        }
                    }
                ]
            }
        }
    else :
        dataSend = {
            "version": "2.0",
            "template": {
                "outputs": [
                    {
                        "simpleText":{
                            "text" : "아직 공부하고있습니다."
                        }
                    }
                ]
            }
        }
    return jsonify(dataSend)

if __name__ == "__main__":
    app.run(host='0.0.0.0')
```

### 카카오톡 챗봇 서버를 돌릴 웹 서버 구축

###### 설치가 필요없는 통합개발 툴 구름IDE

![사진2](https://user-images.githubusercontent.com/38535971/69373294-d7c14380-0ce6-11ea-9f67-379e9435eec6.PNG)

**IP마다 서버 포트 주소가 달라지기 때문에  집,학교,멘토받는 회사 이렇게 3개의 컨테이너를 만들었다.**

#### 카카오톡 챗봇 설정

**_스킬 설정_**

![사진3](https://user-images.githubusercontent.com/38535971/69373303-da239d80-0ce6-11ea-8dcb-f13adf4d4005.PNG)

**_시나리오 설정_**

![사진4](https://user-images.githubusercontent.com/38535971/69373308-dbed6100-0ce6-11ea-8cb1-f1159b2dc503.PNG)
-------------------------
# 클라우드 Mysql과 이클립스 외부연결

**프로그램 데이터 저장 실행 흐름**

### 아두이노 -> 이클립스  ->클라우드 Mysql -> 카카오토 챗봇

- 여기서 이클립스와 클라우드 Mysql를 서로 연결하기 위해서는 외부 연결 **포트포워딩**을 따로 해줘야 이클립스에서 클라우드 MySQL로 접속이 가능하다.

![사진5](https://user-images.githubusercontent.com/38535971/69373311-ddb72480-0ce6-11ea-84ca-d20dc64c86c6.PNG)

- 등록을 누르고 외부포트 , ip주소를 이클립스 db접속할 때 코드에 localhost와 port번호에 넣어주면 접속이 가능하다. 예)this.dbUrl = "jdbc:mysql://13.209.77.137:57674/arduino?serverTimezone=Asia/Seoul&useSSL=false";
    	this.dbId = "root";
    	this.password = "1234";
-------------------------
