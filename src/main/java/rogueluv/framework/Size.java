package rogueluv.framework;

public class Size {
    private int height;
    private int width;

    public void setWidth(int width) {
        if (width < 0)
        {
            width = 0;
        }
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        if (height < 0)
        {
            height = 0;
        }
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
    
    public Size(int width, int height) {
        this.setWidth(width);
        this.setHeight(height);
    }

    public String toString() {
        return new StringBuilder()
            .append("Size[")
            .append(width)
            .append("x")
            .append(height)
            .append("]")
            .toString();
    }
}
