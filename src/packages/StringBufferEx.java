package packages;

public class StringBufferEx {
    public static void main(String[] args) {
        String s = new String("a");

        StringBuffer sb = new StringBuffer("a");

        s.concat("bc");
        sb.append("bc");
        System.out.println(sb.capacity());
        System.out.println(sb.length());
        sb.insert(2, "de");
        sb.replace(2, 4, "그리고");
        sb.reverse();
        System.out.println(s);
        System.out.println(sb);
    }

}
