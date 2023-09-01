package ru.aston.bogatov_vi.task1;

public class CreditException extends RuntimeException{
    private final int codeException;
    private final String messageException;

    public CreditException(String messageException, int codeException) {
        this.codeException = codeException;
        this.messageException = messageException;
    }


    @Override
    public String getMessage() {
        return "Code Exception " + codeException + " \nMessage Exception " + messageException;
    }

}