package Multimedia;

public interface Volume {
    final int VOLUME=10;//MAX VOLUME 10
    public int volume=5; //VOLUME IMPOSTATO A 5 di default
    public void alzaVolume();
    public void abbassaVolume();
    public void getVolume();
    void play();
}