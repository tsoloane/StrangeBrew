/**
 * Created on Oct 4, 2004
 * @author aavis
 *
 * This is the base malt class.  It doesn't do much, except hold data
 * and get/set data
 */

package strangebrew;

public class Malt {
	// base data
	public String name;
	public double pppg;
	public double lov;
	public String maltster;
	public String country;
	public String type;
	public boolean mashed;
	public double costPerU;
	public String description;

	/* recipe data
	* not sure if these should be here, probably not - add to
	* parallel array in recipe?
	* Similar issue with database data
	*/	
	public double amount;
	public String units;
	public double percent;

	// constructors:
	public Malt(String n, double p, double l, double a, String u) {
		name = n;
		pppg = p;
		lov = l;
		amount = a;
		units = u;
		mashed = true;
	}
	
	public Malt(){
		// default constructor
		name = "Malt";
		pppg = 0;
		lov = 0;
		amount = 1.0;
		units =  "lbs";
		mashed = true;
			// I want to get options working sometime,
			// but can't figure out how:
			// myOptions.getProperty("optMaltUnits");
			
	}
	
	// setter methods:
	public void setName(String n){ name = n; }
	public void setAmount(double a){ amount = a; }
	public void setPppg(double p){ pppg = p; }
	public void setCost(double c){ costPerU = c; }
	public void setCost(String c){
		CharSequence cs = "$";
		if (c.contains(cs)){
			
			String newC = c.substring(1, c.length());
			costPerU = Double.parseDouble(newC);
		}
		else
			costPerU = Double.parseDouble(c);
		
	}
	public void setUnits(String u) { units = u; }
	public void setLov(double l){ lov = l; }
	public void setDesc(String d){ description = d; }
	/**
	 * Handles a string of the form "d u", where d is a double
	 * amount, and u is a string of units.  For importing the
	 * quantity attribute from QBrew xml.
	 * @param a
	 */
	public void setAmountAndUnits(String a){
		int i = a.indexOf(" ");
		String d = a.substring(0,i);
		String u = a.substring(i);
		amount = Double.parseDouble(d.trim());
		units = u.trim();
	}
	
	// Need to add the spaces and type attributes to make this
	// backwards-compatible with SB1.8:
	public String toXML(){
	    StringBuffer sb = new StringBuffer();
	    sb.append( "    <ITEM>\n" );
	    sb.append( "      <MALT>"+name+"</MALT>\n" );
	    sb.append( "      <AMOUNT>"+amount+"</AMOUNT>\n" );
	    sb.append( "      <UNITS>"+units+"</UNITS>\n" );
	    sb.append( "      <POINTS>"+pppg+"</POINTS>\n" );
	    sb.append( "    </ITEM>\n" );
	    return sb.toString();
	}

}
