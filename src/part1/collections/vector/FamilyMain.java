package part1.collections.vector;

public class FamilyMain {
    public static void main(String[] args) {
        Family father = new Family("김기태", 53, "아빠");
        Family mother = new Family("박승희", 48, "엄마");
        Family daughter1 = new Family("김지민", 23, "큰딸");
        Family daughter2 = new Family("김재민", 21, "막내");

        Family[] families = new Family[4];
        families[0] = new Family("김기태", 53, "아빠");

        Family[] f2 = { father, mother, daughter1};
    }
}
