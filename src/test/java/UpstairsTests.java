import org.junit.*;
import rogueluv.model.*;

public class UpstairsTests
{
    private Upstairs upstairs;
    private Floor floor;

    @Before
    public void init()
    {
        this.floor = new Floor();
        this.upstairs = new Upstairs(floor);
    }

    @Test
    public void initTest()
    {
        Assert.assertEquals('>', this.upstairs.getSymbol());
        Assert.assertEquals(0, this.upstairs.countGold());
        Assert.assertEquals(0, this.upstairs.countMonster());
    }

    @Test
    public void getFloorTest()
    {
        Assert.assertEquals(this.floor, this.upstairs.getFloor());

        Floor f = new Floor();
        this.upstairs.setFloor(f);
        Assert.assertNotEquals(this.floor, this.upstairs.getFloor());
        Assert.assertEquals(f, this.upstairs.getFloor());
    }

    @Test
    public void countGoldTest()
    {
        Assert.assertEquals(0, this.upstairs.countGold());

        Cell c = new Cell();
        c.setCellType(new Treasure(2));
        this.floor.addElement(c);
        this.floor.addElement(c);
        this.floor.addElement(c);
        this.floor.addElement(c);
        this.floor.addElement(c);
        Cell c2 = new Cell();
        c2.setCellType(new Potion(12));
        this.floor.addElement(c2);
        this.floor.addElement(c2);
        this.upstairs = new Upstairs(this.floor);

        Assert.assertEquals(10, this.upstairs.countGold());
        Cell c3 = new Cell();
        c3.setCellType(new Treasure(16));
        this.floor.addElement(c3);
        Assert.assertEquals(26, this.upstairs.countGold());
        this.floor.delElement(c);
        Assert.assertEquals(24, this.upstairs.countGold());
        this.floor.getElements().clear();
        Assert.assertEquals(0, this.upstairs.countGold());
    }

    @Test
    public void countMonsterTest()
    {
        Assert.assertEquals(0, this.upstairs.countMonster());

        Cell c = new Cell();
        c.setCellType(new Monster("test", 10, 2));
        this.floor.addElement(c);
        this.floor.addElement(c);
        this.floor.addElement(c);
        this.floor.addElement(c);
        Cell c2 = new Cell();
        c2.setCellType(new Potion(12));
        this.floor.addElement(c2);
        this.floor.addElement(c2);
        this.upstairs = new Upstairs(this.floor);

        Assert.assertEquals(4, this.upstairs.countMonster());
        Cell c3 = new Cell();
        c3.setCellType(new Monster("test", 10, 10));
        this.floor.addElement(c3);
        Assert.assertEquals(5, this.upstairs.countMonster());
        this.floor.delElement(c);
        Assert.assertEquals(4, this.upstairs.countMonster());
        this.floor.getElements().clear();
        Assert.assertEquals(0, this.upstairs.countMonster());
    }
}
