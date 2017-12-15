import org.junit.*;
import rogueluv.framework.Vector2;
import rogueluv.model.Cell;

public class CellTests
{
    private Cell cell;

    @Before
    public void init()
    {
        this.cell = new Cell();
    }

    @Test
    public void initTest()
    {
        Assert.assertEquals(0, this.cell.countMonster());
        Assert.assertEquals(0, this.cell.countGold());
        Assert.assertEquals('X', this.cell.getSymbol());
        Assert.assertFalse(this.cell.isDiscovered());
        Assert.assertNull(this.cell.getCellType());
        Assert.assertNull(this.cell.getPosition());
    }

    @Test
    public void positionTest()
    {
        Assert.assertNull(this.cell.getPosition());

        this.cell.setPosition(Vector2.Zero);
        Assert.assertEquals(0, this.cell.getPosition().getX());
        Assert.assertEquals(0, this.cell.getPosition().getY());

        this.cell.setPosition(new Vector2(-10, 1));
        Assert.assertEquals(-10, this.cell.getPosition().getX());
        Assert.assertEquals(1, this.cell.getPosition().getY());
    }

    @Test
    public void discoveredTest()
    {
        Assert.assertFalse(this.cell.isDiscovered());

        this.cell.setDiscovered(true);
        Assert.assertTrue(this.cell.isDiscovered());
        Assert.assertEquals('.', this.cell.getSymbol());

        this.cell.setDiscovered(false);
        Assert.assertFalse(this.cell.isDiscovered());
        Assert.assertEquals('X', this.cell.getSymbol());
    }
}
