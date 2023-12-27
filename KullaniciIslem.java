public interface KullaniciIslem {
    //hem kullanıcıların hem yazarların hem de adminin yapabilceği işlemler buraya -Mustafa
    
    //kullanıcılar hesaplarındaki bilgileri düzenleyebilmeli
    //ama başkalarınkine elleyemeyecek

    //blog okunduğu zaman kullanıcının okuma geçmişine update

    //blog beğenme, yorum yapma, var olan yorumu beğenme
    //yazar takip etme
    //tag takip etmest
    void yorumYap();

    void yorumunuSil();

    void yazarTakipEt();

    void yazarTakiptenCik();

    void tagTakipEt();

    void tagTakiptenCik();

    void blogOku();
}
