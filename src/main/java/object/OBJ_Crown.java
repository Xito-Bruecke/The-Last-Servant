package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Crown extends SuperObject{
    public OBJ_Crown() {
        name = "Crown";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Crown.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
