public class Main {
    public static void Main(String[] args) {
    GerenciadorNomes gNomes = new GerenciadorNomesMem();
    Ihm ihm = new Ihm(gNomes);
    ihm.dialogar();
    }
   }