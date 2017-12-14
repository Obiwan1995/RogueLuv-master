package rogueluv.framework;

public class Size {
    private int height;
    private int width;

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
    
    public Size() {
        this.width = 0;
        this.height = 0;
    }
    
    public Size(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    public Size(int length) {
        this.width = length;
        this.height = length;
    }
    
    public Size(Size size) {
        this.width = size.getWidth();
        this.height = size.getHeight();
    }


    public Size add(Size s) {
        Size vAdd = new Size(this.width + s.width, this.height + s.height);
        return vAdd;
    }

    public Size substract(Size s) {
        Size vAdd = new Size(this.width - s.width, this.height - s.height);
        return vAdd;
    }

    public Size multiply(int s) {
        Size vAdd = new Size(this.width * s, this.height * s);
        return vAdd;
    }
    
    public boolean equals(Size s) {
        return ((s.width == this.width) && (s.height == this.height));
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
