package jaemin.packages.stringbuffer;

import java.util.StringTokenizer;

public class StringBufferEx {
    public static void main(String[] args) {
        String s = "a";
        s = s.concat(" pencil");
        System.out.println(s);


        StringBuffer sb = new StringBuffer("a");
        sb.append(" pencil");
        sb.insert(2, "nice ");
        System.out.println(sb);

        String query = "name=kim&age=20&address=seoul";
        String[] split = query.split("&");
        for (String string : split) {
            System.out.println(string);
            String[] split1 = string.split("=");
            System.out.println(split1[1]);
        }

        String query2 = "name=kim&age=20&address=seoul";
        StringTokenizer st = new StringTokenizer(query2, "&=");
        while(st.hasMoreTokens()) {
            String token = st.nextToken();
            System.out.println(token);
        }
    }
}
