package view;

import controller.LivroController;
import model.LivroModel;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

public class CadastroDeLivro extends JFrame {
    private JPanel panel1;
    private JTextField textFieldTitulo;
    private JLabel jLabelTitulo;
    private JTextField textFieldTema;
    private JLabel jLabelTema;
    private JTextField textFieldAutor;
    private JLabel jLabelAutor;
    private JTextField textFieldIsbn;
    private JLabel jLabelIsbn;
    private JLabel jLabelData;
    private JTextField textFieldQuantidade;
    private JLabel jLabelQuantidade;
    private JButton enviarButton;
    private JFormattedTextField formattedTextFieldData;

    public CadastroDeLivro() {
        this.setTitle("Sistema de Gestão de Biblioteca");
        this.setContentPane(panel1);
        this.setSize(640, 480);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LivroModel livro = new LivroModel();
                livro.setTitulo(textFieldTitulo.getText());
                livro.setTema(textFieldTema.getText());
                livro.setAutor(textFieldAutor.getText());
                livro.setIsbn(Integer.parseInt(textFieldIsbn.getText()));
                livro.setQuantidade(Integer.parseInt(textFieldQuantidade.getText()));
                livro.setData(Integer.parseInt(formattedTextFieldData.getText()));


                try {
                    MaskFormatter datatipo = null;

                    datatipo = new MaskFormatter("##/##/####");

                    datatipo.setPlaceholderCharacter('_');

                    formattedTextFieldData.setFormatterFactory(new DefaultFormatterFactory(datatipo));

                    LivroController livroController = null;
                    JOptionPane.showMessageDialog(null, livroController.salvar(livro));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);

                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            }


        });
    }

    private void createUIComponents() {

    }
}

