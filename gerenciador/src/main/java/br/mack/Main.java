package br.mack;

public class Main {
    public static void main(String[] args) {
        GerenciadorNomes gNomes = new GerenciadorNomesBD();
        Ihm ihm = new Ihm(gNomes);
        ihm.dialogar();
    }
}