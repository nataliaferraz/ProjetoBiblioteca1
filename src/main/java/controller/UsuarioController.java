package controller;

import controller.UsuarioController;

public class UsuarioController {

    private UsuarioController usuarioController = new UsuarioController();

    public void cadastrarUsuario(Usuario usuario) {
        usuarioController.salvar(usuario);
    }

    private void salvar(Usuario usuario) {
    }
}

