import java.util.ArrayList;

public class Kullanici extends Hesap implements KullaniciIslem{
    Kullanici(String kullaniciAd, String kayitTarihi, String dogumTarihi, String cinsiyet, String password) {
        super(kullaniciAd, kayitTarihi, dogumTarihi, cinsiyet, password);
    }

    Kullanici(String kullaniciAd, String kayitTarihi, String dogumTarihi, String cinsiyet, String password,
        ArrayList<Integer> comments, ArrayList<String> followedWriters, ArrayList<Tag> tags, ArrayList<Integer> history) {
        super(kullaniciAd, kayitTarihi, dogumTarihi, cinsiyet, password);

        this.yorumlarList = (ArrayList<Integer>)comments.clone();
        this.takipEdilenYazarlar = (ArrayList<String>)followedWriters.clone();
        this.takipEdilenTagler = (ArrayList<Tag>)tags.clone();
        this.okumaGecmisi = (ArrayList<Integer>)history.clone();
    }

    ArrayList<Integer> yorumlarList = new ArrayList<Integer>();
    ArrayList<String> takipEdilenYazarlar = new ArrayList<String>();
    ArrayList<Tag> takipEdilenTagler = new ArrayList<Tag>();

    ArrayList<Integer> okumaGecmisi = new ArrayList<Integer>();

    Tag degisken = Tag.Edebiyat;

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
