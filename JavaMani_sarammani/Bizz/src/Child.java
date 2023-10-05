public class Child {
    private int bizz = 0;
    private Child os; //상대

    public Child(int bizz){
        this.bizz=bizz;
    }
    public void you(Child os){
        this.os = os;
    }
    public void lose(int bizz){
        if(bizz <=0){
            System.out.println("못줘 안줘 뭘해");
            return;
        }
        if(this.bizz<bizz){
            System.out.println("구글 개수 부족");
            this.bizz=0;
            return;
        }
        this.bizz -=bizz;

        os.win(bizz);
    }
    public void win (int bizz){
        if(bizz <= 0){
            System.out.println("못줘 안줘 뭘해");
            return;
        }
        this.bizz +=bizz;
    }

    public String show() {
        return "보유 개수 : " + bizz;
    }

}
