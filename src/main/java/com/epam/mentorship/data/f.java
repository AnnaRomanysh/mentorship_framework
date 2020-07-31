package com.epam.mentorship.data;

import java.util.regex.Pattern;

public class f {

    public static void main(String ... args){
        String a = "notAWord";
        String[] ops = a.split("");
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile("[A-Z]");
        for (int i =0; i< ops.length;i++){
            int index = i >=ops.length-1?i:i+1;
           boolean startsFromUpper =  pattern.matcher(ops[index]).find();
            stringBuilder.append(ops[i].toLowerCase());
             if(i==0){
                 stringBuilder.replace(0,1, ops[i].toUpperCase());
            }
              if(startsFromUpper){
                 stringBuilder.append(" ");
             }

        }

    }
}
