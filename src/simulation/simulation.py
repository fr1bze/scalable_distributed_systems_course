from locust import HttpUser, task, between
from faker import Faker
import random

fake = Faker()

# Генерируем заранее 10 ключей и значений
keys = [fake.word() for _ in range(10)]  # 10 случайных ключей
values = [fake.word() for _ in range(10)]  # 10 случайных значений

class ApiLoadTest(HttpUser):
    wait_time = between(1, 5)

    @task
    def post_entity(self):
        key = fake.word()
        value = fake.text()

        payload = {
            "key": key,
            "value": value
        }

        self.client.post("http://localhost:9090/api", json=payload)
        print(f"POST request sent with key: {key} and value: {value}")

    @task
    def get_entity(self):
        key = random.choice(keys)

        self.client.get(f"http://localhost:9090/api/{key}")
        print(f"GET request sent for key: {key}")