package sample;

import javafx.scene.paint.Color;

public enum MyColor {
    BLACK (0,0,0), BLUE (0,0,255), CYAN (0,255,255), DARK_GRAY (169, 169, 169), GRAY (128,128,128),
    GREEN (0,255,0), MAGENTA (255,0,255), ORANGE (255,265,0), LIGHT_GRAY (211,211,211),
    RED (255,0,0), WHITE (255,255,255), YELLOW (255,255,0), PINK (255,192,203), OTHER;

    private int r, g, b;

    // Constructors
    MyColor() {
        this.r = 0;
        this.g = 0;
        this.b = 0;
    }

    MyColor(int r, int g, int b){
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public void setRGB (int r, int g, int b){
        this.r = r;
        this.g = g;
        this.b = b;
    }
    public Color getRGB() {
        return Color.rgb(r,g,b);
    }
}