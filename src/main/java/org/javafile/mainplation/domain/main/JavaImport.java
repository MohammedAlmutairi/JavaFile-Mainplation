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
import org.javafile.mainplation.domain.main.src.JavaCode;
import sun.text.resources.JavaTimeSupplementary;

/**
 *
 * @author Mohammed Al-Mutairi
 */
public class JavaImport {
    
     JavaCode javaCode;

    public JavaImport(JavaCode javaCode) {
        this.javaCode = javaCode;
    }
     
    
    public static JavaType findJavaType(String name,List<JavaImport> imports)
    {
        for (JavaImport i:imports)
        {
            if (i.getJavaCode().getJavaLines().endsWith("."+name))
            {
                String s = i.getJavaCode().getJavaLines().replace("import", "").trim();
                return new JavaType(s);
                
            }
        }
        return new JavaType(name);
    }
     
     
     
     public static List<JavaImport> createJavaImport(JavaCode code)
     {
  
         int[] index =  { code.getIndex() };
         String[] imports = code.getJavaLines()
                 .replace("\n", "")
                 .replace("\r", "")
                 .replaceAll("\\.\\s+",".")
                 .replaceAll("\\s+\\.",".")
                 .split(";");
                 
                 
        return Arrays.asList(imports)
                 .stream()
                 .filter(s -> !s.trim().equals(""))
                 .map(s -> s.trim() + ";")
                 .map(s -> new JavaImport(new JavaCode(s,index[0]++)))
                 .collect(toList())
                 ;

                 
        
     }

    @Override
    public String toString() {
    
        return javaCode.getJavaLines();
    }

    public JavaCode getJavaCode() {
        return javaCode;
    }
     
     
    
     
    
}
