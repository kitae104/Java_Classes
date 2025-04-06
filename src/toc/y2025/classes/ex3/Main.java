package toc.y2025.classes.ex3;

public class Main {
    public static void main(String[] args) {
        Movie[] movies = {
            new Movie("파묘", 9),
            new Movie("웡카", 7),
            new Movie("듄2", 8)
        };

        for (Movie m : movies) {
            m.showInfo();
            if (m.isRecommended()) {
                System.out.println("→ 추천 영화입니다!");
            }
            System.out.println();
        }
    }
}
