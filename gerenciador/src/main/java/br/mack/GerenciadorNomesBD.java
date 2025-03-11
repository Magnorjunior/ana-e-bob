package br.mack;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorNomesBD implements GerenciadorNomes {
    private static final String URL = "jdbc:postgresql://db.cqgngbsqokoryfogebqk.supabase.co:5432/postgres?user=postgres&password=AnaANDBod...";

    public GerenciadorNomesBD() {
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS nomes (id SERIAL PRIMARY KEY, nome VARCHAR(20) NOT NULL)";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados ou criar a tabela.");
            e.printStackTrace();
        }
    }

    @Override
    public List<String> obterNomes() {
        List<String> nomes = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT nome FROM nomes")) {
            while (rs.next()) {
                nomes.add(rs.getString("nome"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao obter nomes do banco de dados.");
            e.printStackTrace();
        }
        return nomes;
    }

    @Override
    public void adicionarNome(String nome) {
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO nomes (nome) VALUES (?)")) {
            stmt.setString(1, nome);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar nome ao banco de dados.");
            e.printStackTrace();
        }
    }
}
