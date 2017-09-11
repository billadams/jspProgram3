/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Bill Adams
 */
public class StringUtil {
    
    public static String convertToEnumText(String string) {
        
        string = string.trim().toUpperCase();
        // Break up the sent string into two parts to allow the insertion of 
        // and underscore four places from the end of the string.
        String prefix = string.substring(string.length() - 4);
        String suffix = string.substring(string.length() - 3);
        
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        sb.append("_");
        sb.append(suffix);
        
        String convertedString = String.valueOf(sb);
        
        return convertedString;
        
    }
}
