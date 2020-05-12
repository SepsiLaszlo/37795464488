public class GHole extends GIceTable{
    private Hole hole;

    public GHole(Hole hole) {
        super(null);
       this.hole=hole;
    }


    @Override
    public IceTable getIceTable() {
        return hole;
    }
}
