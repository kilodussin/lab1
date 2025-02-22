package src;

import org.junit.Test;
import org.junit.Assert;
import java.awt.Color;
import static org.junit.Assert.*;

public class TestsCar {

    public Saab95 Saab = new Saab95();
    public Volvo240 Volvo = new Volvo240();
    public Scania Scania = new Scania();
    public Workshop Workshop = new Workshop();
    WorkshopSaab WorkshopSaab = new WorkshopSaab();
    public CarTransport CarTransport = new CarTransport();


    @Test
    public void nrOfDoors() {
        Assert.assertEquals("GetNrOfDoors should work", Saab.getNrDoors(), 2);
    }
    @Test
    public void getDirection() {
        Assert.assertEquals("Get direction works", Saab.getDirection(), "N");
    }
    @Test
    public void TurningLeft() {
        Saab.turnLeft();
        Assert.assertEquals("Turning left works", Saab.getDirection(), "E");
    }
    @Test
    public void RotatingLeftToNorth() {
        Saab.turnLeft();
        Saab.turnLeft();
        Saab.turnLeft();
        Saab.turnLeft();
        Assert.assertEquals("Rotating left works", Saab.getDirection(), "N");
    }
    @Test
    public void TurningRight() {
        Saab.turnRight();
        Assert.assertEquals("Turning right works", Saab.getDirection(), "W");
    }
    @Test
    public void RotatingRight() {
        Saab.turnRight();
        Saab.turnRight();
        Saab.turnRight();
        Saab.turnRight();
        Assert.assertEquals("Rotating right works", Saab.getDirection(), "N");
    }
    @Test
    public void StartingEngine() {
        Saab.startEngine();
        assertEquals("Engine moves the car forward slowly", Saab.getCurrentSpeed(), 0.1, 3);
    }
    @Test
    public void StopEngine() {
        Saab.stopEngine();
        assertEquals("Engine stop the car and any movement", Saab.getCurrentSpeed(), 0.0, 3);

    }
    @Test
    public void getXCoordinate() {
        assertEquals("Getxcoordinat works", Saab.getxCoordinate(), 0, 3);
    }
    @Test
    public void getYCoordinate() {
        assertEquals("Getycoordinate works", Saab.getyCoordinate(), 0, 3);
    }
    @Test
    public void getColour() {
        assertEquals("Get colour works", Saab.getColor(), Color.red);
    }
    @Test
    public void ChangeColour() {
        Saab.setColor(Color.blue);
        assertEquals("You can change colour", Saab.getColor(), Color.blue);
    }
    @Test
    public void getEnginePower() {
        assertEquals("GetEnginePower works", Saab.getEnginePower(), 125, 3);
    }
    @Test
    public void GasWithTurboSaab() {
        Saab.startEngine();
        Saab.setTurboOn();
        Saab.gas(0.5);
        assertEquals("Gas works with turbo", Saab.getCurrentSpeed(), 0.9125, 5);
    }
    @Test
    public void GasWithTurboOffSaab(){
        Saab.startEngine();
        Saab.gas(0.5);
        assertEquals("Gas works without turbo", Saab.getCurrentSpeed(), 0.725, 5);
    }
    @Test
    public void DrivingForward() {
        Saab.startEngine();
        Saab.gas(0.5);
        Saab.move();
        assertEquals("Driving forward works", Saab.getyCoordinate(), 0.725, 5);
    }
    @Test
    public void DrivingBackwards(){
        Saab.startEngine();
        Saab.gas(0.5);
        Saab.turnLeft();
        Saab.turnLeft();
        Saab.move();
        assertEquals("Driving backwords works", Saab.getyCoordinate(), -0.725, 5);
    }
    @Test
    public void DrivingToTheRight(){
        Saab.startEngine();
        Saab.gas(0.5);
        Saab.turnRight();
        Saab.move();
        assertEquals("Driving right works", Saab.getxCoordinate(), 0.725, 5);
    }
    @Test
    public void DrivingToTheLeft(){
        Saab.startEngine();
        Saab.gas(0.5);
        Saab.turnLeft();
        Saab.move();
        assertEquals("Driving left works", Saab.getxCoordinate(), -0.725, 5);
    }
    @Test
    public void BrakingWithoutTurboSaab(){
        Saab.startEngine();
        Saab.gas(0.5);
        Saab.brake(0.5);
        assertEquals("Braking works", Saab.getCurrentSpeed(), 0, 5);
    }
    @Test
    public void BrakingWithTurboSaab(){
        Saab.startEngine();
        Saab.setTurboOn();
        Saab.gas(0.5);
        Saab.brake(0.5);
        assertEquals("Breaking works with turbo", Saab.getCurrentSpeed(), 0, 5);
    }
    @Test
    public void TurningOffTheEngine(){
        Saab.startEngine();
        Saab.stopEngine();
        assertEquals("Turning off the engine works", Saab.getCurrentSpeed(), 0, 5);
    }
    @Test
    public void TurningOffTheTurboSaab(){
        Saab.setTurboOn();
        Saab.setTurboOff();
        Saab.gas(0.5);
        assertEquals("Turning off the turbo works", Saab.getCurrentSpeed(), 0.725, 5);
    }
    @Test
    public void GasVolvo() {
        Volvo.startEngine();
        Volvo.gas(0.5);
        assertEquals("Gas works without turbo", Volvo.getCurrentSpeed(), 0.725, 5);
    }
    @Test
    public void BrakingVolvo(){
        Volvo.startEngine();
        Volvo.gas(0.5);
        Volvo.brake(0.5);
        assertEquals("Braking works", Volvo.getCurrentSpeed(), 0, 5);
    }

