import org.junit.*;
import rogueluv.model.Treasure;

public class TreasureTests
{
    private Treasure treasure;

    @Before
    public void init()
    {
        this.treasure = new Treasure(0);
    }

    @Test
    public void initTest()
    {
        // Basic init
        Assert.assertEquals(0, this.treasure.getGold());
        Assert.assertEquals(0, this.treasure.countGold());
        Assert.assertEquals('$', this.treasure.getSymbol());
        Assert.assertEquals(0, this.treasure.countMonster());

        // Weird param
        this.treasure = new Treasure(-10);
        Assert.assertEquals(0, this.treasure.getGold());
        Assert.assertEquals(0, this.treasure.countGold());
    }

    @Test
    public void goldTest()
    {
        Assert.assertEquals(0, this.treasure.countGold());
        Assert.assertEquals(0, this.treasure.getGold());

        this.treasure.setGold(10);
        Assert.assertEquals(10, this.treasure.countGold());
        Assert.assertEquals(10, this.treasure.getGold());

        this.treasure.setGold(-10);
        Assert.assertEquals(0, this.treasure.countGold());
        Assert.assertEquals(0, this.treasure.getGold());
    }
}
