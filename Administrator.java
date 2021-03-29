import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;



public class Administrator extends JFrame{

	private JButton[][] locuri;
	private JLabel info;
	private JLabel info2;
	float pret;
	float total;
	float pretSecunda=1;
	private Masina[][] masini;
	private Loc_Listener locListener;
	private Operator fisier;
	
	private JButton addButon(int r,int c) {
		JButton nou=new JButton("");
		nou.setActionCommand(Integer.toString(r)+" "+Integer.toString(c));
		nou.setBounds(0,0,80,40);
		nou.addActionListener(locListener);
		return nou;
	}
	
	public Administrator() {
		locuri=new JButton[10][4];
		masini=new Masina[10][4];
		fisier=new Operator();
		
		total= fisier.loadTotal();
	       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       
	       this.setSize(1500,500);

	       locListener = new Loc_Listener(this);


	       setTitle ("Parking lot");

	       this.setLayout(new GridLayout(1,2));
	       JPanel ParcarePanel = new JPanel();
	       ParcarePanel.setLayout(new GridLayout(locuri.length, locuri[0].length));
	        for (int i = 0; i < locuri.length; i++)
	        {
	            for (int j = 0; j < locuri[i].length; j++ )
	            {
	                locuri[i][j] = addButon(i, j);
	                ParcarePanel.add(locuri[i][j]);
	                locuri[i][j].setVisible(true);
	            }
	        }
	       JPanel panel = new JPanel(new GridLayout(1, 2));
	       info = new JLabel();
	       afisarePret();
	       info2 = new JLabel();
	       afisareTotal();

	       panel.add(ParcarePanel);
	       panel.add(info);
	       panel.add(info2);
	       this.add(panel);

	   }
		
	
	
	 public void addMasina(int r, int c) {
		 masini[r][c]=new Masina();
		 String nr=JOptionPane.showInputDialog(this,"Introduceti numarul de inmatriculare:");
		 masini[r][c].setNr_inmatriculare(nr);
		 masini[r][c].startTimp();
		 locuri[r][c].setText(nr);
	 }
	 public void stergereMasina(int r, int c) {
		 int optiune = JOptionPane.showConfirmDialog (this, "Plecati?");

	        if(optiune == JOptionPane.YES_OPTION){
	            masini[r][c].StopTimp();
	            pret= masini[r][c].getTimp()/1000* pretSecunda;
	            total=total+pret;
	            fisier.salvareMasina(masini[r][c].getNr_inmatriculare());
	            fisier.salvarePlati(String.valueOf(pret));
	            fisier.salvareTotal(String.valueOf(total));
	            locuri[r][c].setText("");
	            afisarePret();
	            afisareTotal();
	        }

	 }
	 public void afisarePret(){
		    info.setText("Pret: " + pret);
		}
	 public void afisareTotal() {
		 info2.setText("TOTAL: "+total);
	 }
}
