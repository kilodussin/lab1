package src;
import java.awt.*;
public class Saab95 extends Car {
    private boolean turboOn;
    public Saab95(){
        direction = 0;
        xCoordinate = 0;
        yCoordinate = 0;
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        turboOn = false;
        modelName = "Saab95";
        stopEngine();
    }
    public String getModelName() {
        return modelName;
    }

    public void setTurboOn(){
        turboOn = true;
    }
    public void setTurboOff(){
        turboOn = false;
    }
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
 }

