import requests

response = requests.get("") 

file = open("paqu","wb")

file.write(response.content) 

file.close()
