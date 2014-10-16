package sergei.training.actimind;

import java.util.concurrent.Semaphore;
import java.util.logging.FileHandler;

public class Tractor{
    public int x;
    public int y;
    public Field f;
    public Tractor(int tx,int ty, Field tf){
        x = tx;
        y = ty;
        f = tf;
    }
    /**
     *
     */
    public void plow() {
        if(x < f.Ground[y].length-1) {
            if (Fuel.enoughFuel) {
                int need = 0;
                if (f.getType(y, x + 1) == Field.GroundType.EASY) {
                      need = Fuel.G;
                } else {
                      need = Fuel.G * Fuel.K;
                }
                if (Fuel.count - need > 0) {
                      Fuel.count -= need;
                      x++;
                } else {
                      Fuel.enoughFuel = false;
                }
                }
            }
    }
}
