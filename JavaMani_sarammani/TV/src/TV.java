public class TV {
    //한계값 기호 상수 이용
    public static final int MAX_CHANNEL = 5;
    public static final int MIN_CHANNEL = 1;
    public static final int MAX_VOLUME = 10;
    public static final int MIN_VOLUME = 1;
    
    boolean status=false; //off
    int channel=1;
    int volume=5;
    
    //행위 제작
    void pushPower(){
        //뒤집기
        status= !status;
    }
    void channelUp(){
        if (this.status){
            if(this.channel==MAX_CHANNEL){
                this.channel=MIN_CHANNEL;
                System.out.println("채널 : "+this.channel);
            }
            else{
                this.channel++;
                System.out.println("채널 : "+this.channel);
            }
        }
        else {
            System.out.println("전원부터 켜세용");
        }
       
    }
    void channelDown(){
        if (this.status){
            if(this.channel==MIN_CHANNEL){
                this.channel=MAX_CHANNEL;
                System.out.println("채널 : "+this.channel);
            }
            else{
                this.channel--;
                System.out.println("채널 : "+this.channel);
            }
        }
        else {
            System.out.println("전원부터 켜세용");
        }
    }
    void VolumeUp(){
        if (this.status) {
            if (this.volume == MAX_VOLUME) {
                System.out.println("더 이상 볼륨을 올릴 수 없습니다.");
            } else {
                this.volume++;
                System.out.println("볼륨 : " + this.volume);
            }

        }
        else {
            System.out.println("전원부터 켜세용");
        }
    }
    void VolumeDown(){

        if (this.status) {
            if (this.volume == MIN_VOLUME) {
                System.out.println("더 이상 볼륨을 내릴 수 없습니다.");
            } else {
                this.volume--;
                System.out.println("볼륨 : " + this.volume);
            }
        }
        else {
            System.out.println("전원부터 켜세용");
        }
    }
}

