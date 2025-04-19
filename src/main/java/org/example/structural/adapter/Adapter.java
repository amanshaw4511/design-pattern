package org.example.structural.adapter;

public class Adapter {
    public static void main(String[] args) {
        MusicPlayer mp3Player = new Mp3Player();
        MediaPlayer mediaPlayer = new MediaPlayerAdapter(mp3Player);

        mediaPlayer.play();
    }
}

interface MediaPlayer {
    void play();
}

interface MusicPlayer {
    void playMusic();
}

class Mp3Player implements MusicPlayer {

    @Override
    public void playMusic() {
        System.out.println("Playing Mp3 Music");
    }
}

class MediaPlayerAdapter implements MediaPlayer {
    private final MusicPlayer musicPlayer;

    MediaPlayerAdapter(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    @Override
    public void play() {
        musicPlayer.playMusic();
    }
}
