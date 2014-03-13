package ru.noveogroup.winterschool.svichkarev;

import ru.noveogroup.winterschool.svichkarev.binarytree.BTree;
import ru.noveogroup.winterschool.svichkarev.hierarhy.Child1;
import ru.noveogroup.winterschool.svichkarev.hierarhy.Child2;
import ru.noveogroup.winterschool.svichkarev.hierarhy.Parent;

public final class Main {
    public static void main(String[] args) {
        BTree<Parent> tree = new BTree<>();
        
        Parent someNodeValue1 = new Child1( 5 );
        Parent someNodeValue2 = new Child1( 35 );
        
        // http://habrahabr.ru/post/65617/
        // must sorting
        tree.add( new Child1( 10 ) );
        tree.add( someNodeValue1 );
        tree.add( someNodeValue1 );
        tree.add( new Child2( 1 ) );
        tree.add( new Parent( 4 ) );
        tree.add( someNodeValue2 );
        tree.add( new Child2( 20 ) );
        tree.add( new Parent( 99 ) );
        tree.add( new Child2( 31 ) );
        tree.add( new Parent( 17 ) );
        
        // iterator testing in toString()
        System.out.println( tree.toString() );
        
        // remove some nodes
        tree.remove( someNodeValue1 );
        tree.remove( someNodeValue2 );
        
        System.out.println( tree.toString() ); 
    }

}
