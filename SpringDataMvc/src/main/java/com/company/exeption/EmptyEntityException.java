package com.company.exeption;

public class EmptyEntityException extends Exception {
    public EmptyEntityException(){
        super("Not found entity with this parameter");
    }
}

