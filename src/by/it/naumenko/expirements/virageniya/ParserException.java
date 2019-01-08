package by.it.naumenko.expirements.virageniya;

public class ParserException extends Exception{
    
    private static final long serialVersionUID = 1L;
    private String errStr;  //  Описание ошибки
 
    public ParserException(String errStr) {
        super();
        this.errStr = errStr;
    }
    
    public String toString(){
        return this.errStr;
    }
}