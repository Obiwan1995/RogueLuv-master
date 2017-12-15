import org.junit.*;
import rogueluv.framework.Size;
import rogueluv.framework.Vector2;
import rogueluv.model.*;

public class FloorTests
{
    private Floor floor;

    @Before
    public void init()
    {
        this.floor = new Floor();
    }

    @Test
    public void initTest()
    {
        Assert.assertEquals(0, this.floor.countGold());
        Assert.assertEquals(0, this.floor.countMonster());
        Assert.assertEquals(1, this.floor.getLevel());
        Assert.assertNull(this.floor.getSize());
        Assert.assertNotNull(this.floor.getElements());
        Assert.assertTrue(this.floor.getElements().isEmpty());
    }

    @Test
    public void levelTest()
    {
        Assert.assertEquals(1, this.floor.getLevel());

        this.floor.setLevel(3);
        Assert.assertEquals(3, this.floor.getLevel());
        this.floor.setLevel(-4);
        Assert.assertEquals(-4, this.floor.getLevel());
    }

    @Test
    public void sizeTest()
    {
        Assert.assertNull(this.floor.getSize());

        this.floor.setSize(new Size(3, 4));
        Assert.assertEquals(3, this.floor.getSize().getWidth());
        Assert.assertEquals(4, this.floor.getSize().getHeight());

        this.floor.setSize(new Size(-2, -10));
        Assert.assertEquals(0, this.floor.getSize().getWidth());
        Assert.assertEquals(0, this.floor.getSize().getHeight());
    }

    @Test
    public void addElementTest()
    {
        Assert.assertNotNull(this.floor.getElements());
        Assert.assertTrue(this.floor.getElements().isEmpty());

        Cell c = new Cell();
        this.floor.addElement(c);
        Assert.assertEquals(1, this.floor.getElements().size());
        Assert.assertEquals(c, this.floor.getElements().get(0));

        this.floor.addElement(null);
        Assert.assertEquals(2, this.floor.getElements().size());
        Assert.assertEquals(c, this.floor.getElements().get(0));
        Assert.assertNull(this.floor.getElements().get(1));
    }

    @Test
    public void deleteElementTest()
    {
        Assert.assertNotNull(this.floor.getElements());
        Assert.assertTrue(this.floor.getElements().isEmpty());

        Cell c = new Cell();
        this.floor.addElement(c);
        Assert.assertEquals(1, this.floor.getElements().size());

        this.floor.delElement(null);
        Assert.assertEquals(1, this.floor.getElements().size());

        this.floor.delElement(new Cell());
        Assert.assertEquals(1, this.floor.getElements().size());

        this.floor.delElement(c);
        Assert.assertTrue(this.floor.getElements().isEmpty());
    }

    @Test
    public void getCellTest()
    {
        Assert.assertNull(this.floor.getCell(0,0));

        Cell c = new Cell();
        Vector2 v = new Vector2(3, 4);
        c.setPosition(v);
        this.floor.addElement(c);
        Assert.assertEquals(c, this.floor.getCell(3, 4));
        Assert.assertEquals(c, this.floor.getCell(v));
    }

    @Test
    public void getDownstairsTest()
    {
        Assert.assertNull(this.floor.getDownstairs());

        Cell c1 = new Cell();
        c1.setCellType(new Starway());
        this.floor.addElement(c1);
        Cell c2 = new Cell();
        c2.setCellType(new Downstairs(new Floor()));
        this.floor.addElement(c2);
        Assert.assertEquals(c2, this.floor.getDownstairs());

        this.floor.delElement(c1);
        Assert.assertEquals(c2, this.floor.getDownstairs());

        this.floor.delElement(c2);
        Assert.assertNull(this.floor.getDownstairs());
    }

    @Test
    public void getUpstairsTest()
    {
        Assert.assertTrue(this.floor.getUpstairs().isEmpty());
        Assert.assertNull(this.floor.getUpstairs(new Floor()));

        Cell c1 = new Cell();
        c1.setCellType(new Starway());
        this.floor.addElement(c1);
        Cell c2 = new Cell();
        c2.setCellType(new Upstairs(new Floor()));
        this.floor.addElement(c2);
        Assert.assertEquals(1, this.floor.getUpstairs().size());

        this.floor.delElement(c1);
        Assert.assertEquals(1, this.floor.getUpstairs().size());

        this.floor.delElement(c2);
        Assert.assertTrue(this.floor.getUpstairs().isEmpty());

        c1.setCellType(new Upstairs(this.floor));
        Floor f = new Floor();
        f.addElement(c1);
        f.addElement(c2);
        Assert.assertNull(this.floor.getUpstairs(f));
        Assert.assertNotNull(f.getUpstairs(this.floor));
        Assert.assertEquals(c1, f.getUpstairs(this.floor));
        f.delElement(c2);
        Assert.assertEquals(c1, f.getUpstairs(this.floor));
        f.delElement(c1);
        Assert.assertNull(f.getUpstairs(this.floor));
    }

    @Test
    public void countMonsterTest()
    {
        Assert.assertEquals(0, this.floor.countMonster());

        Cell c = new Cell();
        c.setCellType(new Monster("test", 10, 2));
        this.floor.addElement(c);
        this.floor.addElement(c);
        this.floor.addElement(c);
        this.floor.addElement(c);
        Cell c2 = new Cell();
        c2.setCellType(new Potion(3));
        this.floor.addElement(c2);
        this.floor.addElement(c2);
        this.floor.addElement(c2);

        Assert.assertEquals(4, this.floor.countMonster());
        this.floor.delElement(c);
        Assert.assertEquals(3, this.floor.countMonster());
        this.floor.delElement(c);
        Assert.assertEquals(2, this.floor.countMonster());
        this.floor.delElement(c2);
        Assert.assertEquals(2, this.floor.countMonster());
        this.floor.delElement(c);
        this.floor.delElement(c);
        Assert.assertEquals(0, this.floor.countMonster());
        this.floor.delElement(c2);
        Assert.assertEquals(0, this.floor.countMonster());
    }

    @Test
    public void countGoldTest()
    {
        Assert.assertEquals(0, this.floor.countGold());

        Cell c = new Cell();
        c.setCellType(new Treasure( 2));
        this.floor.addElement(c);
        this.floor.addElement(c);
        this.floor.addElement(c);
        Cell c2 = new Cell();
        c2.setCellType(new Potion(3));
        this.floor.addElement(c2);
        this.floor.addElement(c2);
        this.floor.addElement(c2);

        Assert.assertEquals(6, this.floor.countGold());
        this.floor.delElement(c);
        Assert.assertEquals(4, this.floor.countGold());
        this.floor.delElement(c);
        this.floor.delElement(c);
        Assert.assertEquals(0, this.floor.countGold());
        this.floor.delElement(c2);
        Assert.assertEquals(0, this.floor.countGold());
    }
}
