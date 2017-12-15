import org.junit.*;
import rogueluv.framework.Direction;
import rogueluv.framework.Size;
import rogueluv.framework.Vector2;
import rogueluv.model.Floor;
import rogueluv.model.Player;

public class PlayerTests
{
    @Before
    public void reset()
    {
        Player.resetInstance();
    }

    @Test
    public void initTest()
    {
        Assert.assertEquals(0, Player.getInstance().getGold());
        Assert.assertEquals(0, Player.getInstance().getStrength());
        Assert.assertEquals('@', Player.getInstance().getSymbol());
        Assert.assertEquals(Vector2.Zero, Player.getInstance().getPosition());
        Assert.assertNull(Player.getInstance().getCurrentFloor());
        Assert.assertNull(Player.getInstance().getActualCell());
    }

    @Test
    public void getStrengthTest()
    {
        Assert.assertEquals(0, Player.getInstance().getStrength());

        Player.getInstance().setStrength(20);
        Assert.assertEquals(20, Player.getInstance().getStrength());
        Player.getInstance().setStrength(-15);
        Assert.assertEquals(0, Player.getInstance().getStrength());
    }

    @Test
    public void addStrengthTest()
    {
        Assert.assertEquals(0, Player.getInstance().getStrength());

        Player.getInstance().addStrength(3);
        Assert.assertEquals(3, Player.getInstance().getStrength());
        Player.getInstance().addStrength(-10);
        Assert.assertEquals(0, Player.getInstance().getStrength());
    }

    @Test
    public void getGoldTest()
    {
        Assert.assertEquals(0, Player.getInstance().getGold());

        Player.getInstance().setGold(18);
        Assert.assertEquals(18, Player.getInstance().getGold());
        Player.getInstance().setGold(-25);
        Assert.assertEquals(0, Player.getInstance().getGold());
    }

    @Test
    public void addGoldTest()
    {
        Assert.assertEquals(0, Player.getInstance().getGold());

        Player.getInstance().addGold(5);
        Assert.assertEquals(5, Player.getInstance().getGold());
        Player.getInstance().addGold(-3);
        Assert.assertEquals(2, Player.getInstance().getGold());
        Player.getInstance().addGold(-4);
        Assert.assertEquals(0, Player.getInstance().getGold());
    }

    @Test
    public void getCurrentFloorTest()
    {
        Assert.assertNull(Player.getInstance().getCurrentFloor());

        Floor f = new Floor();
        Player.getInstance().setCurrentFloor(f);
        Assert.assertEquals(f, Player.getInstance().getCurrentFloor());
    }

    @Test
    public void getPositionTest()
    {
        Assert.assertEquals(Vector2.Zero, Player.getInstance().getPosition());

        Vector2 v = new Vector2(2, 3);
        Player.getInstance().setPosition(v);
        Assert.assertEquals(v, Player.getInstance().getPosition());
        Assert.assertEquals(2, Player.getInstance().getPosition().getX());
        Assert.assertEquals(3, Player.getInstance().getPosition().getY());
    }

    @Test
    public void moveTest()
    {
        // No floor
        Assert.assertFalse(Player.getInstance().move(Direction.Up));
        Assert.assertEquals(Vector2.Zero, Player.getInstance().getPosition());
        Assert.assertFalse(Player.getInstance().move(Direction.Down));
        Assert.assertEquals(Vector2.Zero, Player.getInstance().getPosition());
        Assert.assertFalse(Player.getInstance().move(Direction.Left));
        Assert.assertEquals(Vector2.Zero, Player.getInstance().getPosition());
        Assert.assertFalse(Player.getInstance().move(Direction.Right));
        Assert.assertEquals(Vector2.Zero, Player.getInstance().getPosition());

        // Floor of size 0
        Floor f = new Floor();
        f.setSize(new Size(0, 0));
        Player.getInstance().setCurrentFloor(f);
        Assert.assertFalse(Player.getInstance().move(Direction.Up));
        Assert.assertEquals(Vector2.Zero, Player.getInstance().getPosition());
        Assert.assertFalse(Player.getInstance().move(Direction.Down));
        Assert.assertEquals(Vector2.Zero, Player.getInstance().getPosition());
        Assert.assertFalse(Player.getInstance().move(Direction.Left));
        Assert.assertEquals(Vector2.Zero, Player.getInstance().getPosition());
        Assert.assertFalse(Player.getInstance().move(Direction.Right));
        Assert.assertEquals(Vector2.Zero, Player.getInstance().getPosition());

        // Boundaries
        f.setSize(new Size(1, 1));
        Assert.assertFalse(Player.getInstance().move(Direction.Up));
        Assert.assertEquals(Vector2.Zero, Player.getInstance().getPosition());
        Assert.assertFalse(Player.getInstance().move(Direction.Down));
        Assert.assertEquals(Vector2.Zero, Player.getInstance().getPosition());
        Assert.assertFalse(Player.getInstance().move(Direction.Left));
        Assert.assertEquals(Vector2.Zero, Player.getInstance().getPosition());
        Assert.assertFalse(Player.getInstance().move(Direction.Right));
        Assert.assertEquals(Vector2.Zero, Player.getInstance().getPosition());

        ///// NORMAL MOVE ///////
        f.setSize(new Size(2,2));
        // The player is in the top-left corner
        Assert.assertFalse(Player.getInstance().move(Direction.Up));
        Assert.assertFalse(Player.getInstance().move(Direction.Left));
        Assert.assertTrue(Player.getInstance().move(Direction.Right));
        Assert.assertEquals(1, Player.getInstance().getPosition().getX());
        Assert.assertEquals(0, Player.getInstance().getPosition().getY());
        // The player is in the top-right corner
        Assert.assertFalse(Player.getInstance().move(Direction.Up));
        Assert.assertFalse(Player.getInstance().move(Direction.Right));
        Assert.assertTrue(Player.getInstance().move(Direction.Down));
        Assert.assertEquals(1, Player.getInstance().getPosition().getX());
        Assert.assertEquals(1, Player.getInstance().getPosition().getY());
        // The player is in the bottom-right corner
        Assert.assertFalse(Player.getInstance().move(Direction.Down));
        Assert.assertFalse(Player.getInstance().move(Direction.Right));
        Assert.assertTrue(Player.getInstance().move(Direction.Left));
        Assert.assertEquals(0, Player.getInstance().getPosition().getX());
        Assert.assertEquals(1, Player.getInstance().getPosition().getY());
        // The player is in the bottom-left corner
        Assert.assertFalse(Player.getInstance().move(Direction.Down));
        Assert.assertFalse(Player.getInstance().move(Direction.Left));
        Assert.assertTrue(Player.getInstance().move(Direction.Up));
        Assert.assertEquals(0, Player.getInstance().getPosition().getX());
        Assert.assertEquals(0, Player.getInstance().getPosition().getY());
    }
}