package az.ingress.exception;


public class  CustomFeignException extends RuntimeException {
    private String message;
    private int code;
    private  String errorCode;

    public CustomFeignException(String message,int code,String errorCode) {
        super(message);
        this.message = message;
        this.code = code;
    }
}
