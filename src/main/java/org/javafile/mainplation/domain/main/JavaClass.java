/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javafile.mainplation.domain.main;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import org.javafile.mainplation.domain.main.src.JavaCode;
import static org.javafile.mainplation.infastructure.util.StringsUtil.findFirstWord;

/**
 *
 * @author Mohammed Al-mutairi
 * 
 * this will include all info of JavaFile except JavaField and JavaMethod
 * 
 */

public class JavaClass       {

    String javaClassName;
    List<JavaType> annotations;
    List<JavaType> extendClasses;
    List<JavaType> implementInterfaces;
    JavaCode javaCode;
 
    
    public static JavaClass createJavaClass(JavaCode lines,List<JavaImport> imports) {
        lines.removeNoneNeedSpace();
        JavaClass javaClass = new JavaClass();
        javaClass.javaCode = lines;
        javaClass.javaClassName = findFirstWord(lines.getJavaLines(),Arrays.asList("public","class"));
        
        if (lines.getJavaLines().contains("extends"))
        {
            String extendsClass = findFirstWord(lines.getJavaLines(),Arrays.asList("extends"));
            JOptionPane.showMessageDialog(null, extendsClass);
            
        }
        
        
        if (lines.getJavaLines().contains("implements"))
        {
            String implementedClass = findFirstWord(lines.getJavaLines(),Arrays.asList("implements"));
           
        }
        
        
        
        return javaClass;
    }
    
    private JavaClass()
    {
        
    }

    public String getJavaClassName() {
        return javaClassName;
    }

    public List<JavaType> getAnnotations() {
        return annotations;
    }

    public List<JavaType> getExtendClasses() {
        return extendClasses;
    }

    public List<JavaType> getImplementInterfaces() {
        return implementInterfaces;
    }

    public JavaCode getJavaCode() {
        return javaCode;
    }

    
    
    
    
    
    
    
    
    
    
    
    
}
