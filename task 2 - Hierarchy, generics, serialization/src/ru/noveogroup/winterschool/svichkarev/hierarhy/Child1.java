package ru.noveogroup.winterschool.svichkarev.hierarhy;

final public class Child1 extends Parent {

    private static final long serialVersionUID = 7L;

    public Child1(int value) {
        super(value);
    }
 
    // just for testing
    @Override
    public String toString(){
        return new String( "Child1=" + field );
    }
}
