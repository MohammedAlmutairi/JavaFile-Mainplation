/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javafile.mainplation.domain.main;

/**
 *
 * @author Mohammed Al-Mutairi
 */
public class JavaType {
    
    
    String typeFullName;
    
    public String getAsImport() { return ""; }
    public String getAsAnotation() { return ""; }
    public String getAsType() { return ""; }

    
    public JavaType(String typeFullName)
    {
        this.typeFullName = typeFullName;
    }
    
    
}
