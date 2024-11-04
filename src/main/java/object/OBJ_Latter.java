package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Latter extends SuperObject{
    GamePanel gp;
    public OBJ_Latter(GamePanel gp) {

        this.gp = gp;
        name = "Latter";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Gras_Leiter.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
