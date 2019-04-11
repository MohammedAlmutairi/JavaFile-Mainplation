/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javafile.mainplation.domain.main;

import java.util.List;
import org.javafile.mainplation.domain.main.src.JavaCode;

/**
 *
 * @author Dell
 */
public class JavaField {
    
    JavaType type;
    String name;
    JavaCode lines;
    List<JavaType> annotations;
    
    
    public JavaField(JavaCode lines)
    {
        this.lines = lines;
    }
    
    
}
