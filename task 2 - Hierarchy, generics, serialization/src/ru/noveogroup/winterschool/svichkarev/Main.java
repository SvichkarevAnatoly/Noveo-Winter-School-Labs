package ru.noveogroup.winterschool.svichkarev;

import ru.noveogroup.winterschool.svichkarev.binarytree.BTree;
import ru.noveogroup.winterschool.svichkarev.binarytree.BTreeInterface;
import ru.noveogroup.winterschool.svichkarev.binarytree.exception.TreeException;
import ru.noveogroup.winterschool.svichkarev.binarytree.utility.PrinterTree;
import ru.noveogroup.winterschool.svichkarev.hierarhy.Child1;
import ru.noveogroup.winterschool.svichkarev.hierarhy.Child2;
import ru.noveogroup.winterschool.svichkarev.hierarhy.Parent;

public final class Main {
    public static void main(String[] args) {
        BTreeInterface<Parent> tree = new BTree<>();
        
        Parent someNodeValue1 = new Child1( 5 );
        Parent someNodeValue2 = new Child1( 35 );
        
        try{
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
            
            // iterator testing
            PrinterTree.printTree( tree, System.out );
            System.out.println( "Leafs = " + tree.countLeafs() );
            
            // remove some nodes
            tree.remove( someNodeValue2 );
            tree.remove( new Parent( 17 ) );
            
            PrinterTree.printTree( tree, System.out );
            System.out.println( "Leafs = " + tree.countLeafs() );
            
            // if you want catch exception, uncomment it
            //tree.remove( new Parent( 55 ) );
        } catch( TreeException treeErr ){
            System.out.println( "Вот не хотел здесь оказаться, честное слово =(" );
            System.out.println( treeErr );
        }
    }

}
