package ru.noveogroup.winterschool.svichkarev.binarytree.exception;

public class NodeNotFoundException extends TreeException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static final String errorMessage = "Node not found to remove"; 

    public NodeNotFoundException() {
        super( errorMessage );
    }
}
