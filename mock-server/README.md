# user-service-mock

Mock server Spring Boot 3 généré à partir de `user-service.yaml` (Alumni Platform - User Service API).

Il implémente toutes les routes du contrat OpenAPI (`/users`, `/users/{userId}`, `/users/me`)
avec un stockage en mémoire (2 utilisateurs pré-chargés : Alice et Bob, comme dans les exemples du spec).

## Lancer en local

```bash
mvn spring-boot:run
```

L'API écoute sur `http://localhost:8080`.

## Construire le jar

```bash
mvn clean package
java -jar target/user-service-mock.jar
```

## Construire et lancer avec Docker

```bash
docker build -t user-service-mock .
docker run -p 8080:8080 user-service-mock
```

## Déploiement (Render.com — gratuit)

1. Pousser ce dossier sur un repo GitHub (ex: `user-service-mock`).
2. Sur https://render.com → **New +** → **Web Service**.
3. Connecter le repo GitHub.
4. Render détecte le `Dockerfile` automatiquement → laisser **Environment: Docker**.
5. Plan **Free**, région au choix.
6. Déployer. Render fournit une URL du type `https://user-service-mock.onrender.com`.

⚠️ Sur le plan gratuit, le service se met en veille après inactivité et redémarre
(30–60s) au premier appel suivant — normal pour une démo de TP.

## Alternative rapide : Railway.app ou Fly.io
Mêmes étapes : repo GitHub → détection du Dockerfile → déploiement.
