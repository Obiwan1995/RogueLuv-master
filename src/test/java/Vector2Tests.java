import org.junit.*;
import rogueluv.framework.Vector2;

public class Vector2Tests
{
    private Vector2 vector;

    @Before
    public void init()
    {
        this.vector = new Vector2(0, 0);
    }

    @Test
    public void initTest()
    {
        // Basic constructor
        Assert.assertEquals(0, this.vector.getX());
        Assert.assertEquals(0, this.vector.getY());

        // Constructor with one parameter
        Vector2 v = new Vector2(1);
        Assert.assertEquals(1, v.getX());
        Assert.assertEquals(1, v.getY());

        // Constructor with another vector
        this.vector = new Vector2(v);
        Assert.assertEquals(1, this.vector.getX());
        Assert.assertEquals(1, this.vector.getY());
    }

    @Test
    public void positionTest()
    {
        Assert.assertEquals(0, this.vector.getX());
        Assert.assertEquals(0, this.vector.getY());

        this.vector.setX(10);
        Assert.assertEquals(10, this.vector.getX());

        this.vector.setY(10);
        Assert.assertEquals(10, this.vector.getY());
    }

    @Test
    public void addTest()
    {
        Assert.assertEquals(0, this.vector.getX());
        Assert.assertEquals(0, this.vector.getY());

        this.vector.addX(3);
        Assert.assertEquals(3, this.vector.getX());
        this.vector.addX(0);
        Assert.assertEquals(3, this.vector.getX());
        this.vector.addX(-2);
        Assert.assertEquals(1, this.vector.getX());

        this.vector.addY(6);
        Assert.assertEquals(6, this.vector.getY());
        this.vector.addY(0);
        Assert.assertEquals(6, this.vector.getY());
        this.vector.addY(-10);
        Assert.assertEquals(-4, this.vector.getY());
    }

    @Test
    public void equalsTest()
    {
        Assert.assertTrue(this.vector.equals(this.vector));
        Assert.assertFalse(this.vector.equals(null));
        Assert.assertFalse(this.vector.equals(new Vector2(3, 3)));
        Assert.assertTrue(this.vector.equals(new Vector2(0, 0)));

        this.vector.addX(2);
        Assert.assertTrue(this.vector.equals(new Vector2(2, 0)));

        this.vector.addY(3);
        Assert.assertTrue(this.vector.equals(new Vector2(2, 3)));

        Assert.assertTrue(this.vector.equals(new Vector2(this.vector)));
    }
}
