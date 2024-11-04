package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[68];

        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        InputStream mapFileStream = getClass().getResourceAsStream("/maps/Map_ZahlenMatrix.txt");
        if (mapFileStream == null) {
            System.err.println("Map file not found in resources.");
        } else {
            loadMap(mapFileStream);
        }
    }

    public void getTileImage() {

        // Load Tile images
        try {

            // Assign Tile images to an Array
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/1_Busch.png"));
            tile[0].collision = true;

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/2_Stein.Klein.png"));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/3_Baum.Gruen.png"));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/4_Fels.OL.png"));
            tile[3].collision = true;

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/5_Feld.OR.png"));
            tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/6_Bogen.OL.png"));
            tile[5].collision = true;

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/7_Bogen.OM.png"));
            tile[6].collision = true;

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/8_Bogen.OR.png"));
            tile[7].collision = true;

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/9_Fels.UL.png"));
            tile[8].collision = true;

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/10_Fels.UR.png"));
            tile[9].collision = true;

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/11_Stein.Rot.png"));
            tile[10].collision = true;

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/12_Baum.Orange.png"));
            tile[11].collision = true;

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/13_Gras.png"));

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/14_Grabstein.png"));
            tile[13].collision = true;

            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/tiles/15_Stein.Dunkel.png"));

            tile[15] = new Tile();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/tiles/16_Stein.Hell.png"));

            tile[16] = new Tile();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/tiles/17_Leiter.png"));

            tile[17] = new Tile();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("/tiles/18_Cobble.png"));

            tile[18] = new Tile();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("/tiles/19_Stein.Gross.png"));
            tile[18].collision = true;

            tile[19] = new Tile();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("/tiles/20_SteinWand.Hell.png"));
            tile[19].collision = true;

            tile[20] = new Tile();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("/tiles/21_SteinWand.Dunkel.png"));
            tile[20].collision = true;

            tile[21] = new Tile();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream("/tiles/22_Treppe.png"));

            tile[22] = new Tile();
            tile[22].image = ImageIO.read(getClass().getResourceAsStream("/tiles/23_Fels.Cave.OL.png"));
            tile[22].collision = true;

            tile[23] = new Tile();
            tile[23].image = ImageIO.read(getClass().getResourceAsStream("/tiles/24_Fels.Cave.OR.png"));
            tile[23].collision = true;

            tile[24] = new Tile();
            tile[24].image = ImageIO.read(getClass().getResourceAsStream("/tiles/25_Fels.Cave.UL.png"));
            tile[24].collision = true;

            tile[25] = new Tile();
            tile[25].image = ImageIO.read(getClass().getResourceAsStream("/tiles/26_Fels.Cave.UR.png"));
            tile[25].collision = true;

            tile[26] = new Tile();
            tile[26].image = ImageIO.read(getClass().getResourceAsStream("/tiles/27_Stein.Klein.Cave.png"));
            tile[26].collision = true;

            tile[27] = new Tile();
            tile[27].image = ImageIO.read(getClass().getResourceAsStream("/tiles/28_Tuer.Cave.L.png"));
            tile[27].collision = true;

            tile[28] = new Tile();
            tile[28].image = ImageIO.read(getClass().getResourceAsStream("/tiles/29_Tuer.Cave.R.png"));
            tile[28].collision = true;

            tile[29] = new Tile();
            tile[29].image = ImageIO.read(getClass().getResourceAsStream("/tiles/30_Stein.Klein.Blau.png"));
            tile[29].collision = true;

            tile[30] = new Tile();
            tile[30].image = ImageIO.read(getClass().getResourceAsStream("/tiles/31_Stein.Klein.Gelb.png"));
            tile[30].collision = true;

            tile[31] = new Tile();
            tile[31].image = ImageIO.read(getClass().getResourceAsStream("/tiles/32_Chest.Schloss.Front.png"));
            tile[31].collision = true;

            tile[32] = new Tile();
            tile[32].image = ImageIO.read(getClass().getResourceAsStream("/tiles/33_Boden.Schloss.png"));

            tile[33] = new Tile();
            tile[33].image = ImageIO.read(getClass().getResourceAsStream("/tiles/34_Wand.Schloss.png"));
            tile[33].collision = true;

            tile[34] = new Tile();
            tile[34].image = ImageIO.read(getClass().getResourceAsStream("/tiles/35_Teppich.png"));

            tile[35] = new Tile();
            tile[35].image = ImageIO.read(getClass().getResourceAsStream("/tiles/36_Chest.Schloss.Back.png"));
            tile[35].collision = true;

            tile[36] = new Tile();
            tile[36].image = ImageIO.read(getClass().getResourceAsStream("/tiles/37_Flaschen.png"));
            tile[36].collision = true;

            tile[37] = new Tile();
            tile[37].image = ImageIO.read(getClass().getResourceAsStream("/tiles/38_Box.Klein.png"));
            tile[37].collision = true;

            tile[38] = new Tile();
            tile[38].image = ImageIO.read(getClass().getResourceAsStream("/tiles/39_Vase.png"));
            tile[38].collision = true;

            tile[39] = new Tile();
            tile[39].image = ImageIO.read(getClass().getResourceAsStream("/tiles/40_BogenML.png"));
            tile[39].collision = true;

            tile[40] = new Tile();
            tile[40].image = ImageIO.read(getClass().getResourceAsStream("/tiles/41_Bogen.MM.png"));
            tile[40].collision = true;

            tile[41] = new Tile();
            tile[41].image = ImageIO.read(getClass().getResourceAsStream("/tiles/42_Bogen.MR.png"));
            tile[41].collision = true;

            tile[42] = new Tile();
            tile[42].image = ImageIO.read(getClass().getResourceAsStream("/tiles/43_Bogen.UL.png"));
            tile[42].collision = true;

            tile[43] = new Tile();
            tile[43].image = ImageIO.read(getClass().getResourceAsStream("/tiles/45_Bogen.UR.png"));
            tile[43].collision = true;

            tile[44] = new Tile();
            tile[44].image = ImageIO.read(getClass().getResourceAsStream("/tiles/46_Banner.png"));
            tile[44].collision = true;

            tile[45] = new Tile();
            tile[45].image = ImageIO.read(getClass().getResourceAsStream("/tiles/47_Fackel.Front.png"));
            tile[45].collision = true;

            tile[46] = new Tile();
            tile[46].image = ImageIO.read(getClass().getResourceAsStream("/tiles/48_Box.Mittel.U.png"));
            tile[46].collision = true;

            tile[47] = new Tile();
            tile[47].image = ImageIO.read(getClass().getResourceAsStream("/tiles/49_Box.Mittel.O.png"));
            tile[47].collision = true;

            tile[48] = new Tile();
            tile[48].image = ImageIO.read(getClass().getResourceAsStream("/tiles/50_Wand.Schloss.Hell.png"));
            tile[48].collision = true;

            tile[49] = new Tile();
            tile[49].image = ImageIO.read(getClass().getResourceAsStream("/tiles/51_Box.Gross.OL.png"));
            tile[49].collision = true;

            tile[50] = new Tile();
            tile[50].image = ImageIO.read(getClass().getResourceAsStream("/tiles/52_Box.Gross.OM.png"));
            tile[50].collision = true;

            tile[51] = new Tile();
            tile[51].image = ImageIO.read(getClass().getResourceAsStream("/tiles/53_Box.Gross.OR.png"));
            tile[51].collision = true;

            tile[52] = new Tile();
            tile[52].image = ImageIO.read(getClass().getResourceAsStream("/tiles/54_Box.Gross.UL.png"));
            tile[52].collision = true;

            tile[53] = new Tile();
            tile[53].image = ImageIO.read(getClass().getResourceAsStream("/tiles/55_Box.Gross.UM.png"));
            tile[53].collision = true;

            tile[54] = new Tile();
            tile[54].image = ImageIO.read(getClass().getResourceAsStream("/tiles/56_Box.Gross.UR.png"));
            tile[54].collision = true;

            tile[55] = new Tile();
            tile[55].image = ImageIO.read(getClass().getResourceAsStream("/tiles/57_Fackel.Rechts.png"));
            tile[55].collision = true;

            tile[56] = new Tile();
            tile[56].image = ImageIO.read(getClass().getResourceAsStream("/tiles/58_Lapis.png"));

            tile[57] = new Tile();
            tile[57].image = ImageIO.read(getClass().getResourceAsStream("/tiles/59_Stein.Klein.Schwarz.png"));
            tile[57].collision = true;

            tile[58] = new Tile();
            tile[58].image = ImageIO.read(getClass().getResourceAsStream("/tiles/60_Stein.Cave.Gross.png"));
            tile[58].collision = true;

            tile[59] = new Tile();
            tile[59].image = ImageIO.read(getClass().getResourceAsStream("/tiles/61_Diamant.png"));

            tile[60] = new Tile();
            tile[60].image = ImageIO.read(getClass().getResourceAsStream("/tiles/62_Kalzit.png"));

            tile[61] = new Tile();
            tile[61].image = ImageIO.read(getClass().getResourceAsStream("/tiles/63_Path.Hell.png"));

            tile[62] = new Tile();
            tile[62].image = ImageIO.read(getClass().getResourceAsStream("/tiles/64_Path.Dunkel.png"));

            tile[63] = new Tile();
            tile[63].image = ImageIO.read(getClass().getResourceAsStream("/tiles/65_Bogen.Kaputt.OL.png"));
            tile[63].collision = true;

            tile[64] = new Tile();
            tile[64].image = ImageIO.read(getClass().getResourceAsStream("/tiles/66_Bogen.Kaputt.OM.png"));
            tile[64].collision = true;

            tile[65] = new Tile();
            tile[65].image = ImageIO.read(getClass().getResourceAsStream("/tiles/67_Bogen.Kaputt.OR.png"));
            tile[65].collision = true;

            tile[66] = new Tile();
            tile[66].image = ImageIO.read(getClass().getResourceAsStream("/tiles/68_Bogen.Kaputt.UL.png"));
            tile[66].collision = true;

            tile[67] = new Tile();
            tile[67].image = ImageIO.read(getClass().getResourceAsStream("/tiles/70_Bogen.Kaputt.UR.png"));
            tile[67].collision = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(InputStream mapFilePath) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(mapFilePath))) {
            String line;
            int row = 0;

            System.out.println("Reading map file:");

            while ((line = br.readLine()) != null && row < gp.maxWorldRow) {
                String[] numbers = line.split(" ");
                for (int col = 0; col < numbers.length && col < gp.maxWorldCol; col++) {
                    try {
                        mapTileNum[col][row] = Integer.parseInt(numbers[col]);
                        // Debugging: Confirm tile assignment to mapTileNum array
                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing tile number at (" + col + ", " + row + "): " + numbers[col]);
                    }
                }
                row++;
            }
        } catch (IOException e) {
            System.err.println("Error reading map file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {

        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                    worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                    worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                    worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
                if (tileNum >= 0 && tileNum < tile.length && tile[tileNum] != null) {
                    g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
                } else {
                    System.err.println("Tile number " + tileNum + " is invalid or null at position (" + worldCol + ", " + worldRow + ")");
                }
            }
            worldCol++;

            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }

    }
}