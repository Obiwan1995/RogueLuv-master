import org.junit.*;
import rogueluv.model.Potion;

public class PotionTests
{
    private Potion potion;

    @Before
    public void init()
    {
        this.potion = new Potion(0);
    }

    @Test
    public void initTest()
    {
        // Basic init
        Assert.assertEquals(0, this.potion.getStrength());
        Assert.assertEquals(0, this.potion.countGold());
        Assert.assertEquals(0, this.potion.countMonster());
        Assert.assertEquals('p', this.potion.getSymbol());

        // Weird param (potions with negative strength are allowed)
        this.potion = new Potion(-10);
        Assert.assertEquals(-10, this.potion.getStrength());
    }

    @Test
    public void strengthTest()
    {
        Assert.assertEquals(0, this.potion.getStrength());

        this.potion.setStrength(10);
        Assert.assertEquals(10, this.potion.getStrength());

        this.potion.setStrength(-10);
        Assert.assertEquals(-10, this.potion.getStrength());
    }
}
