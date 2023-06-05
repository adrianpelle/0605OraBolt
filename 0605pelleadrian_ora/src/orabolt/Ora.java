package orabolt;

public class Ora {

	private String megnevezes;
	private OraTipusok tipus;
	private int ar;
	private boolean vizallo;
	
	
	public Ora(String megnevezes, OraTipusok tipus, int ar, boolean vizallo) {
		this.megnevezes = megnevezes;
		this.tipus = tipus;
		this.ar = ar;
		this.vizallo = vizallo;
	}



	@Override
	public String toString() {
		return megnevezes;
	}

	public String getMegnevezes() {
		return megnevezes;
	}


	public void setMegnevezes(String megnevezes) {
		this.megnevezes = megnevezes;
	}


	public OraTipusok getTipus(OraTipusok tipus) {
		return tipus;
	}

	public OraTipusok getTipus() {
		return tipus;
	}

	public void setTipus(OraTipusok tipus) {
		this.tipus = tipus;
	}


	public int getAr() {
		return ar;
	}


	public void setAr(int ar) {
		this.ar = ar;
	}


	public boolean isVizallo() {
		return vizallo;
	}


	public void setVizallo(boolean vizallo) {
		this.vizallo = vizallo;
	}


}
