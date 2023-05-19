public class Archer extends Attacker
{
    public Archer(int xCor, int yCor, String teamColor)
    {
        super('A',
                "Archer",
                100,
                1.2,
                30,
                1.1,
                10,
                xCor,
                yCor,
                3,
                0,
                teamColor,
                0);
    }

    @Override
    public Archer spawn()
    {
        return new Archer(this.xCor, this.yCor, getTeamColor());
    }

    @Override
    public boolean canSpawn()
    {
        return true;
    }

    @Override
    public boolean validAttackPath(int fromRow, int fromCol, int toRow, int toCol)
    {
        int rowDifference = Math.abs(toRow - fromRow);
        int colDifference = Math.abs(toCol - fromCol);
        return rowDifference <= 2 && colDifference == 0;
    }
}
