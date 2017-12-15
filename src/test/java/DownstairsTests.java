import org.junit.*;
import rogueluv.model.Downstairs;
import rogueluv.model.Floor;

public class DownstairsTests
{
    private Floor floor;
    private Downstairs downstairs;

    @Before
    public void init()
    {
        this.floor = new Floor();
        this.downstairs = new Downstairs(this.floor);
    }

    @Test
    public void initTest()
    {
        Assert.assertEquals('<', this.downstairs.getSymbol());
        Assert.assertEquals(0, this.downstairs.countGold());
        Assert.assertEquals(0, this.downstairs.countMonster());
    }

    @Test
    public void getFloorTest()
    {
        Assert.assertEquals(this.floor, this.downstairs.getFloor());

        Floor f = new Floor();
        this.downstairs.setFloor(f);
        Assert.assertNotEquals(this.floor, this.downstairs.getFloor());
        Assert.assertEquals(f, this.downstairs.getFloor());
    }
}
