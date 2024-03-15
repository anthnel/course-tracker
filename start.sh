OTEL_SERVICE_NAME=course-tracker \
# OTEL_TRACES_EXPORTER=otlp \
# OTEL_METRICS_EXPORTER=otlp \
# OTEL_LOGS_EXPORTER=otlp \
OTEL_METRIC_EXPORT_INTERVAL=15000 \
OTEL_EXPORTER_OTLP_ENDPOINT=http://localhost:4318
java -jar target/course-tracker-app-jar-1.0.0.jar
#-javaagent:opentelemetry-javaagent.jar \
