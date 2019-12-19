package task1.exception;


public class MyException extends RuntimeException{

   public MyException(String message) {
       System.out.println(message);
    }

}
