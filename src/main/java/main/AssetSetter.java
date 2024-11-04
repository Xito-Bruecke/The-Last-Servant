package main;

import entity.Entity;
import entity.NPC;
import monster.MON_Bat;
import monster.MON_King;
import monster.MON_Ritter_Blau;
import monster.MON_Ritter_Gruen;
import object.*;

public class AssetSetter {

    GamePanel gp;  // Reference to the main game panel for access to tile size, object arrays, and other game elements

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    // Method to initialize and place objects in the game world
    public void setObject() {
        // Setting objects with specific world coordinates
        gp.obj[0] = new OBJ_Ring();
        gp.obj[0].worldX = 28 * gp.tileSize;
        gp.obj[0].worldY = 60 * gp.tileSize;

        gp.obj[1] = new OBJ_Crown();
        gp.obj[1].worldX = 145 * gp.tileSize;
        gp.obj[1].worldY = 12 * gp.tileSize;

        gp.obj[2] = new OBJ_Sword();
        gp.obj[2].worldX = 33 * gp.tileSize;
        gp.obj[2].worldY = 21 * gp.tileSize;

        gp.obj[3] = new OBJ_Torch();
        gp.obj[3].worldX = 14 * gp.tileSize;
        gp.obj[3].worldY = 103 * gp.tileSize;

        gp.obj[4] = new OBJ_Latter(gp);
        gp.obj[4].worldX = 45 * gp.tileSize;
        gp.obj[4].worldY = 17 * gp.tileSize;

        gp.obj[5] = new OBJ_Door();
        gp.obj[5].worldX = 107 * gp.tileSize;
        gp.obj[5].worldY = 22 * gp.tileSize;

        gp.obj[6] = new OBJ_Altar();
        gp.obj[6].worldX = 140 * gp.tileSize;
        gp.obj[6].worldY = 40 * gp.tileSize;

        gp.obj[7] = new OBJ_Chest(gp);
        gp.obj[7].worldX = 126 * gp.tileSize;
        gp.obj[7].worldY = 54 * gp.tileSize;
    }

    // Method to initialize and place NPCs in the game world
    public void setNPC() {
        gp.npc[0] = new NPC(gp); // Assign NPC instance to the first slot in the npc array
        gp.npc[0].worldX = 84 * gp.tileSize;  // Set the X coordinate of the NPC in world tiles
        gp.npc[0].worldY = 99 * gp.tileSize;  // Set the Y coordinate of the NPC in world tiles
    }

