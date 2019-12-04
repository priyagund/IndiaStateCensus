package com.bridgelabz;

public class StateCensusAnalyzerException extends Exception {


    public ExceptionType type;

   public enum ExceptionType {
        ENTERED_NULL, ENTERED_EMPTY, NO_SUCH_FIELD, NO_SUCH_METHOD, NO_SUCH_CLASS,
        OBJECT_CREATION_ISSUE, METHOD_INVOCATION_ISSUE, FIELD_SETTING_ISSUE, NO_SUCH_FILE, INVALID_FILE_TYPE,
        CSV_REQUIRED_FIELD_EMPTY_EXCEPTION, SOME_OTHER_FILE_ERROR
    }

    private String message;

    public StateCensusAnalyzerException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }

    public StateCensusAnalyzerException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public StateCensusAnalyzerException(Throwable cause, ExceptionType type, String message) {
        super(message,cause);
        this.type = type;
    }
}


