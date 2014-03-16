package ru.noveogroup.winterschool.svichkarev.binarytree.exception;

public class NullNodeFoundException extends TreeException {
    private static final long serialVersionUID = 7L;
    private static final String errorMessage = "Null node found as argument"; 

    public NullNodeFoundException() {
        super( errorMessage );
    }

}
