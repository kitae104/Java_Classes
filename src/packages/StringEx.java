package packages;

public class StringEx {
    public static void main(String[] args) {
        String a = new String(" abcd");
        String b = new String(", efg ");
        a = a.concat(b);
        System.out.println(a);
        System.out.println(a.length());
        a = a.trim();
        System.out.println(a);
        System.out.println(a.length());

        a = a.replace(" ", "");
        System.out.println(a);

        String str = "홍길동, 김길동, 이길동, 최길동";
        String kkd = str.substring(5, 8);
        System.out.println(kkd);
        System.out.println(kkd.contains("홍"));


        String[] names = str.split(",");
        for (String name : names) {
            System.out.println(name.trim());
        }

        String jumin = "012345-4567890";
        int position = jumin.indexOf("-");
        System.out.println(position);



        char gender = jumin.charAt(position+1);
        System.out.println(gender);

        if(gender == '1' || gender == '3'){
            System.out.println("남자");
        } else if(gender == '2' || gender == '4'){
            System.out.println("여자");
        }

    }
}
