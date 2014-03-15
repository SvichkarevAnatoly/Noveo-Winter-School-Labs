package ru.noveogroup.winterschool.svichkarev.binarytree.utility;

import java.io.PrintStream;

import ru.noveogroup.winterschool.svichkarev.binarytree.BTreeInterface;

// for testing
public class PrinterTree {
    public static void printTree( BTreeInterface<?> tree, PrintStream stream ){
        String result = "";
        
        for( Object element : tree ){
            result += element.toString() + "\n";
        }
        
        stream.println( result );
    }
}
