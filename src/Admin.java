public class Admin extends Hesap implements KullaniciIslem, YazarIslem{

    Admin(String kullaniciAd, String kayitTarihi, String dogumTarihi, String cinsiyet, String password) {
        super(kullaniciAd, kayitTarihi, dogumTarihi, cinsiyet, password);
    }

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
    //! adminin kendine özgü değişkeni yok sadece methodları olacak -Mustafa

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
