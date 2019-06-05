package org.cloudfun.design.pattern.structrue;

/**
 * Copyright @ 2019/6/4
 *
 * @author cloudgc
 * @since 0.0.1
 * 现有的类不能满足需求，但是需要增加新的功能
 */
public class AdapterPattern {

    public interface CarMediPlayer{
        public void play(String auditType,String filename);

    }

    interface AdvanceMediaPlayer{
        void playVlc(String filename);
        void playMp4(String filename);
    }

    static class VlcPlayer implements AdvanceMediaPlayer{

        @Override
        public void playVlc(String filename) {
            System.out.println("playing vlc file: "+filename);
        }

        @Override
        public void playMp4(String filename) {

        }
    }
    static class Mp4Player implements AdvanceMediaPlayer{

        @Override
        public void playVlc(String filename) {

        }

        @Override
        public void playMp4(String filename) {
            System.out.println("playing mp4 file:"+filename);
        }
    }

    static class MediaAdapter implements CarMediPlayer{

         AdvanceMediaPlayer advancedMusicPlayer;

        public MediaAdapter(String audioType){
            if(audioType.equalsIgnoreCase("vlc") ){
                advancedMusicPlayer = new VlcPlayer();
            } else if (audioType.equalsIgnoreCase("mp4")){
                advancedMusicPlayer = new Mp4Player();
            }
        }

        @Override
        public void play(String audioType, String fileName) {
            if(audioType.equalsIgnoreCase("vlc")){
                advancedMusicPlayer.playVlc(fileName);
            }else if(audioType.equalsIgnoreCase("mp4")){
                advancedMusicPlayer.playMp4(fileName);
            }
        }
    }

    static class AudioAdapter implements CarMediPlayer{



        @Override
        public void play(String auditType, String filename) {
            if(auditType.equals("mp3")){
                System.out.println("play mp3 file:"+filename);
            }else if(auditType.equals("mp4")||auditType.equals("vlc")){
                MediaAdapter mediaAdapter=new MediaAdapter(auditType);
                mediaAdapter.play(auditType,filename);
            }else{
                System.out.println("other file type");
            }



        }
    }


    public static void main(String[] args) {
        AudioAdapter audioAdapter = new AudioAdapter();
        audioAdapter.play("mp3","love.mp3");


    }




}