    // Method to initialize and place monsters in the game world
    public void setMonster() {
        // Setting multiple monsters of various types with specific world coordinates
        gp.monster[0] = new MON_Bat(gp);
        gp.monster[0].worldX = 72 * gp.tileSize;
        gp.monster[0].worldY = 20 * gp.tileSize;

        gp.monster[1] = new MON_Bat(gp);
        gp.monster[1].worldX = 73 * gp.tileSize;
        gp.monster[1].worldY = 20 * gp.tileSize;

        gp.monster[2] = new MON_Bat(gp);
        gp.monster[2].worldX = 71 * gp.tileSize;
        gp.monster[2].worldY = 21 * gp.tileSize;

        gp.monster[3] = new MON_Bat(gp);
        gp.monster[3].worldX = 72 * gp.tileSize;
        gp.monster[3].worldY = 19 * gp.tileSize;

        gp.monster[4] = new MON_Ritter_Blau(gp); // Different type of monster
        gp.monster[4].worldX = 138 * gp.tileSize;
        gp.monster[4].worldY = 39 * gp.tileSize;

        // Additional MON_Bat instances with varying positions
        gp.monster[5] = new MON_Bat(gp);
        gp.monster[5].worldX = 138 * gp.tileSize;
        gp.monster[5].worldY = 38 * gp.tileSize;

        gp.monster[6] = new MON_Bat(gp);
        gp.monster[6].worldX = 138 * gp.tileSize;
        gp.monster[6].worldY = 37 * gp.tileSize;

        gp.monster[7] = new MON_Bat(gp);
        gp.monster[7].worldX = 138 * gp.tileSize;
        gp.monster[7].worldY = 36 * gp.tileSize;

        gp.monster[8] = new MON_Bat(gp);
        gp.monster[8].worldX = 139 * gp.tileSize;
        gp.monster[8].worldY = 38 * gp.tileSize;

        gp.monster[9] = new MON_Bat(gp);
        gp.monster[9].worldX = 139 * gp.tileSize;
        gp.monster[9].worldY = 37 * gp.tileSize;

        gp.monster[10] = new MON_Bat(gp);
        gp.monster[10].worldX = 139 * gp.tileSize;
        gp.monster[10].worldY = 36 * gp.tileSize;

        gp.monster[11] = new MON_Ritter_Gruen(gp); // Another different monster type
        gp.monster[11].worldX = 136 * gp.tileSize;
        gp.monster[11].worldY = 58 * gp.tileSize;

        gp.monster[12] = new MON_Ritter_Gruen(gp);
        gp.monster[12].worldX = 141 * gp.tileSize;
        gp.monster[12].worldY = 58 * gp.tileSize;

        // More MON_Bat instances with assigned coordinates
        gp.monster[13] = new MON_Bat(gp);
        gp.monster[13].worldX = 136 * gp.tileSize;
        gp.monster[13].worldY = 59 * gp.tileSize;

        gp.monster[14] = new MON_Bat(gp);
        gp.monster[14].worldX = 136 * gp.tileSize;
        gp.monster[14].worldY = 60 * gp.tileSize;

        gp.monster[15] = new MON_Bat(gp);
        gp.monster[15].worldX = 136 * gp.tileSize;
        gp.monster[15].worldY = 61 * gp.tileSize;

        gp.monster[16] = new MON_Bat(gp);
        gp.monster[16].worldX = 136 * gp.tileSize;
        gp.monster[16].worldY = 62 * gp.tileSize;

        gp.monster[17] = new MON_Bat(gp);
        gp.monster[17].worldX = 141 * gp.tileSize;
        gp.monster[17].worldY = 59 * gp.tileSize;

        gp.monster[18] = new MON_Bat(gp);
        gp.monster[18].worldX = 141 * gp.tileSize;
        gp.monster[18].worldY = 60 * gp.tileSize;

        gp.monster[19] = new MON_Bat(gp);
        gp.monster[19].worldX = 141 * gp.tileSize;
        gp.monster[19].worldY = 61 * gp.tileSize;

        gp.monster[20] = new MON_Bat(gp);
        gp.monster[20].worldX = 141 * gp.tileSize;
        gp.monster[20].worldY = 62 * gp.tileSize;

        gp.monster[21] = new MON_King(gp); // Special monster type
        gp.monster[21].worldX = 119 * gp.tileSize;
        gp.monster[21].worldY = 100 * gp.tileSize;

        // Additional MON_Bat instances positioned around the MON_King
        gp.monster[22] = new MON_Bat(gp);
        gp.monster[22].worldX = 120 * gp.tileSize;
        gp.monster[22].worldY = 100 * gp.tileSize;

        gp.monster[23] = new MON_Bat(gp);
        gp.monster[23].worldX = 118 * gp.tileSize;
        gp.monster[23].worldY = 100 * gp.tileSize;

        gp.monster[24] = new MON_Bat(gp);
        gp.monster[24].worldX = 119 * gp.tileSize;
        gp.monster[24].worldY = 101 * gp.tileSize;

        gp.monster[25] = new MON_Bat(gp);
        gp.monster[25].worldX = 119 * gp.tileSize;
        gp.monster[25].worldY = 99 * gp.tileSize;

        gp.monster[26] = new MON_Bat(gp);
        gp.monster[26].worldX = 118 * gp.tileSize;
        gp.monster[26].worldY = 99 * gp.tileSize;

        gp.monster[27] = new MON_Bat(gp);
        gp.monster[27].worldX = 120 * gp.tileSize;
        gp.monster[27].worldY = 99 * gp.tileSize;

        gp.monster[28] = new MON_Bat(gp);
        gp.monster[28].worldX = 120 * gp.tileSize;
        gp.monster[28].worldY = 101 * gp.tileSize;

        gp.monster[29] = new MON_Bat(gp);
        gp.monster[29].worldX = 118 * gp.tileSize;
        gp.monster[29].worldY = 101 * gp.tileSize;
    }
}
