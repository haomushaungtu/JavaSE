package designpattern.proxy;

/**
 * @author admin
 */
public class Prusit implements IGiveGirl{

    SchoolGirl schoolGirl;
    private String floor;
    private String money;

    public Prusit(SchoolGirl schoolGirl) {
        this.schoolGirl = schoolGirl;
    }

    public Prusit() {

    }

    @Override
    public void giveFloor() {
        System.out.println("花花花");
    }
}
