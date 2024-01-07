public class Yorum {
    Integer ID;
    Integer konum;
    String yazanKisi;
    String text;
    int likeCount;

    Yorum(Integer ID, Integer blog, String writer, String text) {
        this.ID = ID;
        this.konum = blog;
        this.yazanKisi = writer;
        this.text = text;
    }

    Yorum(Integer ID, Integer blog, String writer, String text, int likeCount) {
        this.ID = ID;
        this.konum = blog;
        this.yazanKisi = writer;
        this.text = text;
        this.likeCount = likeCount;
    }
}
