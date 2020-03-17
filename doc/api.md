# RESTful APIs


**简介**:RESTful APIs


**HOST**:127.0.0.1:8080


**联系人**:fishkq@aliyun.com


**Version**:1.0


**接口路径**:/v2/api-docs


[TOC]






# account-controller


## 创建用户


**接口地址**:`/account/create`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|author||query|false|string||
|authorUrl||query|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|body||object||
|code||integer(int32)|integer(int32)|
|message||string||


**响应示例**:
```javascript
{
	"body": {},
	"code": 0,
	"message": ""
}
```


## 编辑用户


**接口地址**:`/account/edit`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|access|access|header|true|string||
|author||query|false|string||
|authorUrl||query|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|body||object||
|code||integer(int32)|integer(int32)|
|message||string||


**响应示例**:
```javascript
{
	"body": {},
	"code": 0,
	"message": ""
}
```


# resource-controller


## 删除文件


**接口地址**:`/resource/delete`


**请求方式**:`DELETE`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|access|access|header|true|string||
|fileId|fileId|query|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result|
|204|No Content||
|401|Unauthorized||
|403|Forbidden||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|body||object||
|code||integer(int32)|integer(int32)|
|message||string||


**响应示例**:
```javascript
{
	"body": {},
	"code": 0,
	"message": ""
}
```


## 获取文件


**接口地址**:`/resource/get/{fileId}`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|fileId|fileId|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


暂无


**响应示例**:
```javascript

```


## 预览文件


**接口地址**:`/resource/preview`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|fileId|fileId|query|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


暂无


**响应示例**:
```javascript

```


## 上传文件


**接口地址**:`/resource/put`


**请求方式**:`PUT`


**请求数据类型**:`multipart/form-data`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|access|access|header|true|string||
|file|file|formData|true|file||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|body||object||
|code||integer(int32)|integer(int32)|
|message||string||


**响应示例**:
```javascript
{
	"body": {},
	"code": 0,
	"message": ""
}
```