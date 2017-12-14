package rogueluv.framework;

public class Random extends java.util.Random {
    public Random() {
        super();
    }
    
    public int rint(int minBound, int maxBound) {
        return minBound + this.nextInt(maxBound - minBound);
    }    
    public float rfloat(float minBound, float maxBound) {
        return minBound + this.nextFloat() * (maxBound - minBound);
    }
}
