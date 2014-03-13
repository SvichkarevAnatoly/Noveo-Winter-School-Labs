package ru.noveogroup.winterschool.svichkarev.hierarhy;

public class Parent {
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
