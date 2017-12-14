package rogueluv.framework;

public enum Direction {
    North(1),
    South(2),
    West(4),
    East(8),
    Up(1),
    Down(2),
    Left(4),
    Right(8),
    Upstairs(1024),
    Downstairs(2048);
    
    
    private final int direction;
    
    Direction(int direction) {
        this.direction = direction;
    }
}
