package orabolt;

public enum OraTipusok {
	
	KARORA("karóra"), FALIORA("falióra"), EBRESZTOORA("ébresztőóra"), STOPPERORA("stopperóra");
	
	private final String oraMegnevezes;



	private OraTipusok(String oraMegnevezes) {
		this.oraMegnevezes = oraMegnevezes;
	}


	public String toString() {
		return oraMegnevezes;
	}
		
}
