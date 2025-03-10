package br.mack;

import java.util.*;

public class GerenciadorNomesMem implements GerenciadorNomes {
    private List<String> nomes = new ArrayList<String>();

    @Override
    public List<String> obterNomes() {
        return nomes;
    }
    // sua prima
    @Override
    public void adicionarNome(String nome) {
        nomes.add(nome);
    }
}