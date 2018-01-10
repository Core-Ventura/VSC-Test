import processing.core.*;

public class Planet{
    PApplet parent;

    float radius;
    float angle;
    float distance;
    float orbitSpeed;

    Planet[] planets;

    Planet(PApplet p, float r, float d, float o) {
        parent = p;
        radius = r;
        distance = d;
        angle = parent.random(parent.TWO_PI);
        orbitSpeed = o;
    }

    void orbit() {
        angle = angle + orbitSpeed;
        if (planets != null) {
            for (int i = 0; i < planets.length; i++) {
                planets[i].orbit();
            }
        }
    }

    void spawnMoons(int total, int level){
        planets = new Planet[total];
        for (int i = 0; i < planets.length; i++) {
            float r = radius/(level*2f);
            float d = parent.random(75, 300);
            float o = parent.random(-0.1f, 0.1f);
            planets[i] = new Planet(parent, r, d/level, o);
            if (level < 2) {
                int num = 2;
                planets[i].spawnMoons(num, level+1);
            }
        }
    }

    void show() {
        parent.pushMatrix();
        parent.rotate(angle);
        parent.translate(distance, 0);
        parent.fill(255, 100);
        parent.ellipse(0, 0, radius*2, radius*2);
        if (planets != null) {
            for (int i = 0; i < planets.length; i++) {
                planets[i].show();
            }
        }
        parent.popMatrix();
    }
}