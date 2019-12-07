package com.bridgelabz;

public class StateCensusAnalyzerException extends Exception {


    public ExceptionType type;

   public enum ExceptionType {
        NO_SUCH_FILE, INVALID_FILE_TYPE,
        NO_SUCH_METHOD, SOME_OTHER_FILE_ERROR
    }


    public StateCensusAnalyzerException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }

}


