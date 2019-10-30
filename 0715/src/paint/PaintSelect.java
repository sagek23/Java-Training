package paint;

import java.awt.Color;
import java.io.Serializable;

public class PaintSelect implements Serializable {
	int sx;
	int sy;
	int ex;
	int ey;
	int drawType;
	Color color;
	
	public PaintSelect(int sx, int sy, int ex, int ey, int drawType, Color color) {
		super();
		this.sx = sx;
		this.sy = sy;
		this.ex = ex;
		this.ey = ey;
		this.drawType = drawType;
		this.color = color;

	}



	
}
