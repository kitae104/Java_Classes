package jaemin.packages.string;

public class StringEx {
    public static void main(String[] args) {
        String a = new String(" kim ");
        String b = new String("- jaemain ");
        a = a.concat(b);
        System.out.println(a);
        System.out.println(a.length());

        a = a.trim();
        int length = a.length();
        System.out.println(length);
        System.out.println(a.indexOf('a'));
        System.out.println(a.lastIndexOf('a'));
        System.out.println(a.charAt(a.lastIndexOf('a')));
        a = a.replace("ai", "i");
        a = a.replace(" - ", "-");
        System.out.println(a);
        String[] split = a.split("-");

        for (String s : split) {
            System.out.println(s);
        }

        String name = "kimjaemin";
        System.out.println(name.substring(0, 3));
        System.out.println(name.substring(3));
        System.out.println(name.substring(3, 6));

    }
}
