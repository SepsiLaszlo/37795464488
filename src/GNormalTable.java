public class GNormalTable extends GIceTable{
    private IceTable iceTable;

    public GNormalTable(IceTable table, GPickable gp) {
        super(gp);
        iceTable=table;
    }

    @Override
    public IceTable getIceTable() {
        return iceTable;
    }
}
