package ru.noveogroup.winterschool.svichkarev.hierarhy;

import java.io.Serializable;

public class Parent implements Serializable {
    private static final long serialVersionUID = 7L;
    // just for testing
    protected int field;
    
    public Parent( int value ){
        field = value;
    }
    
    // just for testing
    @Override
    public String toString(){
        return new String( "Parent=" + field );
    }
    
    // just for testing
    @Override
    public int hashCode() {
        return field;
    }
}
