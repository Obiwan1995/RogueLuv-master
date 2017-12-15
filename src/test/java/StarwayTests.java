import org.junit.*;
import rogueluv.model.Starway;

public class StarwayTests
{
    @Test
    public void initTest()
    {
        Starway starway = new Starway();
        Assert.assertEquals(0, starway.countGold());
        Assert.assertEquals(0, starway.countMonster());
        Assert.assertEquals('O', starway.getSymbol());
    }
}
