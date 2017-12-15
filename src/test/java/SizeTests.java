import org.junit.*;
import rogueluv.framework.Size;

public class SizeTests
{
    private Size size;

    @Before
    public void init()
    {
        this.size = new Size(0, 0);
    }

    @Test
    public void initTest()
    {
        // Basic init
        Assert.assertEquals(0, this.size.getWidth());
        Assert.assertEquals(0, this.size.getHeight());

        // Weird params: a size cannot be negative
        this.size = new Size(-10, -10);
        Assert.assertEquals(0, this.size.getWidth());
        Assert.assertEquals(0, this.size.getHeight());
    }

    @Test
    public void measureTest()
    {
        Assert.assertEquals(0, this.size.getWidth());
        Assert.assertEquals(0, this.size.getHeight());

        this.size.setWidth(5);
        Assert.assertEquals(5, this.size.getWidth());
        this.size.setWidth(-3);
        Assert.assertEquals(0, this.size.getWidth());

        this.size.setHeight(10);
        Assert.assertEquals(10, this.size.getHeight());
        this.size.setHeight(-6);
        Assert.assertEquals(0, this.size.getHeight());
    }
}
