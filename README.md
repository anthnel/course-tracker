# course-tracker

ce qui est fait :

* backend ELK fonctionnel via docker-compose
* otel collector fonctionnel via docker-compose
* configuration de logback pour envoyer les logs vers opentelemetry
* configuration de l'application pour utiliser le opentelemetry sdk


todo :

* voir pour configurer automatiquement le server fleet output pour attaquer le bon endpoint et préciser le ca.crt
  * actuellement fait manuellement dans Management > Feet > Settings > Outputs
    * hosts : https://es01:9200
    * advanced yaml configuration
        ```yaml
        ssl:
          certificate_authorities : ["/certs/ca/ca.crt"]
        ```
* voir pourquoi le champ service.name n'est pas enrichi
* configurer l'auto instrumentalisation avec spring-boot
* tester les traces et les métriques
