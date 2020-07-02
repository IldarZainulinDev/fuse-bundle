package impl;

public class RabbitMQConfig {
    String hostname;
    String portNumber;
    String username;
    String password;
    String queue;
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public void setPortNumber(String portNumber) {
        this.portNumber = portNumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

}
