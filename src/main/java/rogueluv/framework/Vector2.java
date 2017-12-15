package rogueluv.framework;

public class Vector2 {

    private int x;
    private int y;
    
    public void addX(int x) {
        this.x = this.x + x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void addY(int y) {
        this.y = this.y + y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }


    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector2(int xy) {
        this.x = xy;
        this.y = xy;
    }

    public Vector2(Vector2 v) {
        this.x = v.x;
        this.y = v.y;
    }
    
    public boolean equals(Vector2 v) {
        return (v != null && (v.x == this.x) && (v.y == this.y));
    }


    public String toString() {
        return new StringBuilder()
            .append("Vector2[")
            .append(x)
            .append(",")
            .append(y)
            .append("]")
            .toString();
    }
    
    public final static Vector2 Minus = new Vector2(-1, -1);
    public final static Vector2 Zero = new Vector2(0, 0);
    public final static Vector2 One = new Vector2(1, 1);
}
