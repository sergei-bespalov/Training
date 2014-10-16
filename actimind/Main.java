package sergei.training.actimind;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Main {
    public static int steps = 0;

    public static void main(String[] args){
        int[][] scheme = randomScheme();
        //System.out.println(showScheme(scheme));
        Field field = new Field(scheme);
        int fuel = Integer.parseInt(args[0]);
        Fuel.Fuel = fuel;
        Fuel.count = fuel;
        Fuel.G = Integer.parseInt(args[1]);
        Fuel.K = Integer.parseInt(args[2]);
        steps = plow(field);
        System.out.println(Report());
    }
    /**
     *
     * @return random field scheme
     */
    public static int[][] randomScheme(){
        Random rnd = new Random();
        int[][] scheme;
        scheme = new int[rnd.nextInt(20)][];
        while (scheme.length == 0){
            scheme = new int[rnd.nextInt(20)][];
        }
        for (int y = 0; y < scheme.length; y++){
            scheme[y] = new int[rnd.nextInt(20)];
            while (scheme[y].length == 0){
                scheme[y] = new int[rnd.nextInt(20)];
            }
            for (int x = 0; x < scheme[y].length; x++){
                scheme[y][x] = rnd.nextInt(10);
            while (scheme[y][x] == 0){
                scheme[y][x] = rnd.nextInt(10);
            }
            }
        }
        return scheme;
    }
    /**
     *
     * @param scheme field scheme
     * @return the line containing scheme
     */
    public static String showScheme (int[][] scheme){
        StringBuffer result = new StringBuffer();
        for(int[] y: scheme){
            for(int x: y){
                result.append(x+"\t");
            }
        result.append("\n");
        }
        return  result.toString();
    }
    /**
     *
     * @param field
     * @return
     */
   public static int plow(Field field){
       Field.GroundType[][] ground = field.getGround();
       Semaphore sem = new Semaphore(1);
       Tractor[] tractors = new Tractor[ground.length];
       for (int i = 0; i < ground.length ; i++){
           tractors[i] = new Tractor(0,i,field);
       }
       int step;
       for (step = 0; step < field.GroundMaxLength();step++) {
           for (int i = 0; i < ground.length; i++) {
               tractors[i].plow();
               }
           if (!Fuel.enoughFuel) break;
       }
       return step;
   }
    /**
     *
     */
    public static String Report(){
        StringBuffer report = new StringBuffer();
        report.append("Количество шагов: " + steps + "\n");
        report.append("Топлива осталось: " +Fuel.count+"/"+Fuel.Fuel+"\n");
        return  report.toString();
    }
}
