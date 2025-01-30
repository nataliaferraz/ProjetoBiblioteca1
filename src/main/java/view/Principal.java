package view;

import view.CadastroDeLivro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame {

    private JMenuBar menuBar = new JMenuBar();
    private JPanel panel2;
    private JMenu jMenu;
    private JMenuItem jMenuItem;

    public Principal(){
        criacaoDoMenu();
        this.setTitle("Sistema de Gestão de Biblioteca");
        this.setContentPane(panel2);
        this.setSize(640, 480);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void criacaoDoMenu() {
        this.setJMenuBar(menuBar);
        JMenu arquivo = new JMenu("Arquivo");
        JMenuItem opcao1 = new JMenuItem("Opção 1");
        JMenuItem opcao2 = new JMenuItem("Opção 2");
        arquivo.add(opcao1);
        arquivo.add(opcao2);
        JMenu manter = new JMenu("Cadastramento");
        JMenuItem cadastro = new JMenuItem("Cadastrar Livro");
        JMenuItem editar = new JMenuItem("Cadastrar Usuario");
        manter.add(cadastro);
        manter.add(editar);
        menuBar.add(arquivo);
        menuBar.add(manter);
        cadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CadastroDeLivro();

            }
        });


        editar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CadastroDeUsuario();
            }
        });


    }
}