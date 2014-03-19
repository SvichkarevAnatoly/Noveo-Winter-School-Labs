package ru.noveogroup.winterschool.svichkarev.binarytree.exception;

public class NodeNotFoundException extends TreeException {
    private static final long serialVersionUID = 7L;
    private static final String ERROR_MESSAGE = "Node not found to remove"; 

    public NodeNotFoundException() {
        super( ERROR_MESSAGE );
    }
}
