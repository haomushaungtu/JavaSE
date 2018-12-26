package exceptionDemo;

/**
 * 异常类型:1.运行异常RuntimeException 2.checkedException
 * 
 * @author huanghao
 *
 */
public class DefineException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public DefineException() {

    }

    public DefineException(String message) {
        super(message);
    }

}
