package userInterface;

import java.util.ArrayList;
import objects.*;

public class SimulationScreen extends Screen {
    
    private final int AXIS_HEIGHT = super.getHeight()/2;
    ArrayList<ObjectToRender> objectsToRender;

    public SimulationScreen(int width, int height, int begX, int begY, ArrayList<ObjectToRender> objectToRenders) {
        super(width, height, begX, begY);
        this.objectsToRender = objectToRenders;
    }

    public void renderObjects() {

    }

    public void render() {

    }

}