package sopra.formation.model;

public class Views {
	public static class ViewCommon {}

	public static class ViewRDV extends ViewCommon {}
	
	public static class ViewCreneauPraticien extends ViewCommon {}
	public static class ViewPersonne extends ViewCommon {}
	
	public static class ViewPraticien extends ViewPersonne {}
	public static class ViewPatient {}
	public static class ViewAdmin{}
}