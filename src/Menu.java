//Required Imports 
import javax.swing.JOptionPane;
import java.io.File;
import java.io.IOException;

public class Menu {
	//Instances
	Notes notes = new Notes();
	
	//Variables
	int option; //Variable to user option
	String programName = "Gerenciador de Notas"; //Ignore XD
	
	//Method Execute Menu
	public void mainMenu(){
		option = Integer.parseInt(JOptionPane.showInputDialog(null ,"Bem-Vindo ao Gerenciador de Notas, escolha uma das opções a seguir: \n1 - Criar , 2 - Ler , 3 - Deletar , 4 - Atualizar , 0 - Encerrar "));
	
		
		//Analyze the chosen option
		switch(option) {
			case 0 -> { 
				JOptionPane.showMessageDialog(null, "Programa Encerrado", programName , JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
			//Method Create 
			case 1 -> notes.create();
			//Method Read
			case 2 -> notes.read();
			case 3 -> notes.delete(); //Method Delete
			case 4 -> updateMenu(); // Method Update
			default -> JOptionPane.showMessageDialog(null, "Opção Inválida",programName, JOptionPane.INFORMATION_MESSAGE); //If the user does not enter any of the values ​​above
		}
		//Restart to Main Menu
		 mainMenu(); 
	}
	
	public void updateMenu() {
		option = Integer.parseInt(JOptionPane.showInputDialog(null , "Escolha uma das opções a seguir: \n1 - Renomear , 2 - Escrever,  0 - Voltar"));
		switch (option) {
			case 0 -> mainMenu(); //Method to Return to Main Menu  
			case 1 -> notes.rename(); //Method to Rename Archive
			case 2 -> notes.escrever();
			//Method Write
		}
		
	}
}