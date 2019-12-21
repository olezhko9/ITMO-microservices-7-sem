FROM bitnami/rabbitmq:latest
ENV RABBITMQ_USER student
ENV RABBITMQ_PASSWORD hello
ADD init.sh /init.sh
EXPOSE 5672 15672
RUN chown rabbitmq:rabbitmq /init.sh
CMD ["sudo", "chmod", "777", "/init.sh"]
CMD ["sudo", "/init.sh"]