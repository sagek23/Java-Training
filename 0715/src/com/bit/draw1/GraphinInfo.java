package com.bit.draw1;

import java.io.Serializable;

public class GraphinInfo implements Serializable{//��ü������ ������ ���
	int sx;
	int sy;
	int ex;
	int ey;
	public GraphinInfo(int sx, int sy, int ex, int ey) {
		super();
		this.sx = sx;
		this.sy = sy;
		this.ex = ex;
		this.ey = ey;
	}
	
	
}
