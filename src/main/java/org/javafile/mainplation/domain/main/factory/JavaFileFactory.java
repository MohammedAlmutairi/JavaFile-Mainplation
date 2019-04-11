/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javafile.mainplation.domain.main.factory;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import static java.util.stream.Collectors.toList;
import org.javafile.mainplation.domain.main.JavaFile;
import org.javafile.mainplation.domain.main.src.JavaCode;
 

/**
 *
 * @author Mohammed Al-mutairi
 */
public class JavaFileFactory {

    public static JavaFile ProcessJavaSrcFile(List<String> javaSrcCode) {
        JavaFile javaFile = new JavaFile();
        int codeLevel = 0;
        JavaCode lines = new JavaCode(javaFile.getCurrentIndex());
        javaSrcCode = onlyOneStatementInLine(javaSrcCode);
        for (String code : javaSrcCode) {

            codeLevel = changeCodeLevel(code, codeLevel);
            lines.append(code.trim(), codeLevel);

            if (lines.isEndStatement(codeLevel)) {
                if (codeLevel == 0) {
                    /*
                      when adding statement to JavaFile
                     */
                    if (addPackgeOrImportStatement(lines, javaFile)) {
                        /*
                         we need to create new line
                         */
                        lines = new JavaCode(javaFile.getCurrentIndex());
                    }
                   

                } else if (codeLevel == 1) {
                    
                      if (addPublicClass(lines, javaFile))
                    {
                        lines = new JavaCode(javaFile.getCurrentIndex());
                    }
                }

            }

        }

        return javaFile;

    }

    public static int changeCodeLevel(String lineOfCode, int codeLevel) {
        if (lineOfCode.contains("{")) {
            return codeLevel + 1;
        } else if (lineOfCode.contains("}")) {
            return codeLevel - 1;
        }
        return codeLevel;
    }

    public static List<String> onlyOneStatementInLine(List<String> codes) {

        Function<String, String[]> converter
                = s
                -> s.replace(";", ";\n")
                        .replace("{", "{\n")
                        .replace("}", "}\n")
                        
                        .split("\\n");

        return codes.stream()
                .map(s -> converter.apply(s))
                .flatMap(Arrays::stream)
                .collect(toList());

    }

    public static boolean addPackgeOrImportStatement(JavaCode lines, JavaFile javaFile) {
        if (lines.isImportStatement()) {
            javaFile.addImportStatement(lines);
            return true;

        } else if (lines.isPackageStatement()) {
            javaFile.addPackageStatement(lines);
            return true;
        }
        return false;
    }
    public static boolean  addPublicClass(JavaCode lines, JavaFile javaFile) {
        
        if (lines.isPublicClass())
        {
             javaFile.addPublicClass(lines);
            return true;
        }
        return false;
        
    }
    
   

}
