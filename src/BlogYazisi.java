import java.util.ArrayList;

public class BlogYazisi {

    BlogYazisi(int ID,String title,String content, String publishDate){
        this.ID = ID;
        this.baslik = title;
        this.icerik = content;
        this.yayinTarihi = publishDate;
    }

    BlogYazisi(int ID,String title,String content, String publishDate,
     Tag tag, int likeCount, ArrayList<Integer> comments, int viewCount) {
        this.ID = ID;
        this.baslik = title;
        this.icerik = content;
        this.yayinTarihi = publishDate;
        this.tag = tag;
        this.begeniSayisi = likeCount;
        this.yorumlar = (ArrayList<Integer>)comments.clone();
        this.goruntulenmeSayisi = viewCount;
    }
    
    Integer ID;
    String baslik;
    String icerik;
    String yayinTarihi;
    Tag tag; //Sadece 1 tag eklemeye izin var
    int begeniSayisi;
    ArrayList<Integer> yorumlar = new ArrayList<Integer>();
    int goruntulenmeSayisi;

    BlogYazisi goruntule() {
        this.goruntulenmeSayisi++;
        return this;
        //TODO buradan kullanıcının methodları çağırılcak
    }

    void editBaslik(String newBaslik) {
        this.baslik = newBaslik;
    }

    void editIcerik(String icerik) {
        this.icerik = icerik;
    }


}
