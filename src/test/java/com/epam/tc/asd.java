package com.epam.tc;

public class asd {
    public static void main(String[] args) {
        String data[ ] [ ] = {
                {"fatther", "7"},
                {"helo", "4"},
                {"сенхрофазотрон", "14"}
        };
        String word = "";
        String num = "";

        for(int i=0;i<data.length;i++){
           word+= data[i][0];
           num += data[i][1];
            for (int j=0;j<data[i].length;j++)
            {
//                num += data[0][j];
            }
        }
        System.out.println(word);
        System.out.println(num);
    }

}
