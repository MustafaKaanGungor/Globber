import java.util.ArrayList;

public class Yazar extends Hesap implements YazarIslem, KullaniciIslem{
    Yazar(String kullaniciAd, String kayitTarihi, String dogumTarihi, String cinsiyet, String password) {
        super(kullaniciAd, kayitTarihi, dogumTarihi, cinsiyet, password);
    }
    
    Yazar(String kullaniciAd, String kayitTarihi, String dogumTarihi, String cinsiyet, String password, ArrayList<Integer> blogs, ArrayList<String> followers) {
        super(kullaniciAd, kayitTarihi, dogumTarihi, cinsiyet, password);
        this.yazilanBloglar = (ArrayList<Integer>)blogs.clone();
        this.takipciler = (ArrayList<String>)followers.clone(); //TODO buradaki uyarının nedenini araştır
    }
    
    
    ArrayList<Integer> yazilanBloglar = new ArrayList<Integer>();
    ArrayList<String> takipciler = new ArrayList<String>();
    
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
