package object;

import main.GamePanel;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.swing.text.Utilities;
import java.io.IOException;

public class OBJ_Heart extends SuperObject{

    GamePanel gp;

    public OBJ_Heart(GamePanel gp){
        this.gp = gp;

        name = "Heart";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Heart.Full.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/objects/Heart.Half.png"));
            image3 = ImageIO.read(getClass().getResourceAsStream("/objects/Heart.Empty.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
