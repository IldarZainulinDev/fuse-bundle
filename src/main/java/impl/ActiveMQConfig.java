package impl;

public class ActiveMQConfig {
    String brokerURL;
    String username;
    String password;
    String queue;

    public void setBrokerURL(String brokerURL) {
        this.brokerURL = brokerURL;
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
