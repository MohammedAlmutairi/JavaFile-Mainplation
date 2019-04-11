/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javafile.mainplation.domain.main.src;

/**
 *
 * @author Mohammed Al-Mutairi
 */
public class JavaCode {

    int index;
    String javaLines = "";

    public JavaCode(String line) {
        this.javaLines = line;
    }

    public JavaCode(String line, int index) {
        this.javaLines = line;
        this.index = index;
    }

    public JavaCode(int index) {
        this("", index);
    }

    public JavaCode() {

        this("", 1);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getJavaLines() {
        return javaLines;
    }
    
    
    

    public void setJavaLines(String javaLines) {
        this.javaLines = javaLines;
    }

    public void append(String line,int codeLevel) {
        if (codeLevel > 1)
        {
            javaLines += "\n " + line;
        }
        else
        {
 
            if (javaLines == null || javaLines.isEmpty())
            {
                
                 javaLines =  line;
            }
            else
            {
                 javaLines += (line.contains(";") ? "" : " ") + line;
            }
            
        }
       

    }
    


    public boolean isEndStatement(int codeLevel) {
        return javaLines.contains(";") ||
                (javaLines.contains("}") && codeLevel == 1) ||
                (javaLines.contains("{") && codeLevel == 1) ||
                (javaLines.contains("*/"))
                ;
    }

    public boolean isImportStatement() {
        return javaLines.contains("import");
    }

    public boolean isPackageStatement() {
        return javaLines.contains("package");
    }
       public boolean isPublicClass() {
        return javaLines.contains("public") && javaLines.contains("class");
    }

       
    public void removeNoneNeedSpace()
    {
         this.javaLines = this.javaLines
                 .trim()
                 .replaceAll("\\s{2,}", " ")
                 .replaceAll(",\\s{1,}",",")
                 .replaceAll("\\s{1,},",",")
                 ;
    }
       
    
    


    
    
    



}
