package in.thirumal.model;

import java.util.ArrayList;
import java.util.HashMap;

import in.thirumal.utility.ERM2BeansHelper;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
public class Entity {

	private	String 				nom;
	private String 				dbName;
	private String 				tablePrefix;
	private ArrayList<Attribute> alAttr;
	private String				parentClass;
	private ArrayList<String>	interfaces;
	private String				modelPckg;
	private String				daoPckg;
	private String 				rawName;
	
	private boolean codeTable;
	private HashMap<String, Integer> constantes;
	
	public Entity(String dbName, String tablePrefix, String nom) {
		this.dbName 		=	dbName;
		this.tablePrefix 	= 	tablePrefix;
		this.nom 			= 	ERM2BeansHelper.StringHelper.saniziteForClassName(nom);
		this.rawName		= 	nom;
		interfaces 			= 	new ArrayList<>();
	}

	//Getter / Setter
	public String getRawName() {
		return rawName;
	}

	public String getDaoPackage() {
		return daoPckg;
	}

	public void setDaoPackage(String daoPckg) {
		this.daoPckg = daoPckg;
	}

	public String getModelPackage(){
		return modelPckg;
	}
	
	public void setModelPackage(String modelPckg){
		this.modelPckg	=	modelPckg;
	}
	
	public String getModelCanonicalName(){
		return modelPckg != null && !modelPckg.isEmpty() ? modelPckg+"."+nom : nom;
	}
	
	public String getDaoCanonicalName(){
		return daoPckg != null && !daoPckg.isEmpty() ? daoPckg+"."+nom : nom;
	}

	public void addInterface(String interFace){
		interfaces.add(interFace);
	}
	
	public void removeInterfaces(){
		interfaces = new ArrayList<>();
	}
	
	public ArrayList<String> getInterfaces(){
		return interfaces;
	}
	
	public boolean hasInterface(){
		return interfaces != null && !interfaces.isEmpty();
	}
	
	public boolean hasParent(){
		return parentClass != null && !parentClass.isEmpty();
	}

	public String getParentClass() {
		return parentClass;
	}

	public void setParentClass(String parentClass) {
		this.parentClass = parentClass;
	}

	public String getName() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = ERM2BeansHelper.StringHelper.saniziteForClassName(nom);
	}

	public ArrayList<Attribute> getAlAttr() {
		return alAttr;
	}

	public void setAlAttr(ArrayList<Attribute> alAttr) {
		this.alAttr = alAttr;
	}

	public String getTablePrefix() {
		return tablePrefix;
	}

	public void setTablePrefix(String tablePrefix) {
		this.tablePrefix = tablePrefix;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public HashMap<String, Integer> getConstantes() {
		return constantes;
	}

	public void setConstantes(HashMap<String, Integer> constantes) {
		this.constantes = constantes;
	}

	public boolean isCodeTable() {
		return codeTable;
	}

	public void setCodeTable(boolean codeTable) {
		this.codeTable = codeTable;
	}

}
