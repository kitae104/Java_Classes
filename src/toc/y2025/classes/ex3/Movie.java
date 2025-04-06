package toc.y2025.classes.ex3;

public class Movie {
    String title;
    int rating;

    public Movie(String title, int rating) {
        this.title = title;
        this.rating = rating;
    }

    public void showInfo() {
        System.out.println("영화 제목: " + title + " / 평점: " + rating + "점");
    }

    public boolean isRecommended() {
        return rating >= 8;
    }
}
