package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Chest extends SuperObject{
    GamePanel gp;
    public OBJ_Chest(GamePanel gp) {

        this.gp = gp;
        name = "Chest";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/32_Chest.Schloss.Front.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
