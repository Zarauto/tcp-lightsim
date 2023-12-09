package userInterface;
import com.raylib.java.core.Color;
import com.raylib.java.core.rCore;
import com.raylib.java.core.ray.Ray;
import com.raylib.java.raymath.Vector2;
import com.raylib.java.shapes.Rectangle;
import com.raylib.java.shapes.rShapes;
import com.raylib.java.textures.*;
import com.raylib.java.Raylib;
import com.raylib.java.text.rText;
import com.raylib.java.text.rText.FontType;
import com.raylib.java.text.Font;
//import com.raylib.java.Raylib;

public class Button {
    protected int begX, begY, width, height;
    protected String label;
    protected Texture2D texture;
    protected boolean isBeingPressed;
    //private static final rText txt = new rText();
    private Raylib rlj;

    protected Rectangle rect, shadow;

    final static Color MEDIUM_BLUE = new Color(0, 146, 255, 255);
    final static Color DARK_BLUE = new Color(0, 116, 203, 255);
    final static Color LIGHT_BLUE = new Color(128, 200, 255, 255);
    final static Color BG_BLUE = new Color(14, 137, 230, 255);
    final static int SHADOW_OFFSET = 5;
    final static int BORDER_OFFSET = 5;
    final static int FONT_SIZE = 30;


    public Button(int x, int y, int width, int height, String label, Raylib rlj) {
        this.begX = x;
        this.begY = y;
        this.width = width;
        this.height = height;
        this.label = label;
        this.texture = null;
        this.rlj = rlj;

        this.rect = new Rectangle(x-SHADOW_OFFSET, y-SHADOW_OFFSET, width, height);
        this.shadow = new Rectangle(x, y, width, height);
    }

    public Button(int x, int y, int width, int height, Texture2D texture, Raylib rlj) {
        this.begX = x;
        this.begY = y;
        this.width = width;
        this.height = height;
        this.texture = texture;
        this.label = null;
        this.rlj = rlj;

        this.rect = new Rectangle(x-SHADOW_OFFSET, y-SHADOW_OFFSET, width, height);
        this.shadow = new Rectangle(x, y, width, height);
    }

    public void setIsBeingPressed(boolean pressed){
        this.isBeingPressed = pressed;
    }

    public void render() {
        //new rText().DrawText("Oi", 100, 100, 30, DARK_BLUE);
        //new Raylib().text.DrawText(label, 10, 10, FONT_SIZE, DARK_BLUE);
        //Raylib rlj = new Raylib();
        //rText txt = new rText();

        // Modo idle do botão
        if(!this.isBeingPressed) {

            rShapes.DrawRectangleRec(this.shadow, DARK_BLUE);
            rShapes.DrawRectangleRec(this.rect, MEDIUM_BLUE);

            if(this.label != null){ // Escreve o texto
                int labelWidth = rlj.text.MeasureText(this.label, FONT_SIZE);
                int labelX = (int) (rect.getX()+(rect.getWidth()-labelWidth)/2);
                int labelY = (int) (rect.getY()+(rect.getHeight()-FONT_SIZE)/2);

                rlj.text.DrawText(this.label, labelX, labelY, FONT_SIZE, DARK_BLUE);                
            }

            return;
        }

        // Modo pressionado
        Rectangle pressed_rect = new Rectangle(this.begX+BORDER_OFFSET, this.begY+BORDER_OFFSET, this.width-2*BORDER_OFFSET, this.height-2*BORDER_OFFSET);
        
        rShapes.DrawRectangleRec(this.shadow, DARK_BLUE);
        rShapes.DrawRectangleRec(pressed_rect, BG_BLUE);
        
        if(this.label != null){ // Escreve o texto
            int labelWidth = rlj.text.MeasureText(this.label, FONT_SIZE);
            int labelX = (int) (pressed_rect.getX()+(pressed_rect.getWidth()-labelWidth)/2);
            int labelY = (int) (pressed_rect.getY()+(pressed_rect.getHeight()-FONT_SIZE)/2);

            rlj.text.DrawText(this.label, labelX, labelY, FONT_SIZE, DARK_BLUE);                
        }
    }

    public Rectangle getShadow(){
        return this.shadow;
    }
    
    
}