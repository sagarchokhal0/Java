import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JFrame;
class GridBagLayoutDemo{
	int width,height,gridx,gridy;
	GridBagLayoutDemo(){
		JFrame frame = new JFrame("Grid Bag Layout");
		GridBagLayout gbl = new GridBagLayout();

		frame.setLayout(gbl);
		width = 8;
		height = 8;
		for (int i = 0; i<3 ; i++) {
			// System.out.println(i);
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.weightx = 1;
			gbc.weighty = 1;
			gbc.fill = GridBagConstraints.BOTH;
			JButton button = new JButton(""+(i+1));
			gbc.gridx = gridx;
			gbc.gridy = gridy;
			gbc.gridwidth = width;
			gbc.gridheight = height;
			if(i % 2 == 0){
				gridy = height;
				width = width/2;
			}else{
				gridx = width;
				height = height/2;
			}

			gbl.setConstraints(button,gbc);
			System.out.println("X=> "+gbl.getConstraints(button).gridx+" Y=> "+gbl.getConstraints(button).gridy+" Width=> "+gbl.getConstraints(button).gridwidth+" Height=> "+gbl.getConstraints(button).gridheight);
			frame.add(button);
		}
		frame.setSize(500,500);
		frame.setVisible(true);
	}
	public static void main(String[] args){
		new GridBagLayoutDemo();
	}
}