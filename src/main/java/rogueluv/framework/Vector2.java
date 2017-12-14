package rogueluv.framework;

public class Vector2 {

    private int x;
    private int y;

    public Vector2 x(int x) {
        this.x = x;
        return this;
    }
    public int x() {
        return x;
    }
    public Vector2 y(int y) {
        this.y = y;
        return this;
    }
    public int y() {
        return y;
    }
    
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


    public Vector2 add(Vector2 v) {
        Vector2 vAdd = new Vector2(this.x + v.x, this.y + v.y);
        return vAdd;
    }

    public Vector2 substract(Vector2 v) {
        Vector2 vAdd = new Vector2(this.x - v.x, this.y - v.y);
        return vAdd;
    }

    public Vector2 multiply(int v) {
        Vector2 vAdd = new Vector2(this.x * v, this.y * v);
        return vAdd;
    }
    
    public boolean equals(Vector2 v) {
        return ((v.x == this.x) && (v.y == this.y));
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
	
	public static void main(String[] args) 
	{
		
	}
}
