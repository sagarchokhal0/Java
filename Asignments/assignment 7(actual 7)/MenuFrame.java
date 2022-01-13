import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.*;
class MenuFrame{
	JFrame frame;
	JMenuBar menubar;
	JPopupMenu popupMenu;
	JMenu file,edit,view,open;
	JMenuItem new_menu,save,close,text,folder,window,panel;
	MenuFrame(){
		frame = new JFrame("Menu Demo.");
		menubar = new JMenuBar();
		popupMenu = new JPopupMenu();

		addMenu(menubar);

		menubar.add(file);
		menubar.add(edit);
		menubar.add(view);
		menubar.add(open);

		addMenu(popupMenu);

		popupMenu.add(file);
		popupMenu.add(edit);
		popupMenu.add(view);
		popupMenu.add(open);

		frame.setSize(500,500);
		frame.setVisible(true);

		frame.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if(e.getButton() == MouseEvent.BUTTON3){
					popupMenu.show(frame,e.getX(),e.getY());
				}
			}
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setJMenuBar(menubar);	
		frame.setSize(500,500);
		frame.setVisible(true);
	}
	void addMenu(JComponent menubar){
		file = new JMenu("File");
		edit = new JMenu("Edit");
		view = new JMenu("View");
		open = new JMenu("Open");

		new_menu = new JMenu("New");
		save = new JMenuItem("Save");
		close = new JMenuItem("Close");
		text = new JMenuItem("Text");
		folder = new JMenuItem("Folder");
		window = new JMenuItem("Window");
		panel = new JMenuItem("Panel");

		open.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				System.out.println("Clicked");
				JDialog dialog = new JDialog(frame,"Confirm");
				JLabel label = new JLabel("Are you sure?");
				JButton btn = new JButton("Yes");
				dialog.setSize(200,100);
				dialog.setLayout(new GridLayout(2,1));
				dialog.add(label);
				dialog.add(btn);
				dialog.setLocationRelativeTo(frame);
				dialog.setVisible(true);
			}
		});

		new_menu.add(text);
		new_menu.add(folder);

		file.add(new_menu);
		file.add(save);
		file.add(close);

		view.add(window);
		view.add(panel);

		
	}
	public static void main(String[] args){
		new MenuFrame();
	}
}