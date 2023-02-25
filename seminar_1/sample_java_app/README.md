# Пример минимального java-приложения в docker
Приложение - веб-сервер, запускающийся на 8080 порту и отвечающий на `/hello`.

### Сборка
```bash
./gradlew gradle clean build
```

### Запуск
```bash
java -jar build/libs/sample-1.0.0.jar
```

### То же самое с докером
1. Собираем джарник
2. Собираем образ `docker build -t sample-java .`
3. Запускаем `docker run -p 8080:8080 sample-java`
