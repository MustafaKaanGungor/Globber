import java.util.ArrayList;

public class Kullanici extends Hesap implements KullaniciIslem{
    Kullanici(String kullaniciAd, String kayitTarihi, String dogumTarihi, String cinsiyet, String password) {
        super(kullaniciAd, kayitTarihi, dogumTarihi, cinsiyet, password);
    }

    Kullanici(String kullaniciAd, String kayitTarihi, String dogumTarihi, String cinsiyet, String password, String bio,
        ArrayList<Integer> comments, ArrayList<String> followedWriters, ArrayList<Tag> tags, ArrayList<Integer> history) {
        super(kullaniciAd, kayitTarihi, dogumTarihi, cinsiyet, password, bio);

        this.yorumlarList = (ArrayList<Integer>)comments.clone();
        this.takipEdilenYazarlar = (ArrayList<String>)followedWriters.clone();
        this.takipEdilenTagler = (ArrayList<Tag>)tags.clone();
        this.okumaGecmisi = (ArrayList<Integer>)history.clone();
    }

    ArrayList<Integer> yorumlarList = new ArrayList<Integer>();
    ArrayList<String> takipEdilenYazarlar = new ArrayList<String>();
    ArrayList<Tag> takipEdilenTagler = new ArrayList<Tag>();

    ArrayList<Integer> okumaGecmisi = new ArrayList<Integer>();

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
