/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javafile.mainplation.domain.main.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.javafile.mainplation.domain.main.JavaFile;
import org.javafile.mainplation.domain.main.factory.JavaFileFactory;
import org.junit.Test;

/**
 *
 * @author Dell
 */
public class TestingReadingJavaFile {
    
    
    
    @Test
    public void addingPackage()
    {
        /*
          1) we remove new line character
          2) we transfer package\s{2,} to package\s{1}
          3) we remove space before or after point
          4) we don't remove ; character
        */     
        List<String> i = Arrays.asList("package ","a   .   b.    c",";");
        JavaFile  file = JavaFileFactory.ProcessJavaSrcFile(i);
        assertThat(file.getPackageName(),is("package a.b.c;"));
        
    }
    
    @Test
    public void addingImport()
    {
        /*
          To catch import we remove \n and \r and split by ; to find import list
          
        */
        List<String> i = Arrays.asList("import a."," b . C ;");
        JavaFile  file = JavaFileFactory.ProcessJavaSrcFile(i);
         assertThat(file.getImports().size(),is(1));
        assertThat(file.getImports().get(0).toString(),is("import a.b.C;"));
        
        /*
          if we have two imports in one line we deal with it as two import
        */
        
   
        i = Arrays.asList("import a.B;import a.C;");
        file = JavaFileFactory.ProcessJavaSrcFile(i);
        assertThat(file.getImports().size(),is(2));
        
        
        /*
           we ignore white space with  ;  
        */        
       
        i = Arrays.asList("import a.B;import a.C; ; ; ; ;");
        file = JavaFileFactory.ProcessJavaSrcFile(i);
        assertThat(file.getImports().size(),is(2));
        assertThat(file.getImports().get(0).toString(),is("import a.B;"));
        assertThat(file.getImports().get(1).toString(),is("import a.C;"));
        
        
        /*
           we ignore the space at the begening and the ending of statement        
        */
 
        i = Arrays.asList(" import a.B ; import a.C ; import a.D ;");
        file = JavaFileFactory.ProcessJavaSrcFile(i);
        assertThat(file.getImports().size(),is(3));
        assertThat(file.getImports().get(0).toString(),is("import a.B;"));
        assertThat(file.getImports().get(1).toString(),is("import a.C;"));
        assertThat(file.getImports().get(2).toString(),is("import a.D;"));
        
        
               
      
        i = Arrays.asList(" import a.B ; import");
        file = JavaFileFactory.ProcessJavaSrcFile(i);
        assertThat(file.getImports().size(),is(1));

//        String j = i.substring(0, i.indexOf(";")+1);
//        JOptionPane.showMessageDialog(null, j);
//        JOptionPane.showMessageDialog(null, i.replace(j, ""));
        
    }
 
    @Test
    public void testAddingPublicClass() {
        List<String> addingClass = new ArrayList<>();
        addingClass.add("public ");
        addingClass.add("    class A   extends   C ,D , E { ");
        JavaFile file = JavaFileFactory.ProcessJavaSrcFile(addingClass);
        assertThat(file.getJavaClass().getJavaClassName(),is("A"));
        
    }
    
}
