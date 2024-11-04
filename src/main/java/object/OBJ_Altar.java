package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Altar extends SuperObject{
    public OBJ_Altar() {
        name = "Altar";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Altar.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
