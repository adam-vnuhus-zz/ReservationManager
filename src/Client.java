public class Client {

    private String clientId;
    private Type type;

    public Client() {

    }

    public Client(String clientId, Type type) {
        this.clientId = clientId;
        this.type = type;
    }

    void print() {
        System.out.println("clientId = " + this.clientId + ", type = " + this.type);
    }

    Type getType() {
        return this.type;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setType(Type type) {
        this.type = type;
    }

    String getClientId() {
        return this.clientId;
    }



    @Override
    public String toString() {
        return "Client [clientId=" + clientId + ", type=" + type + "]";
    }
}
