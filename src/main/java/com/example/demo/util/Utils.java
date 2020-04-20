package com.example.demo.util;

import org.springframework.util.StringUtils;

/**
 * @author ljf
 */
public class Utils {

    private static final String COMMA = ",";

    public static String concatWithComma(String str1, String str2) {
        if (str1 == null && str2 == null) {
            return null;
        }
        //str1==null&&str2!=null,str1!=null&&str2!=null,str1!=null&&str2==null,
        else if (str2 == null) {
            return str1;
            //str1==null&&str2!=null,str1!=null&&str2!=null,
        } else {
            if (str1 == null) {
                return str2;
            } else {
                StringBuilder builder = new StringBuilder();
                return str1.endsWith(COMMA) ? builder.append(str1).append(str2).toString() : builder.append(str1).append(COMMA).append(str2).toString();
            }
        }

    }
}
