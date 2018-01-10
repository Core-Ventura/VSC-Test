import processing.core.PApplet;

public class PlanetSystemGenerator extends PApplet{

    public static void main(String[] args) {
        PApplet.main("PlanetSystemGenerator");
    }

    Planet sun;

    public void settings(){
        size(600,600);
    }

    public void setup(){
        fill(120,50,240);
        sun = new Planet(this, 50, 0, 0);
        sun.spawnMoons(5, 1);
    }

    public void draw(){
        background(0);
        translate(width/2, height/2);
        sun.show();
        sun.orbit();
    }

}