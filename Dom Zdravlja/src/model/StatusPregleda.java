package model;

public enum StatusPregleda {
	zatrazen,
	zakazan,
	otkazan,
	zavrsen;
	
	private String text;
	static {
		zatrazen.text="zatrazen";
		zakazan.text="zakazan";
		otkazan.text="otkazan";
		zavrsen.text="zavrsen";
	}
	public String toString() {
		return text;
	}
}
