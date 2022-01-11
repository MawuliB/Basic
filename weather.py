import requests
from pprint import pprint

API_KEY = "8156609d2e124a1d096b348de089a9eb"

city = input("Enter the City: ")

base_url = (
    "http://api.openweathermap.org/data/2.5/weather?appid=" + API_KEY + "&q=" + city
)

weather = requests.get(base_url).json()

pprint(weather)
