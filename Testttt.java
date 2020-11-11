
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.awt.*;

import static org.junit.Assert.*;
@RunWith(JUnit4.class)
public class Testttt {
    @Before
    public void setup(){
        v1.stopEngine();
        s1.stopEngine();
    }
    @After
    public void teardown(){
        v1.move();
        s1.move();
        System.out.println("xposv: "+v1.getXPos()+" yposv: "+v1.getYPos());
    }
    Volvo240 v1 = new Volvo240(); // MyClass is tested
    Saab95 s1 = new Saab95();
    @Test
    public void testBrake() {
        v1.brake(1);
        s1.brake(1);
        assertEquals(0, v1.getCurrentSpeed(), 0);
        assertEquals(0, s1.getCurrentSpeed(), 0);
        boolean error = false;
        try {
            v1.brake(2);
        } catch (IllegalArgumentException e) {
            error = true; }
        assertTrue(error);}
    @Test
    public void testGas() {
        v1.gas(1);
        s1.gas(1);
        assertEquals(1.25, v1.getCurrentSpeed(), 0);
        assertEquals(1.25, s1.getCurrentSpeed(), 0);
        boolean error = false;
        try {
            v1.gas(2);
        } catch (IllegalArgumentException e) {
            error = true;}
        assertTrue(error);
    }
    @Test
    public void testStartEngine(){
        v1.startEngine();
        s1.startEngine();
        assertEquals(0.1, v1.getCurrentSpeed(), 0);
        assertEquals(0.1, s1.getCurrentSpeed(), 0);
    }
    @Test
    public void testStopEngine(){
        s1.startEngine();
        v1.startEngine();
        v1.stopEngine();
        s1.stopEngine();
        assertEquals(0, v1.getCurrentSpeed(), 0);
        assertEquals(0, s1.getCurrentSpeed(), 0);
    }
    @Test
    public void testTurns(){
        v1.gas(1);
        s1.gas(1);
        v1.turnLeft();
        s1.turnLeft();
        v1.move();
        s1.move();
        assertEquals(v1.getCurrentSpeed(),v1.getYPos(), 0.01);
        assertEquals(s1.getCurrentSpeed(), s1.getYPos(),0.01);
        assertEquals(0,v1.getXPos(), 0.01);
        assertEquals(0, s1.getXPos(),0.01);

        s1.turnRight();
        v1.turnRight();
        s1.move();
        v1.move();
        assertEquals(v1.getCurrentSpeed(),v1.getYPos(), 0.01);
        assertEquals(s1.getCurrentSpeed(), s1.getYPos(),0.01);
        assertEquals(v1.getCurrentSpeed(),v1.getXPos(), 0.01);
        assertEquals(s1.getCurrentSpeed(), s1.getXPos(),0.01);
    }
    @Test
    public void testGet() {
        assertEquals(Color.black,v1.getColor());
        assertEquals(2,s1.getNrDoors());
    }





}
