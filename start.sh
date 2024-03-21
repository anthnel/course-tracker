JAVA_TOOL_OPTIONS=-javaagent:BOOT-INF/lib/opentelemetry-javaagent-2.2.0.jar
#export OTEL_TRACES_EXPORTER=none 
export OTEL_METRICS_EXPORTER=none
# export OTEL_LOGS_EXPORTER=logging
#export OTEL_SERVICE_NAME="course-tracker"
export OTEL_EXPORTER_OTLP_ENDPOINT=http://localhost:4317
export OTEL_METRIC_EXPORT_INTERVAL=15000 
export OTEL_PROPAGATORS="tracecontext"
# export OTEL_RESOURCE_ATTRIBUTES="environment=dev"
java -jar target/course-tracker-app-jar-1.0.0.jar



