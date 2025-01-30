package view;

import model.UsuarioModel;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CadastroDeUsuario extends JFrame {
    private JTextField textFieldNome;
    private JTextField celular; // Alterado para JFormattedTextField com máscara
    private JTextField textFieldEmail;
    private JTextField textFieldId;
    private JRadioButton femininoRadioButton;
    private JRadioButton masculinoRadioButton;
    private JPanel panel3;
    private JLabel jLabelNome;
    private JLabel jLabelSexo;
    private JLabel jLabelCelular;
    private JLabel jLabelEmail;
    private JLabel jLabelId;
    private JButton enviarButton2;
    private ButtonGroup grupoSexo;

    public CadastroDeUsuario() {
        this.setTitle("Sistema de Gestão de Biblioteca");
        this.setSize(640, 480);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null); // Centraliza a janela
        this.setContentPane(panel3);

        // Agrupa os botões de sexo
        grupoSexo = new ButtonGroup();
        grupoSexo.add(femininoRadioButton);
        grupoSexo.add(masculinoRadioButton);

        // Ação do botão "Enviar"
        enviarButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarUsuario();
            }
        });

        this.setVisible(true);
    }

    private void cadastrarUsuario() {
        UsuarioModel usuario = new UsuarioModel();
        usuario.setNome(textFieldNome.getText());
        usuario.setCelular(celular.getText());
        usuario.setEmail(textFieldEmail.getText());

        // Verifica qual botão de rádio está selecionado
        if (femininoRadioButton.isSelected()) {
            usuario.setSexo("Feminino");
        } else if (masculinoRadioButton.isSelected()) {
            usuario.setSexo("Masculino");
        } else {
            usuario.setSexo("Não informado");
        }

        // Validação do e-mail
        if (!validarEmail(usuario.getEmail())) {
            JOptionPane.showMessageDialog(this, "E-mail inválido! Digite um e-mail válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    private boolean validarEmail(String email) {
        // Expressão regular para validar email
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private void createUIComponents() {
        // Criando máscara para telefone
        try {
            MaskFormatter celularMask = new MaskFormatter("(##) #####-####");
            celularMask.setPlaceholderCharacter('_');
            celular = new JFormattedTextField(celularMask);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new CadastroDeUsuario();
    }
}
