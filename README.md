# Course Tracker

Application Web de démo qui utilise spring boot.

Cette application est utilisée pour démontrer les fonctionnalités de la plateforme DevSecOps mais aussi comme test pour la mise en place d'un environnement de développement.

## avancement

- [x] backend ELK fonctionnel via docker-compose
- [x] otel collector fonctionnel via docker-compose
- [x] configuration de logback pour envoyer les logs vers opentelemetry
- [x] configuration de l'application pour utiliser le opentelemetry sdk
- [ ] voir pour configurer automatiquement le server fleet output pour attaquer le bon endpoint et préciser le ca.crt
  * actuellement fait manuellement dans Management > Feet > Settings > Outputs
    * hosts : https://es01:9200
    * advanced yaml configuration
        ```yaml
        ssl:
          certificate_authorities : ["/certs/ca/ca.crt"]
        ```
- [x] champ service.name correctement alimenté 
- [x] configurer l'auto instrumentation avec spring-boot
- [x] instrumentation des traces distribuées
- [ ] instrumentation des métriques
- [x] remplacement de la db h2 par une db postgres

## Stack d'observabilité

La stack testée est celle d'ELK (Elastic Logstash Kibana).

Pour la démarrer :

```sh
docker compose -f docker/observability.yml up
```

