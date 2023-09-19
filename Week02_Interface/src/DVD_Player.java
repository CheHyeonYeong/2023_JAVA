public class DVD_Player implements ExPlayers{
    @Override
    public void play() {
        System.out.println("play");
    }

    @Override
    public void stop() {
        System.out.println("stop");
    }

    @Override
    public void slow() {
        System.out.println("slow");
    }

    public static void main(String[] args) {
        DVD_Player obj = new DVD_Player();
        obj.play();
        obj.slow();
        obj.stop();
    }
}