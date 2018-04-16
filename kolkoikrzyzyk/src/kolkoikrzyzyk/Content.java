package kolkoikrzyzyk;

public enum Content {
	EMPTY(0),CIRCLE(1),CROSS(2);
	private int type;
	private Content(int id) {
		this.type=id;
	}

}
