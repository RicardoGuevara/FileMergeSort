/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RICARDO
 */
public class Mergesort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        FileWizard wizard = new FileWizard();
        ArrayList<BigInteger> merge = mergeSort(wizard.loadFromFile("test_file"));
        wizard.loadToFile("archivo desordenado.txt", merge);
        
    }
    
    public static ArrayList<BigInteger> mergeSort(ArrayList<BigInteger> list)
    {
        //System.out.println(list);
        int size = list.size();
        return mergeSort(new ArrayList(list.subList(0, size/2)),new ArrayList(list.subList(size/2,size)));
    }
    
    public static ArrayList<BigInteger> mergeSort(ArrayList<BigInteger> list_a, ArrayList<BigInteger> list_b)
    {
        if(list_a.size()>1)
            list_a = mergeSort(list_a);
        if(list_b.size()>1)
            list_b = mergeSort(list_b);
        
        return combineAndSort(list_a,list_b);
    } 
    
    public static ArrayList<BigInteger> combineAndSort(ArrayList<BigInteger> list_a, ArrayList<BigInteger> list_b)
    {
        ArrayList<BigInteger> merge = new ArrayList<>();
        
        while (!list_a.isEmpty() || !list_b.isEmpty())
            if (list_a.isEmpty())
                merge.add(list_b.remove(0));
            else if (list_b.isEmpty())
                merge.add(list_a.remove(0));
            else if (list_a.get(0).compareTo(list_b.get(0))<0)
                merge.add(list_a.remove(0));
            else
                merge.add(list_b.remove(0));
        
        //System.out.println("sort -> "+merge);
        return merge;
    }
    
}
