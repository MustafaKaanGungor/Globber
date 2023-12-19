import java.util.ArrayList;

public class BlogYazisi {
    String baslik;
    String icerik;
    //TODO: Kapak fotosu değişkeni ekle
    String yayinTarihi;
    Tag tag; //Sadece 1 tag eklemeye izin var
    int begeniSayisi;
    ArrayList<Yorum> yorumlar = new ArrayList<Yorum>();
    int yorumSayisi; //yorum sayısını ya her yorum eklendiğinde ve silindiğinde arttırıp azaltıcaz ya da 
    //süreki yorum sayısını yorumlar.size() a eşitleyen bi kod yazıcaz.
    int goruntulenmeSayisi;
}
