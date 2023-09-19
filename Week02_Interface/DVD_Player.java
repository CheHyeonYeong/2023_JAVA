package Week02_Interface;

public class DVD_Player implements ExPlayers {
    @Override
    public void play() {
        System.out.println("play");
    }

    @Override
    public void slow() {
        System.out.println("slow");

    }

    @Override
    public void stop() {
        System.out.println("stop");

    }
}
