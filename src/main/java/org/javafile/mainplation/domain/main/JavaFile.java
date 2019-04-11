/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javafile.mainplation.domain.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;
import javax.swing.JOptionPane;
import org.javafile.mainplation.domain.main.src.JavaCode;

 

 

/**
 *
 * @author Mohammed Al-Mutairi
 */
public class JavaFile {
    
        
    String packageName;
     
    JavaClass javaClass ;
    List<JavaField> fields = new ArrayList<>();
    List<JavaMethod> methods = new ArrayList<>();
    List<JavaImport> imports = new ArrayList<>();
    List<JavaComment> comments = new ArrayList<>();
    String path;
    int currentIndex = 0;

    public void addImportStatement(JavaCode lines) 
    {
        List<JavaImport> i = JavaImport.createJavaImport(lines); 
        imports.addAll(i);
        increaseCurrentIndexBy(i.size());
    
    }
    
    
    public void addPackageStatement(JavaCode lines) 
    {
        String p = lines.getJavaLines()
                .replace("\n", "")
                .replace("\r", "")
                .replaceAll("package\\s{2,}","package ")
                .replaceAll("\\.\\s+",".")
                .replaceAll("\\s+\\.",".")
                ;
        
        this.packageName = p;
        increaseCurrentIndexBy(1);
        
    }
    
    public void increaseCurrentIndexBy(int num)
    {
        currentIndex += num;
    }

    public List<JavaImport> getImports() {
        return imports;
    }

    public String getPackageName() {
        return packageName;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public JavaClass getJavaClass() {
        return javaClass;
    }
    
    

    public void addPublicClass(JavaCode lines) 
    {
    
        this.javaClass = JavaClass.createJavaClass(lines, imports);
        
        increaseCurrentIndexBy(1);
        
    }
    
    
    
    
    
    
    
}
