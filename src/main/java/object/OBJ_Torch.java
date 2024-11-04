package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Torch extends SuperObject{
    public OBJ_Torch() {
        name = "Torch";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Torch.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
