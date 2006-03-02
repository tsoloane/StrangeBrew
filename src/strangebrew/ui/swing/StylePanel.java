package strangebrew.ui.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import strangebrew.Recipe;
import strangebrew.Style;

public class StylePanel extends javax.swing.JPanel {
	private JLabel jLabel1;
	private JLabel lblStyle2;
	private JLabel stlLowOG;
	private JLabel stlHighOG;
	private JLabel stlLowABV;
	private JLabel stlHighABV;
	private JLabel stlLowIBU;
	private JLabel stlHighIBU;
	private JLabel stlLowColour;
	private JLabel stlHighColour;
	private JLabel stlRcpOG;
	private JLabel stlRcpABV;
	private JLabel stlRcpIBU;
	private JLabel stlRcpColour;
	private JPanel stylePanel;
	private ComboModel cmbStyle2Model;
	private JComboBox cmbStyle2;
	private JSlider sldMatch;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JLabel jLabel5;
	private JLabel jLabel4;
	private JPanel jPanel1;
	private JLabel jLabel3;
	private JLabel jLabel2;	
	private JTextArea txaStyles;
	private JPanel jPanel2;
	private JScrollPane jScrollPane3;
	
	private Recipe myRecipe;
	

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new StylePanel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public StylePanel() {
		super();
		initGUI();
	}
	
	public void setData(Recipe r) {
		myRecipe = r;
		cmbStyle2Model.addOrInsert(myRecipe.getStyleObj());
		setStyleData();
	}
	
	public void setList(ArrayList styleList){
		cmbStyle2Model.setList(styleList);
	}
	
	public void checkStyleConformance(){
		Style s = (Style) cmbStyle2Model.getSelectedItem();
		if (myRecipe.getEstOg() < s.ogLow || 
				myRecipe.getEstOg() > s.ogHigh)
			stlRcpOG.setForeground(Color.red);
		else
			stlRcpOG.setForeground(Color.black);
		
		if (myRecipe.getAlcohol() < s.alcLow ||
				myRecipe.getAlcohol() > s.alcHigh)
			stlRcpABV.setForeground(Color.red);
		else
			stlRcpABV.setForeground(Color.black);
		
		if (myRecipe.getSrm() < s.lovLow ||
				myRecipe.getSrm() > s.lovHigh)
			stlRcpColour.setForeground(Color.red);
		else
			stlRcpColour.setForeground(Color.black);
		
		if (myRecipe.getIbu() < s.ibuLow ||
				myRecipe.getIbu() > s.ibuHigh)
			stlRcpIBU.setForeground(Color.red);
		else
			stlRcpIBU.setForeground(Color.black);		
	}
	
	public void setStyleData(){
		Style s = (Style) cmbStyle2Model.getSelectedItem();

		// descriptionTextArea.setText(s.getDescription());
		// cmbStyle2.setToolTipText(multiLineToolTip(50,s.getDescription()));
		stlLowOG.setText(myRecipe.df3.format(s.ogLow));
		stlRcpOG.setText(myRecipe.df3.format(myRecipe.getEstOg()));
		stlHighOG.setText(myRecipe.df3.format(s.ogHigh));
		stlLowABV.setText(myRecipe.df1.format(s.alcLow));
		stlRcpABV.setText(myRecipe.df1.format(myRecipe.getAlcohol()));
		stlHighABV.setText(myRecipe.df1.format(s.alcHigh));
		stlLowColour.setText(myRecipe.df1.format(s.lovLow));
		stlRcpColour.setText(myRecipe.df1.format(myRecipe.getSrm()));
		stlHighColour.setText(myRecipe.df1.format(s.lovHigh));
		stlLowIBU.setText(myRecipe.df1.format(s.ibuLow));
		stlRcpIBU.setText(myRecipe.df1.format(myRecipe.getIbu()));
		stlHighIBU.setText(myRecipe.df1.format(s.ibuHigh));
		
		checkStyleConformance();
		txaStyles.setText(getStyleMatches());
	}
	
