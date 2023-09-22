public class TVUser {
    public static void main(String[] args) {

        TV tv = new TV();

        tv.pushPower();

        System.out.println("up test");
        for (int i=0; i<10; i++) {

            System.out.println(i+"test");
            tv.channelUp();
            tv.VolumeUp();
        }
        System.out.println("down test");
        for (int i=0; i<10; i++) {
            System.out.println(i+"test");
            tv.channelDown();
            tv.VolumeDown();
        }

        System.out.println("push test");
        tv.pushPower();
        tv.channelUp();
        tv.VolumeUp();
        tv.channelDown();
        tv.VolumeDown();

    }
}
