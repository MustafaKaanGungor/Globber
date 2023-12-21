public class Hesap {
    private String kullaniciAd;
    private String hesapSifresi;
    //TODO: Profil fotosu değişkeni ekle
    private String kayitTarihi;
    private String dogumTarihi;
    private String cinsiyet;
    private String bio;

    public String getKullaniciAd() {
        return kullaniciAd;
    }

    public void setKullaniciAd(String kullaniciAd) {
        this.kullaniciAd = kullaniciAd;
    }

    public String getKullaniciSifre() {
        return hesapSifresi;
    }

    public void setKullaniciSifre(String kullaniciSifre) {
        this.hesapSifresi = kullaniciSifre;
    }

    public String getKayitTarihi() {
        return kayitTarihi;
    }

    public void setKayitTarihi(String kayitTarihi) {
        this.kayitTarihi = kayitTarihi;
    }

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

}
