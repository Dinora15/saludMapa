package unedMasterJavaModelo;

public class Data {
	
		

private String indicador_code;
private String country_code;
private String year;




public Data() {
	super();
	// TODO Auto-generated constructor stub
}


public Data(String indicador_code, String country_code, String year) {
	super();
	this.indicador_code = indicador_code;
	this.country_code = country_code;
	this.year = year;
}


public String getIndicador_code() {
	return indicador_code;
}
public void setIndicador_code(String indicador_code) {
	this.indicador_code = indicador_code;
}
public String getCountry_code() {
	return country_code;
}
public void setCountry_code(String country_code) {
	this.country_code = country_code;
}
public String getYear() {
	return year;
}
public void setYear(String year) {
	this.year = year;
}


@Override
public String toString() {
	return "Data [indicador_code=" + indicador_code + ", country_code=" + country_code + ", year=" + year + "]";
}

}
