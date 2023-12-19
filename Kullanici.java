import java.util.ArrayList;

public class Kullanici extends Hesap implements KullaniciIslem{
    ArrayList<Yorum> yorumlarList = new ArrayList<Yorum>();
    ArrayList<Yazar> takipEdilenYazarlar = new ArrayList<Yazar>();
    ArrayList<Tag> takipEdilenTagler = new ArrayList<Tag>();

    ArrayList<BlogYazisi> okumaGecmisi = new ArrayList<BlogYazisi>();
}
