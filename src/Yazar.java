import java.util.ArrayList;

public class Yazar extends Hesap implements YazarIslem, KullaniciIslem{
    Yazar(String kullaniciAd, String kayitTarihi, String dogumTarihi, String cinsiyet, String password) {
        super(kullaniciAd, kayitTarihi, dogumTarihi, cinsiyet, password);
    }
    
    Yazar(String kullaniciAd, String kayitTarihi, String dogumTarihi, String cinsiyet, String password,String bio, ArrayList<Integer> blogs, ArrayList<String> followers) {
        super(kullaniciAd, kayitTarihi, dogumTarihi, cinsiyet, password, bio);
        this.yazilanBloglar = (ArrayList<Integer>)blogs.clone();
        this.takipciler = (ArrayList<String>)followers.clone(); //TODO buradaki uyarının nedenini araştır
    }
    
    
    ArrayList<Integer> yazilanBloglar = new ArrayList<Integer>();
    ArrayList<String> takipciler = new ArrayList<String>();
    
    @Override
    public void yazarTakipEt() {
        throw new UnsupportedOperationException("Unimplemented method 'yazarTakipEt'");
    }
    @Override
    public void yazarTakiptenCik() {
        throw new UnsupportedOperationException("Unimplemented method 'yazarTakiptenCik'");
    }
    @Override
    public void tagTakipEt() {
        throw new UnsupportedOperationException("Unimplemented method 'tagTakipEt'");
    }
    @Override
    public void tagTakiptenCik() {
        throw new UnsupportedOperationException("Unimplemented method 'tagTakiptenCik'");
    }
    @Override
    public void blogOku() {
        throw new UnsupportedOperationException("Unimplemented method 'blogOku'");
    }
    @Override
    public void yorumYap() {
        throw new UnsupportedOperationException("Unimplemented method 'yorumYap'");
    }
    @Override
    public void yorumunuSil() {
        throw new UnsupportedOperationException("Unimplemented method 'yorumunuSil'");
    }
}
