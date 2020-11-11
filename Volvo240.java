import java.awt.*;

/**
 *special type of car,subclass of Car
 */
public class Volvo240 extends Car{
    /**
     * Trim factor affects acceleration
     */
    private final static double trimFactor = 1.25;

    
    public Volvo240(){
        setNrDoors(4);
        setColor(Color.black);
        setEnginePower(100);
        setModelName("Volvo240");
        stopEngine();
    }
    /**
     *
     * @return  maximum increase in speed per unit of time
     */
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }
}
