package ru.noveogroup.winterschool.svichkarev.hierarhy;

public class Parent {
    //? just for testing
    private int field;
    
    public Parent( int value ){
        field = value;
    }
    
    //? just for testing
    @Override
    public String toString(){
        return new String( "" + field );
    }
}
