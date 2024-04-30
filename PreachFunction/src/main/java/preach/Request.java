package preach;

public class Request {
    //  Necesita saber el tipo de metodo [GET, POST, PUT, DELETE...].
    private String httpMethod;
    // Si quiero actualizar uno nuevo;
    private Preach preach;

    public String getHttpMethod() {
        return httpMethod;
    }
    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }
    public Preach getPreach() {
        return preach;
    }
    public void setPreach(Preach preach) {
        this.preach = preach;
    }
    
}
