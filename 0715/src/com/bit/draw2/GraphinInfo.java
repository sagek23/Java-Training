package com.bit.draw2;

import java.io.Serializable;

public class GraphinInfo implements Serializable{//객체단위로 파일을 기록
	int sx;
	int sy;
	int ex;
	int ey;
	int drawType;
	public GraphinInfo(int sx, int sy, int ex, int ey, int drawType) {
		super();
		this.sx = sx;
		this.sy = sy;
		this.ex = ex;
		this.ey = ey;
		this.drawType = drawType;
	}
	
	
}