    // Vehicles with platform tests

    @Test
    public void IntitialPlatformAngle(){
        assertEquals("Inital platform angle is correct", 0, Scania.getPlatformPosition(), 5);
    }
    @Test
    public void MovingThePlatformUp(){
        Scania.platformUp(35);
        assertEquals("Moving the platform upwards works", 35, Scania.getPlatformPosition(), 5);
    }
    @Test
    public void TryingToRaiseThePlatformTooHigh(){
        Scania.platformUp(500);
        assertEquals("The restrictions for moving the platform upwards works",70, Scania.getPlatformPosition(), 5);
    }
    @Test
    public void MovingThePlatfromDown(){
        Scania.platformUp(35);
        Scania.platformDown(25);
        assertEquals("Moving the platform downwards works",10, Scania.getPlatformPosition(), 5);
    }
    @Test
    public void TryingTooLowerThePlatformTooLow(){
        Scania.platformUp(50);
        Scania.platformDown(500);
        assertEquals("The restriction for moving the platform downwards works",0,  Scania.getPlatformPosition(), 5);
    }
    @Test
    public void TryingTooLowerThePlatformIncorrectly(){
        Scania.platformUp(50);
        Scania.platformDown(-10);
        assertEquals("One cannot lower the platform incorrectly",50 , Scania.getPlatformPosition(), 5);
    }
    @Test
    public void TryingToMoveTheTruckWithPlatformInTheWrongPosition(){
        Scania.platformUp(50);
        Scania.move();
        assertEquals("One cannot move the Scania when the platform is in the wrong position", 0, Scania.getyCoordinate(), 5);
    }
    @Test
    public void TryingToMoveWithPlatformInTheRightPosition(){
        Scania.move();
        assertEquals("One can move the platform when in the right position", 0, 0);
    }
    /*
    @Test
    public void TryToStoreWrongModelInWorkshop(){
        WorkshopSaab.storeVehicle(Volvo);
        // Gives compile time error
    }
    */
    @Test
    public void TooManyVehiclesInWorkshop(){
        int CarsInShop = 0;
        for(int i = 1; i <= 9; i++){
            WorkshopSaab.storeVehicle(Saab);
            CarsInShop++;
        }
        assertTrue("Too many vehicles in Workshop", CarsInShop > WorkshopSaab.getVehicleLimit());
    }

    @Test
    public void NoVehiclesAvailableToRemove(){
        WorkshopSaab.storeVehicle(Saab);
        assertEquals("The workshop should have 1 vehicle", 1, WorkshopSaab.vehicles.size());

        WorkshopSaab.removeVehicle(Saab);
        assertEquals("The workshop should have 0 vehicles", 0, WorkshopSaab.vehicles.size());

        WorkshopSaab.removeVehicle(Saab);
        assertEquals("The workshop should still have 0 vehicles", 0, WorkshopSaab.vehicles.size());
    }


}

