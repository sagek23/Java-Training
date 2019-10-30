package com.bit.draw1;

import java.io.Serializable;

public class GraphinInfo implements Serializable{//객체단위로 파일을 기록
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
