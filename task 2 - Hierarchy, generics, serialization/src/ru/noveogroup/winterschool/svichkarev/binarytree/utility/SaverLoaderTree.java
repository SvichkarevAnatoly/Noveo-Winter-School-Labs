package ru.noveogroup.winterschool.svichkarev.binarytree.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import ru.noveogroup.winterschool.svichkarev.binarytree.BTreeInterface;

public class SaverLoaderTree {
    public static void save( BTreeInterface<?> tree, String fileName ) throws FileNotFoundException, IOException{
        // self close
        try( FileOutputStream file = new FileOutputStream( fileName ) ){
            try( ObjectOutputStream stream = new ObjectOutputStream( file ) ){
                stream.writeObject( tree );
                stream.writeInt( tree.countLeafs() );
            }
        }
    }
    
    public static BTreeInterface<?> load( String fileName ) throws ClassNotFoundException, IOException {
        BTreeInterface<?> tree = null;
        // self close
        try( FileInputStream file = new FileInputStream( fileName ) ){
            try( ObjectInputStream stream = new ObjectInputStream( file ) ){
                tree = (BTreeInterface<?>) stream.readObject();
                System.out.println( stream.readInt() );
            }
        }
        
        return tree;
    }
}
