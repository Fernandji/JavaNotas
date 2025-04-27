import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Notes {
	File file;
	File file2;
	String caminhoDoArquivo;

	// Create
	public void create() {
		try {
			caminhoDoArquivo = JOptionPane.showInputDialog(null,
					"Digite o local onde deseja criar o arquivo(ex:D:\\Trabalhos\\)");
			// Verify if this archive exist, if not create another
			file = new File(caminhoDoArquivo + JOptionPane.showInputDialog(null, "Digite o Nome do arquivo"));
			if (file.createNewFile()) {
				JOptionPane.showMessageDialog(null, file.getName() + " criado com sucesso.");
			} else {
				JOptionPane.showMessageDialog(null, "O arquivo já existe.");
			}

		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao criar o arquivo.");
			e.printStackTrace();
		}
	}

	// Read

	// Delete
	public void delete() {
		caminhoDoArquivo = JOptionPane.showInputDialog(null,
				"Digite o local onde deseja excluir o arquivo(ex:D:\\Trabalhos\\)");
		file = new File(
				caminhoDoArquivo + JOptionPane.showInputDialog(null, "Digite o Nome do arquivo que deseja excluir"));
		if (file.exists()) {
			file.delete();
			JOptionPane.showMessageDialog(null, file.getName() + " Deletado");

		} else {
			JOptionPane.showMessageDialog(null, "Arquivo não encontrado");
		}
	}

	public void read() {
		caminhoDoArquivo = JOptionPane.showInputDialog(null,"Digite o local onde o arquivo está para ser lido(ex:D:\\Trabalhos\\)");
		file = new File(
				caminhoDoArquivo + JOptionPane.showInputDialog(null, "Digite o nome do arquivo que deseja ler"));
		if (file.exists()) {
			 try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	                StringBuilder texto = new StringBuilder();
	                String linha;

	                while ((linha = br.readLine()) != null) {
	                    texto.append(linha).append("\n");
	                }

	                JTextArea textArea = new JTextArea(texto.toString());
	                textArea.setEditable(false);
	                JScrollPane scrollPane = new JScrollPane(textArea);
	                scrollPane.setPreferredSize(new Dimension(400, 400));

	                JFrame janela = new JFrame("Conteúdo do Arquivo");
	                janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                janela.getContentPane().setBackground(new Color(200, 50, 50));
	                janela.add(scrollPane);
	                janela.pack();
	                janela.setVisible(true);

	            } catch (IOException e) {
	                System.out.println("Não foi possível ler o arquivo");
	                e.printStackTrace();
	            }
		}
		else {
			JOptionPane.showMessageDialog(null, "o arquivo não existe","Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	// Rename
	public void rename() {
		caminhoDoArquivo = JOptionPane.showInputDialog(null,"Digite o local onde deseja renomear o arquivo(ex:D:\\Trabalhos\\)");
		file = new File(
				caminhoDoArquivo + JOptionPane.showInputDialog(null, "Digite o nome do arquivo que deseja renomear"));
		if (file.exists()) {
			file2 = new File(caminhoDoArquivo + JOptionPane.showInputDialog(null, "Digite o Novo Nome do arquivo"));
			file.renameTo(file2);
			JOptionPane.showMessageDialog(null, "Renomeado com suscesso");
		} else {
			JOptionPane.showMessageDialog(null, "Nenhum Arquivo Existente");
		}
	}
	
	public void escrever() {
		caminhoDoArquivo = JOptionPane.showInputDialog(null,"Digite o local onde deseja escrever no arquivo(ex:D:\\Trabalhos\\)");
		file = new File(caminhoDoArquivo + JOptionPane.showInputDialog(null, "Digite o Nome do arquivo que deseja escrever"));
		if(file.exists()) {
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
				String textoDoUsuario = JOptionPane.showInputDialog(null,"Digite o que gostaria de escrever no arquivo","Digite", JOptionPane.QUESTION_MESSAGE);
				bw.write(textoDoUsuario);
				bw.newLine();
				JOptionPane.showMessageDialog(null,"Texto escrito no arquivo com sucesso","Sucesso",JOptionPane.PLAIN_MESSAGE);
			}
			catch(IOException e) {
				 JOptionPane.showMessageDialog(null, "Não foi possível escrever no arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
	                e.printStackTrace();
				}
		}
		else {
			JOptionPane.showMessageDialog(null, "O arquivo não existe", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	// Write

}