	public String getStyleMatches(){
		
		String styles="";
		Style s;

		for (int i=0; i<cmbStyle2Model.getSize(); i++){
			s = (Style) cmbStyle2Model.list.get(i);
			if (	myRecipe.getEstOg() > s.ogLow && myRecipe.getEstOg() < s.ogHigh &&
					myRecipe.getAlcohol() > s.alcLow && myRecipe.getAlcohol() < s.alcHigh &&
					myRecipe.getSrm() > s.lovLow && myRecipe.getSrm() < s.lovHigh &&
					myRecipe.getIbu() > s.ibuLow && myRecipe.getIbu() < s.ibuHigh ) {
				styles = styles.concat(s.name + "\n");
			}
			
		}
		
		return styles;
	}
	private void initGUI() {
		try {
			FlowLayout pnlStyleLayout = new FlowLayout();
			this.setLayout(pnlStyleLayout);
			setPreferredSize(new Dimension(400, 300));
			{
				jPanel1 = new JPanel();
				this.add(jPanel1);
				{
					lblStyle2 = new JLabel();
					jPanel1.add(lblStyle2);
					lblStyle2.setText("Style:");
				}
				{
					cmbStyle2Model = new ComboModel();
					cmbStyle2 = new JComboBox();
					jPanel1.add(cmbStyle2);
					cmbStyle2.setModel(cmbStyle2Model);
					cmbStyle2.setMaximumSize(new java.awt.Dimension(100, 32767));

					cmbStyle2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							setStyleData();
						}
					});

				}
			}
			{
				jPanel2 = new JPanel();
				GridBagLayout jPanel2Layout1 = new GridBagLayout();
				jPanel2Layout1.columnWeights = new double[]{0.1, 0.1, 0.1, 0.1};
				jPanel2Layout1.columnWidths = new int[]{7, 7, 7, 7};
				jPanel2Layout1.rowWeights = new double[]{0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
				jPanel2Layout1.rowHeights = new int[]{7, 7, 7, 7, 7, 7};
				jPanel2.setPreferredSize(new java.awt.Dimension(179, 120));
				jPanel2.setLayout(jPanel2Layout1);
				this.add(jPanel2);
				jPanel2.setBorder(BorderFactory.createTitledBorder(new LineBorder(
						new java.awt.Color(0, 0, 0), 1, false), "Recipe Conformance:",
						TitledBorder.LEADING, TitledBorder.TOP, new java.awt.Font(
								"Dialog", 0, 12), new java.awt.Color(0, 0, 0)));
				{
					jLabel5 = new JLabel();
					jPanel2.add(jLabel5, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
							GridBagConstraints.EAST, GridBagConstraints.NONE,
							new Insets(0, 0, 0, 0), 0, 0));
					jLabel5.setText("OG:");
					jLabel5.setBounds(74, 3, 60, 30);
				}
				{
					jLabel1 = new JLabel();
					jPanel2.add(jLabel1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.NONE,
							new Insets(0, 0, 0, 0), 0, 0));
					GridLayout jLabel1Layout = new GridLayout(1, 1);
					jLabel1.setLayout(jLabel1Layout);
					jLabel1.setText("Low:");
				}
				{
					jLabel2 = new JLabel();
					jPanel2.add(jLabel2, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.NONE,
							new Insets(0, 0, 0, 0), 0, 0));
					jLabel2.setText("Recipe:");
				}
				{
					jLabel3 = new JLabel();
					jPanel2.add(jLabel3, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.NONE,
							new Insets(0, 0, 0, 0), 0, 0));
					jLabel3.setText("High:");
				}
				{
					jLabel4 = new JLabel();
					jPanel2.add(jLabel4, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.EAST, GridBagConstraints.NONE,
							new Insets(0, 0, 0, 0), 0, 0));
					jLabel4.setText("IBU:");
				}
				{
					jLabel6 = new JLabel();
					jPanel2.add(jLabel6, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
							GridBagConstraints.EAST, GridBagConstraints.NONE,
							new Insets(0, 0, 0, 0), 0, 0));
					jLabel6.setText("Colour:");
				}
				{
					jLabel7 = new JLabel();
					jPanel2.add(jLabel7, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
							GridBagConstraints.EAST, GridBagConstraints.NONE,
							new Insets(0, 0, 0, 0), 0, 0));
					jLabel7.setText("ABV:");
				}
				{
					stlLowOG = new JLabel();
					jPanel2.add(stlLowOG, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
							GridBagConstraints.EAST, GridBagConstraints.NONE,
							new Insets(0, 0, 0, 0), 0, 0));
					stlLowOG.setText("0");
				}
				{
					stlRcpOG = new JLabel();
					jPanel2.add(stlRcpOG, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
							GridBagConstraints.EAST, GridBagConstraints.NONE,
							new Insets(0, 0, 0, 0), 0, 0));
					stlRcpOG.setText("0");
				}
				{
					stlHighOG = new JLabel();
					jPanel2.add(stlHighOG, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0,
							GridBagConstraints.EAST, GridBagConstraints.NONE,
							new Insets(0, 0, 0, 0), 0, 0));
					stlHighOG.setText("0");
				}
				{
					stlLowABV = new JLabel();
					jPanel2.add(stlLowABV, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
							GridBagConstraints.EAST, GridBagConstraints.NONE,
							new Insets(0, 0, 0, 0), 0, 0));
					stlLowABV.setText("0");
				}
				{
					stlRcpABV = new JLabel();
					jPanel2.add(stlRcpABV, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
							GridBagConstraints.EAST, GridBagConstraints.NONE,
							new Insets(0, 0, 0, 0), 0, 0));
					stlRcpABV.setText("0");
				}
				{
					stlHighABV = new JLabel();
					jPanel2.add(stlHighABV, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0,
							GridBagConstraints.EAST, GridBagConstraints.NONE,
							new Insets(0, 0, 0, 0), 0, 0));
					stlHighABV.setText("0");
				}
				{
					stlLowColour = new JLabel();
					jPanel2.add(stlLowColour, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
							GridBagConstraints.EAST, GridBagConstraints.NONE,
							new Insets(0, 0, 0, 0), 0, 0));
					stlLowColour.setText("0");
				}
				{
					stlRcpColour = new JLabel();
					jPanel2.add(stlRcpColour, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
							GridBagConstraints.EAST, GridBagConstraints.NONE,
							new Insets(0, 0, 0, 0), 0, 0));
					stlRcpColour.setText("0");
				}
				{
					stlHighColour = new JLabel();
					jPanel2.add(stlHighColour, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0,
							GridBagConstraints.EAST, GridBagConstraints.NONE,
							new Insets(0, 0, 0, 0), 0, 0));
					stlHighColour.setText("0");
				}
				{
					stlLowIBU = new JLabel();
					jPanel2.add(stlLowIBU, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.EAST, GridBagConstraints.NONE,
							new Insets(0, 0, 0, 0), 0, 0));
					stlLowIBU.setText("0");
				}
				{
					stlRcpIBU = new JLabel();
					jPanel2.add(stlRcpIBU, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.EAST, GridBagConstraints.NONE,
							new Insets(0, 0, 0, 0), 0, 0));
					stlRcpIBU.setText("0");
				}
				{
					stlHighIBU = new JLabel();
					jPanel2.add(stlHighIBU, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.EAST, GridBagConstraints.NONE,
							new Insets(0, 0, 0, 0), 0, 0));
					stlHighIBU.setText("0");
				}
			}
			{
				jScrollPane3 = new JScrollPane();
				this.add(jScrollPane3);
				{
					txaStyles = new JTextArea();
					jScrollPane3.setViewportView(txaStyles);
					txaStyles.setText("Matched Styles");
				}
			}
			{
				sldMatch = new JSlider();
				this.add(sldMatch);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
