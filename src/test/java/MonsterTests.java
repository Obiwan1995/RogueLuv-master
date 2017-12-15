import org.junit.*;
import rogueluv.model.Monster;

public class MonsterTests
{
    private Monster monster;

    @Before
    public void init()
    {
        this.monster = new Monster("test", 0, 0);
    }

    @Test
    public void initTest()
    {
        // Basic init
        Assert.assertEquals("test", this.monster.getName());
        Assert.assertEquals(0, this.monster.getGold());
        Assert.assertEquals(0, this.monster.getStrength());
        Assert.assertEquals('.', this.monster.getSymbol());
        Assert.assertEquals(1, this.monster.countMonster());
        Assert.assertEquals(0, this.monster.countGold());

        // Weird params init
        this.monster = new Monster("test", -10, -10);
        Assert.assertEquals("test", this.monster.getName());
        Assert.assertEquals(0, this.monster.getGold());
        Assert.assertEquals(0, this.monster.getStrength());
        Assert.assertEquals('.', this.monster.getSymbol());

        this.monster = new Monster(null, -10, -10);
        Assert.assertNull(this.monster.getName());
        Assert.assertEquals(0, this.monster.getGold());
        Assert.assertEquals(0, this.monster.getStrength());
        Assert.assertEquals('.', this.monster.getSymbol());
    }

    @Test
    public void nameTest()
    {
        Assert.assertEquals("test", this.monster.getName());

        this.monster.setName("abc");
        Assert.assertEquals("abc", this.monster.getName());

        this.monster.setName(null);
        Assert.assertNull(this.monster.getName());
    }

    @Test
    public void goldTest()
    {
        Assert.assertEquals(0, this.monster.getGold());

        this.monster.setGold(10);
        Assert.assertEquals(10, this.monster.getGold());

        this.monster.setGold(-1);
        Assert.assertEquals(0, this.monster.getGold());
    }

    @Test
    public void strengthTest()
    {
        Assert.assertEquals(0, this.monster.getStrength());

        this.monster.setStrength(10);
        Assert.assertEquals(10, this.monster.getStrength());

        this.monster.setStrength(-1);
        Assert.assertEquals(0, this.monster.getStrength());
    }
}
