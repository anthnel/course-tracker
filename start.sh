# export JAVA_TOOL_OPTIONS="-javaagent:opentelemetry-javaagent.jar"
#export OTEL_TRACES_EXPORTER=none 
#export OTEL_METRICS_EXPORTER=logging
#export OTEL_LOGS_EXPORTER=logging
export OTEL_SERVICE_NAME="course-tracker"
export OTEL_EXPORTER_OTLP_ENDPOINT=http://localhost:4317
export OTEL_METRIC_EXPORT_INTERVAL=15000 
java -jar target/course-tracker-app-jar-1.0.0.jar



