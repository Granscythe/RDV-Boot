package sopra.formation.model;

public class Views {
	
	public static class ViewCommon {}
	
	public static class ViewPatient extends ViewCommon {}
	
	public static class ViewAdmin extends ViewCommon{}

	public static class ViewRDV extends ViewCommon {}
	
	public static class ViewCreneauPraticien extends ViewCommon {}
	
	public static class ViewCreneauUnitaire extends ViewCommon {}
	
	public static class ViewPersonne extends ViewCommon {}
	
	public static class ViewPraticien extends ViewPersonne {}

	public static class ViewLieu extends ViewCommon{}
	
	public static class ViewPraticienLieu extends ViewCommon{}
	
	
	public static class ViewMotif extends ViewCommon {}
}
