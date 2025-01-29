package view;

import javax.swing.*;

class UsuarioView {
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public UsuarioView getUserInput() {
        String nome = JOptionPane.showInputDialog("Nome:");
        String sexo = JOptionPane.showInputDialog("Sexo:");
        String celular = JOptionPane.showInputDialog("Celular:");
        String email = JOptionPane.showInputDialog("Email:");
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID:"));
        return new UsuarioView();
    }
}
