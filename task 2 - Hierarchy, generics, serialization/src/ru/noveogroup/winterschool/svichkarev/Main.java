package ru.noveogroup.winterschool.svichkarev;

import ru.noveogroup.winterschool.svichkarev.binarytree.BTree;
import ru.noveogroup.winterschool.svichkarev.hierarhy.Child1;

public final class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("hy");
        
        BTree<Child1> tree = new BTree<>();
        tree.add( new Child1( 5 ) );
        
        //System.out.println( tree.root.toString() );
    }

}
