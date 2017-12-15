package rogueluv.framework;

public enum Direction {
    North(1),
    South(2),
    West(4),
    East(8),
    Up(1),
    Down(2),
    Left(4),
    Right(8);
    
    
    private final int direction;
    
    Direction(int direction) {
        this.direction = direction;
    }
}
