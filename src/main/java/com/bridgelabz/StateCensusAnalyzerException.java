package com.bridgelabz;

public class StateCensusAnalyzerException extends Exception
{
    public StateCensusAnalyzerException(ExceptionType noSuchFile) {
    }

    public enum ExceptionType {
        ENTERED_NULL, ENTERED_EMPTY, NO_SUCH_FIELD, NO_SUCH_METHOD, NO_SUCH_CLASS,
        OBJECT_CREATION_ISSUE, METHOD_INVOCATION_ISSUE, FIELD_SETTING_ISSUE, NO_SUCH_FILE, INVALID_FILE_TYPE,
        CSV_REQUIRED_FIELD_EMPTY_EXCEPTION, SOME_OTHER_FILE_ERROR;


    }

    public ExceptionType type;

    String message;

    public StateCensusAnalyzerException(ExceptionType type, String message) {
        super(message);
        this.type=type;
    }


    public StateCensusAnalyzerException(ExceptionType type, Throwable cause) {
        super(cause);
        this.type = type;
    }

    public StateCensusAnalyzerException(ExceptionType type, Throwable cause, String message) {
        super(message, cause);
        this.type = type;
    }

}

