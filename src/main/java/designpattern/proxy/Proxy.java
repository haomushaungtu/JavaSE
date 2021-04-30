package designpattern.proxy;

public class Proxy implements IGiveGirl{

    private Prusit prusit;

    public Proxy(Prusit prusit) {
        this.prusit = prusit;
    }
    @Override
    public void giveFloor() {
        System.out.println("打印日志");
        prusit.giveFloor();
    }
}
