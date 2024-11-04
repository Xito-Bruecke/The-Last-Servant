package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Ring extends SuperObject{
    public OBJ_Ring() {
        name = "Ring";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Ring.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
