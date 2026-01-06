# TP-25 : Conteneurisation des Microservices avec Docker et Consul

## 📋 Description

Ce projet démontre la **conteneurisation** d'une architecture microservices complète avec **Docker**, **Docker Compose** et **HashiCorp Consul** pour la découverte de services.

## 🏗️ Architecture

```
┌─────────────────────────────────────────────────────────────┐
│                     Docker Compose                           │
├─────────────────────────────────────────────────────────────┤
│  ┌─────────────────────────────────────────────────────────┐│
│  │                  Consul Server                          ││
│  │                   (Port 8500)                           ││
│  │            Service Discovery + Config                   ││
│  └─────────────────────────────────────────────────────────┘│
│                            │                                 │
│       ┌────────────────────┼────────────────────┐           │
│       │                    │                    │           │
│  ┌────┴────┐          ┌────┴────┐          ┌────┴────┐     │
│  │ Gateway │          │ Client  │          │ Voiture │     │
│  │ Service │          │ Service │          │ Service │     │
│  │  :8888  │          │  :8081  │          │  :8082  │     │
│  └─────────┘          └─────────┘          └─────────┘     │
└─────────────────────────────────────────────────────────────┘
```

## 🛠️ Technologies Utilisées

| Technologie | Description |
|-------------|-------------|
| Java 17+ | Langage de programmation |
| Spring Boot 3.x | Framework applicatif |
| Spring Cloud Consul | Intégration Consul |
| Docker | Conteneurisation |
| Docker Compose | Orchestration |
| HashiCorp Consul | Service Discovery |

## 📁 Structure du Projet

```
TP-25-Ilyas/
├── docker-compose.yml      # Orchestration complète
├── projet-ms/
│   ├── gateway-service/    # API Gateway
│   │   ├── Dockerfile
│   │   └── src/
│   ├── client-service/     # Service Client
│   │   ├── Dockerfile
│   │   └── src/
│   └── voiture-service/    # Service Voiture
│       ├── Dockerfile
│       └── src/
└── images/
```

## 🐳 docker-compose.yml

```yaml
version: '3.8'

services:
  consul:
    image: consul:latest
    ports:
      - "8500:8500"
      - "8600:8600/udp"
    command: agent -dev -ui -client=0.0.0.0

  gateway-service:
    build: ./projet-ms/gateway-service
    ports:
      - "8888:8888"
    depends_on:
      - consul
    environment:
      - SPRING_CLOUD_CONSUL_HOST=consul

  client-service:
    build: ./projet-ms/client-service
    ports:
      - "8081:8081"
    depends_on:
      - consul
    environment:
      - SPRING_CLOUD_CONSUL_HOST=consul

  voiture-service:
    build: ./projet-ms/voiture-service
    ports:
      - "8082:8082"
    depends_on:
      - consul
    environment:
      - SPRING_CLOUD_CONSUL_HOST=consul
```

## 🔧 Dockerfile (exemple)

```dockerfile
FROM maven:3.8-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]
```

## 🚀 Démarrage

### Tout en une commande

```bash
docker-compose up --build
```

### Commandes utiles

```bash
# Démarrage en arrière-plan
docker-compose up -d --build

# Voir les logs
docker-compose logs -f

# Arrêter les services
docker-compose down

# Supprimer les volumes
docker-compose down -v
```

## 🌐 Points d'Accès

| Service | URL |
|---------|-----|
| Consul UI | http://localhost:8500 |
| Gateway | http://localhost:8888 |
| Client Service | http://localhost:8081 |
| Voiture Service | http://localhost:8082 |

## 📡 API via Gateway

```bash
# Clients
GET http://localhost:8888/client-service/clients
POST http://localhost:8888/client-service/clients

# Voitures
GET http://localhost:8888/voiture-service/voitures
POST http://localhost:8888/voiture-service/voitures
```

## ✨ Fonctionnalités

- ✅ Conteneurisation de tous les services
- ✅ Service Discovery avec Consul
- ✅ Networking Docker
- ✅ Health Checks automatiques
- ✅ Configuration centralisée

## 📊 Monitoring avec Consul

La console Consul (http://localhost:8500) permet de :
- Visualiser tous les services enregistrés
- Vérifier l'état de santé de chaque service
- Voir les instances actives
- Gérer la configuration distribuée

## 👨‍💻 Auteur

**Ilyas MICHICH**

---
*Travail Pratique - Conteneurisation Microservices avec Docker et Consul*
