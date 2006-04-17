/**
 * $Id: Hop.java,v 1.1 2006/04/07 13:59:14 andrew_avis Exp $
 * Created on Oct 5, 2004
 *
 * Base class for hops.  This object doesn't do much except hold data and
 * get/set data.
 */

package ca.strangebrew;


public class Hop extends Ingredient{
	private double alpha;
	private String country;
	// private String form;
	private String add;
	private int minutes;
	private double storage;
	private double IBU;

	// Constructors:
	
	public Hop(){
		// default constructor
		// TODO: fill in with preferences
		setType("Leaf");
		setAdd("Boil");
	}
	
	public Hop(String u){
		setUnitsFull(u);
		setType("Leaf");
		setAdd("Boil");
	}
	
	// get methods:
	public String getAdd(){ return add; }
	public double getAlpha(){ return alpha; }
	public double getIBU(){ return IBU; }
	public int getMinutes(){ return minutes; }

	
	// Setter methods:
	public void setAdd(String a){ add = a; }
	public void setAlpha(double a){ alpha = a; }
	// public void setForm(String f){ form = f; }
	public void setIBU(double i){ IBU = i; }
	public void setMinutes(int m){ minutes = m; }
	public void setStorage(double s){ storage = s; }	

	
	public String toXML(){
	    StringBuffer sb = new StringBuffer();
	    sb.append( "    <ITEM>\n" );
	    sb.append( "      <HOP>"+getName()+"</HOP>\n" );
	    sb.append( "      <AMOUNT>"+getAmountAs(getUnits())+"</AMOUNT>\n" );
	    sb.append( "      <TIME>"+getMinutes()+"</TIME>\n" );
	    sb.append( "      <UNITS>"+getUnitsAbrv()+"</UNITS>\n" );
	    sb.append( "      <FORM>"+getType()+"</FORM>\n" );
	    sb.append( "      <ALPHA>"+alpha+"</ALPHA>\n" );
	    sb.append( "      <COSTOZ>"+getCostPerU()+"</COSTOZ>\n" );
	    sb.append( "      <ADD>"+add+"</ADD>\n" );
	    sb.append( "      <DESCRIPTION>"+getDescription()+"</DESCRIPTION>\n" );
	    sb.append( "      <DATE>"+getDate()+"</DATE>\n" );
	    sb.append( "    </ITEM>\n" );
	    return sb.toString();
	}
}