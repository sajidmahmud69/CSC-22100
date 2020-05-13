package sample;

import javafx.scene.paint.Color;

    public enum MyColor{
        BLACK(0, 0, 0), BLUE(0, 0, 255), CYAN(0, 255, 255), DARK_GRAY(169, 169, 169),
        GREEN(0, 255, 0), MAGENTA(255, 0, 255), ORANGE(255, 255, 0), LIGHT_GRAY(211, 211, 211),
        RED(255, 0, 0), PINK(255, 192, 203), NAVY (0, 0, 128), INDIGO (75, 0, 130), TEAL (0,128,128), DARK_GREEN (0,100,100),
        DARK_TURQUOISE (0, 206, 209), DARK_MAGENTA (139, 0, 139), BEIGE (245, 245, 220),
        MAROON (128, 0, 0), DARK_GOLDEN_ROD (184,134,11), SEA_GREEN (46, 139, 87), SANDY_BROWN(244, 164, 96);

        private Color color;

        // Constructor

        MyColor(int r, int g, int b) {
            this.color = Color.rgb (r,g,b);
        }
        public Color getMyColor(){ return color; }
    }