package rogueluv.patern;

public class XY {

    private int x;
    private int y;

    public XY x(int x) {
        this.x = x;
        return this;
    }
    public int x() {
        return x;
    }
    public XY y(int y) {
        this.y = y;
        return this;
    }
    public int y() {
        return y;
    }

    public XY() {
        this.x = 0;
        this.y = 0;
    }
    
    public XY(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public XY(int xy) {
        this.x = xy;
        this.y = xy;
    }
}
