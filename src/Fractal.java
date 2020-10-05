import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Fractal {
    private final int maxIteration;
    private final double zoom;
    private final double posX;
    private final double posY;

    public Fractal(int maxIteration, double zoom, double posX, double posY) {
        this.maxIteration = maxIteration;
        this.zoom = zoom;
        this.posX = posX;
        this.posY = posY;
    }

    public int getMaxIteration() {
        return maxIteration;
    }

    public double getZoom() {
        return zoom;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public double factRedimX(int axeX, double largeurFenetre) {
        return 1.5 * (axeX - largeurFenetre / 2) / (0.5 * zoom * largeurFenetre) + posX;

    }

    public double factRedimY(int axeY, double longeurFenetre) {
        return (axeY - longeurFenetre / 2) / (0.5 * zoom * longeurFenetre) + posY;

    }


    public int divergence(Complex z, Complex c) {
        int i = getMaxIteration();
        while (z.modulo() <= 2 && i > 0) {
            z = Complex.addition(c, Complex.multiplication(z, z));
            i--;
        }
        return i;
    }
    /*INUTILE*/
    public static void color(BufferedImage image, Color couleur, int tolerance) {
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                Color c = new Color(image.getRGB(i, j));
                if (c.getGreen() < tolerance) {
                    Color nc = new Color(0, 0, 0);
                    image.setRGB(i, j, nc.getRGB());
                    /*TROUE NOIRE TOLERANCE=RADIUS*/
                } else {
                    int nr = (c.getRed() + couleur.getRed()) % 256;
                    int ng = (c.getGreen() + couleur.getGreen()) % 256;
                    int nb = (c.getBlue() + couleur.getBlue()) % 256;
                    Color nc = new Color(nr, ng, nb);
                    image.setRGB(i, j, nc.getRGB());

                }
            }
        }

    }

    public static void save(BufferedImage image, String nom, String chemin) {
        try {
            File f = new File(chemin, nom + ".png");
            if (f.exists()) {
                int i = 0;
                while (f.exists()) {
                    i++;
                    f = new File(chemin, nom + "(" + i + ")" + ".png");
                }
                ImageIO.write(image, "png", f);
            } else {
                ImageIO.write(image, "png", f);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Fractal{" +
                "maxIteration=" + maxIteration +
                ", zoom=" + zoom +
                ", posX=" + posX +
                ", posY=" + posY +
                '}';
    }
}
