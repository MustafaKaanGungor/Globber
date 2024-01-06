import java.util.ArrayList;

public class BlogYazisi {

    Integer ID;
    String baslik;
    String icerik;
    //TODO: Kapak fotosu değişkeni ekle
    String yayinTarihi;
    Tag tag; //Sadece 1 tag eklemeye izin var
    int begeniSayisi;
    ArrayList<Integer> yorumlar = new ArrayList<Integer>();
    int yorumSayisi; //yorum sayısını ya her yorum eklendiğinde ve silindiğinde arttırıp azaltıcaz ya da 
    //süreki yorum sayısını yorumlar.size() a eşitleyen bi kod yazıcaz.
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
