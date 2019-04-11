/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javafile.mainplation.infastructure.util;

import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Mohammed Al-Mutairi
 */
public class StringsUtil {
    
    
    public static int findStringCount(String line,String  str)
    {
        return  line.split(str,-1).length - 1;
        
    }
    
   
    public static String findFirstWord(String str)
    {
        if (str == null || str.isEmpty())
        {
            return "";
        }
        String[] str2 = str.split(" ");
        return str2.length > 0 ? str2[0] : "";
     }
    
    
     public static String findFirstWord(String str,List<String> removedWord)
    {
        if (str == null || str.isEmpty())
        {
            return "";
        }
        for (String a:removedWord) { str = removeFromStartUntilWord(str, a) ; }
        return findFirstWord(str);
     }
    
     
     public static String removeFromStartUntilWord(String str,String word)
     {
         if (str.contains(word))
         {
             String removeString =  str.substring(0,str.indexOf(word)+word.length()+1);
             String r =  str.replace(removeString, "").trim();
             return r;
         }
         return str;
     }
             
    
    
}
