import java.time.LocalDate;
import java.util.ArrayList;

public class Yazar extends Hesap implements YazarIslem, KullaniciIslem{
    Yazar(String kullaniciAd, LocalDate kayitTarihi, String dogumTarihi, String cinsiyet) {
        super(kullaniciAd, kayitTarihi, dogumTarihi, cinsiyet);
        //TODO Auto-generated constructor stub
    }
    ArrayList<BlogYazisi> yazilanBloglar = new ArrayList<BlogYazisi>();
    int yazilanBlogSayisi;
    ArrayList<Kullanici> takipciler = new ArrayList<Kullanici>();
    @Override
    public void yazarTakipEt() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'yazarTakipEt'");
    }
    @Override
    public void yazarTakiptenCik() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'yazarTakiptenCik'");
    }
    @Override
    public void tagTakipEt() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'tagTakipEt'");
    }
    @Override
    public void tagTakiptenCik() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'tagTakiptenCik'");
    }
    @Override
    public void blogOku() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'blogOku'");
    }
    @Override
    public void yorumYap() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'yorumYap'");
    }
    @Override
    public void yorumunuSil() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'yorumunuSil'");
    }
}
