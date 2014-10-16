package sergei.training.actimind;

public class Field {
    public enum GroundType {EASY, HARD}
    public GroundType[][] Ground;
    public int  GroundMaxLength = 0;

    /**
     *
     * @param scheme field scheme
     */
    public Field(int[][] scheme){
        Ground = new GroundType[scheme.length][];
        for (int y = 0; y < Ground.length; y++){
            Ground[y] = new GroundType[getStripSize(scheme[y])];
            int last = 0;
            for (int x = 0; x < scheme[y].length; x++){
                int count = scheme[y][x];
                if (x%2 == 0){
                    while (count > 0){
                        Ground[y][last] = GroundType.EASY;
                        last++;
                        count--;
                    }
                }
                else{
                    while (count > 0){
                        Ground[y][last] = GroundType.HARD;
                        last++;
                        count--;
                    }
                }
            }
        }
    }

    /**
     *
     * @param scheme field scheme
     * @return field size
     */
    private int getStripSize(int[] scheme){
        int size = 0;
        for (int i = 0; i < scheme.length; i++){
            size += scheme[i];
        }
        if (size > GroundMaxLength) GroundMaxLength = size;
        return size;
    }

    /**
     *
     * @param y
     * @param x
     * @return ground type
     */
    public GroundType getType(int y, int x){
        return Ground[y][x];
    }
    /**
     *
     */
    public GroundType[][] getGround(){
        return Ground;
    }
    /**
     *
     */
    public int GroundMaxLength(){
        return  GroundMaxLength;
    }
}
