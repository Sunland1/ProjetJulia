public class Main {
    public static void main(String[] args) {
       Julia julia = new Julia(500,1,0,0,new Complex(0.01,0.285));
       Fractal.save(julia.drawJulia(1600,1080),"testJulia",System.getenv("PWD"));

    }
}
