import requests

#s = input()

headers = {
		"User-Agent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.122 Safari/537.36"
}


response = requests.get("https://",headers = headers) 


#response = requests.get(s,headers = headers) 

file = open("temp","wb")

file.write(response.content) 

file.close()
