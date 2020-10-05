public class Complex {
    private double imaginaire;
    private double reel;

    public Complex(double imaginaire, double reel) {
        this.imaginaire = imaginaire;
        this.reel = reel;
    }

    public double getImaginaire() {
        return imaginaire;
    }

    public void setImaginaire(double imaginaire) {
        this.imaginaire = imaginaire;
    }

    public double getReel() {
        return reel;
    }

    public void setReel(double reel) {
        this.reel = reel;
    }

    @Override
    public String toString() {
        return "Complex{" +
                "imaginaire=" + imaginaire +
                ", reel=" + reel +
                '}';
    }

    public void multiplication(Complex c) {
        this.setReel(this.reel * c.reel - this.imaginaire * c.imaginaire);
        this.setImaginaire(this.reel * c.imaginaire + this.imaginaire * c.reel);
    }

    public void addition(Complex c) {
        this.setReel(this.reel + c.reel);
        this.setImaginaire(this.imaginaire + c.imaginaire);
    }

    public double modulo() {
        return Math.sqrt(reel * reel + imaginaire * imaginaire);

    }

    public static Complex multiplication(Complex c1, Complex c2) {
        return new Complex(c1.reel * c2.imaginaire + c1.imaginaire * c2.reel, c1.reel * c2.reel - c1.imaginaire * c2.imaginaire);
    }

    public static Complex addition(Complex c1, Complex c2) {
        return new Complex(c1.imaginaire + c2.imaginaire, c1.reel + c2.reel);
    }


    public static double modulo(Complex c) {
        return Math.sqrt(c.reel * c.reel + c.imaginaire * c.imaginaire);

    }

}

