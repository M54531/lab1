import java.awt.*;

/**
 * special type of car,subclass of Car
 */
public class Saab95 extends Car{
    /**
     * boolean variable true if saab95 has turbo
     * affects acceleration
     */
    private final boolean turboOn;
    
    public Saab95(){
        setNrDoors(2);

        setColor(Color.red);
        setEnginePower(125);
	    turboOn = false;
        setModelName("Saab95");
        stopEngine();
    }

    /**
     *
     * @return  maximum increase in speed per unit of time
     */
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
