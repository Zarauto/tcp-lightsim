package userInterface;

import objects.ObjectToRender;

public class StatsScreen extends Screen {
    
        // Atributos
    private ObjectToRender objectSelected;
    private boolean displaySimulationStats;

    public StatsScreen(int width, int height, int begX, int begY) {
        super(width, height, begX, begY);
        displaySimulationStats = true;
    }

    void setObjectSelected(ObjectToRender objectSelected) {
        
    }

    void updateParameters() {
        // Atualiza os parâmetros do objectSelected
    }

    public void render() {

    }

}