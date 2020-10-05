import java.awt.*;
import java.awt.image.BufferedImage;

public class Julia extends Fractal {
    private final Complex c ;

    public Julia(int maxIteration, double zoom, double posX, double posY, Complex c) {
        super(maxIteration, zoom, posX, posY);
        this.c = c;
    }

    public Complex getC() {
        return c;
    }

    public BufferedImage drawJulia(int maxLargeur , int maxLongueur){
        BufferedImage image = new BufferedImage(maxLargeur,maxLongueur, BufferedImage.TYPE_INT_RGB);
        for(int i=0;i<maxLargeur;i++){
            for(int j=0;j<maxLongueur;j++){
                Complex z = new Complex(factRedimY(j,maxLongueur),factRedimX(i,maxLargeur));
                int n = divergence(z,c);
                int color = Color.HSBtoRGB(getMaxIteration()/(float)n%1,1,n>0?1:0);
                image.setRGB(i,j,color);
            }
        }
        return image ;
    }
}
