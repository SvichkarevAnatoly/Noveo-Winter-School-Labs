package ru.noveogroup.winterschool.svichkarev.binarytree.exception;

public class NullNodeFoundException extends TreeException {
    private static final long serialVersionUID = 7L;
    private static final String ERROR_MESSAGE = "Null node found as argument"; 

    public NullNodeFoundException() {
        super( ERROR_MESSAGE );
    }

}
