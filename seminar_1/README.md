# Семинар 1
## Способы распространения приложений

#### Запуск postgresql:14 в docker

```bash
docker run -it --rm postgres psql -h some-postgres -U postgres:14
```

#### Посмотреть список образов на машине
```bash
docker image ls
```

#### "Почистить" неиспользуемые образы
```bash
docker image prune
```

#### Получить образ из docker-registry
```bash
docker pull openjdk:21-oracle
```

#### Посмотреть работающие контейнеры
```bash
docker ps -a
```

#### Посмотреть виртуальные диски
```bash
docker volume ls
```

#### Посмотреть виртуальные сети
```bash
docker network ls
```

...