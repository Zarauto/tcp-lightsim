package test.simobjects.lightbeam;

import static core.utils.Geometry.getAngle;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.raylib.java.Raylib;
import com.raylib.java.core.Color;
import com.raylib.java.raymath.Vector2;

import core.UI.UIElement;
import core.simobjects.ObjectToRender;
import core.simobjects.lightbeam.*;
import core.simscreens.descriptors.SimulationScreen;

public class LightBeamTest {
    
    private static SimulationScreen simulationScreen = new SimulationScreen(600, 400, 100, 100, null);
    private static Raylib rlj = UIElement.rlj;

    @Test
    public void findImagePointTest() {
        LightBeam beam1 = new LightBeam(new Vector2(200, 100)); 
        beam1.addSegment(new Vector2(400, 100));
        beam1.addSegment(getAngle(new Vector2(400, 100), new Vector2(600, 300)));

        LightBeam beam2 = new LightBeam(new Vector2(200, 100)); 
        beam2.addSegment(getAngle(new Vector2(200, 100), new Vector2(400, 150)));

        LightBeam beam3 = new LightBeam(new Vector2(300, 50));
        beam3.addSegment(270);

        assertEquals(466.667, LightBeam.findImagePoint(beam1, beam2).x, 0.01);
        assertEquals(166.667, LightBeam.findImagePoint(beam1, beam2).y, 0.01);
        assertEquals(null, LightBeam.findImagePoint(beam1, beam3));
        assertEquals(300, LightBeam.findImagePoint(beam2, beam3).x, 0.01);
        assertEquals(125, LightBeam.findImagePoint(beam2, beam3).y, 0.01);
    }

    public static void main(String[] args) {
        ObjectToRender.setSimulationScreen(simulationScreen);

        LightBeam beam1 = new LightBeam(new Vector2(200, 100)); 
        beam1.addSegment(new Vector2(400, 100));
        beam1.addSegment(getAngle(new Vector2(400, 100), new Vector2(600, 300)));

        LightBeam beam2 = new LightBeam(new Vector2(200, 100)); 
        beam2.addSegment(getAngle(new Vector2(200, 100), new Vector2(400, 150)));

        while(!rlj.core.WindowShouldClose()){
            rlj.core.BeginDrawing();
            rlj.core.ClearBackground(Color.BLUE);
            rlj.shapes.DrawRectangleLines(simulationScreen.getBegX(), simulationScreen.getBegY(), simulationScreen.getWidth(), simulationScreen.getHeight(), Color.RAYWHITE);
            beam1.render();
            beam2.render();
            Vector2 intersectionPoint = LightBeam.findImagePoint(beam1, beam2);
            if(intersectionPoint != null) {
                rlj.shapes.DrawCircle(simulationScreen.getBegX()+(int)intersectionPoint.x, 
                                      simulationScreen.getBegY()+(int)intersectionPoint.y, 3, Color.RED);
            }
            rlj.core.EndDrawing();
        }

    }

}
