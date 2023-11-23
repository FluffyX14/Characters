import javax.swing.*;
import BreezySwing.*;
public class Gui extends GBFrame {
	JTextField input = addTextField ("", 1, 2, 1, 1);
	JLabel inputLabel = addLabel ("Enter sentence:", 1, 1, 1, 1);
	JButton enter = addButton("Enter", 2, 2, 1, 1);
	String sentence = "";
	Character calculate = new Character();
	
	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == enter) {
			sentence = input.getText();
			messageBox("Character Count: " + calculate.getCharacterCount(sentence) + '\n' + "Word Count: " + calculate.getWordCount() + '\n' + "Trimmed Sentence: " + calculate.getSimplifiedString(sentence)  + '\n' + '\n' +  calculate.getUniqueWords(), 800, 500);
		}
	}
	//outputs GUI
	public static void main(String[] args) {
		JFrame frm = new Gui();
		frm.setTitle("Characters");
		frm.setSize(600, 300);
		frm.setVisible(true);
	}
}
