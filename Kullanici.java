import java.util.ArrayList;

public class Kullanici extends Hesap implements KullaniciIslem{
    ArrayList<Yorum> yorumlarList = new ArrayList<Yorum>();
    ArrayList<Yazar> takipEdilenYazarlar = new ArrayList<Yazar>();
    ArrayList<Tag> takipEdilenTagler = new ArrayList<Tag>();

    ArrayList<BlogYazisi> okumaGecmisi = new ArrayList<BlogYazisi>();

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
