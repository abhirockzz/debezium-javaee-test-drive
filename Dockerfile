FROM airhacks/tomee
ENV WAR kafka-consumer.war
COPY target/${WAR} ${DEPLOYMENT_DIR}