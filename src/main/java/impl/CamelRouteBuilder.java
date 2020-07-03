package impl;

import org.apache.camel.builder.RouteBuilder;


public class CamelRouteBuilder extends RouteBuilder {

    private RabbitMQConfig rabbitMQConfig;

    private ActiveMQConfig activeMQConfig;

    public void setRabbitMQConfig(RabbitMQConfig rabbitMQConfig) {
        this.rabbitMQConfig = rabbitMQConfig;
    }

    public void setActiveMQConfig(ActiveMQConfig activeMQConfig) {
        this.activeMQConfig = activeMQConfig;
    }

    @Override
    public void configure() {
        receiveFromRabbitAndSendToActiveMQ();
    }


    private void receiveFromRabbitAndSendToActiveMQ() {
        String rabbitMqUri = getRabbitMqConsumerUri();
        String activeMqUri = getActiveMqProducerUri();
        from(rabbitMqUri).to(activeMqUri);
    }


    private String getRabbitMqConsumerUri() {
        String defaultParams =
                "autoAck=false" +
                        "&autoDelete=false" +
                        "&skipExchangeDeclare=true" +
                        "&skipQueueDeclare=true" +
                        "&durable=true";

        return "rabbitmq:exchangeName?" + defaultParams +
                "&hostname=" + rabbitMQConfig.hostname +
                "&portNumber=" + rabbitMQConfig.portNumber +
                "&username=" + rabbitMQConfig.username +
                "&password=" + rabbitMQConfig.password +
                "&queue=" + rabbitMQConfig.queue;

    }

    private String getActiveMqProducerUri() {
        return "activemq:queue:" + activeMQConfig.queue + "?" +
                "brokerURL=" + activeMQConfig.brokerURL +
                "&username=" + activeMQConfig.username +
                "&password=" + activeMQConfig.password;
    }

}
