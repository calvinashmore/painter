package fluids.applied;

import fluids.Particle;
import utils.linear.Color;

public class ColorParticle extends Particle {

    private Color color;

    public ColorParticle() {
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
