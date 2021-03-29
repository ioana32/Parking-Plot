
public class Masina {
	private String nr_inmatriculare;
	private long timp=0;
	private long start,stop;
	
	public Masina() {}
	
	public Masina(String nr_inmatriculare) {
		this.nr_inmatriculare=nr_inmatriculare;
	}
	
	public void startTimp() {
		start=System.currentTimeMillis();
	}
	
	public void StopTimp() {
		stop=System.currentTimeMillis();
		timp=stop-start;
	}

	public String getNr_inmatriculare() {
		return nr_inmatriculare;
	}

	public void setNr_inmatriculare(String nr_inmatriculare) {
		this.nr_inmatriculare = nr_inmatriculare;
	}

	public long getTimp() {
		return timp;
	}

	public void setTimp(long timp) {
		this.timp = timp;
	}
	
	public String toString() {
		return nr_inmatriculare;
	}
	
}
