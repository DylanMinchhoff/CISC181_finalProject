import java.util.Random;
public class Obstacle extends Unit
{
    public static final char obstacleSymbol = '#';
    public Obstacle (int xCor, int yCor)
    {
        super(obstacleSymbol, "Obstacle", 0, 0, 0, 0, 0, xCor, yCor,
                0, 0, "NoTeam");
    }
    @Override
    public Unit spawn()
    {
        throw new UnsupportedOperationException ("Obstacle can't spawn other units!");
    }

    @Override
    public boolean canSpawn()
    {
        return false;
    }

    @Override
    public boolean validMovePath(int fromRow, int fromColumn, int toRow, int toColumn)
    {
        return false;
    }

    @Override
    public String toString()
    {
        return String.valueOf(symbol);
    }

    public static Obstacle generateObstacle(int numColumns, int numRows)
    {
        Random random = new Random();
        int xCor = random.nextInt(numRows);
        int yCor = random.nextInt(numColumns);
        return new Obstacle(xCor, yCor);
    }
}
