/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javase;

import javax.swing.JOptionPane;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dell
 */
public class TesitingInJava {
    
   
    
    @Test
    public void test()
    {
        String s = "import a.B;public Class B{ int x; }";
        String[] s2 = s.split("(;|\\{|)");
//        p(s2[0]);
        assertThat(s,is("?"));
        
    }
    public void p(String msg) { JOptionPane.showMessageDialog(null, msg);}
}
