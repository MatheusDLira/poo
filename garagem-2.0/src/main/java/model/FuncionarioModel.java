package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Execute;

import config.SQLConnection;
import entity.Funcionario;

public class FuncionarioModel {
	
	Connection c;
	
	
public FuncionarioModel() {
		this.c = SQLConnection.getConnection();
	}

public void cadastrarFuncionario(Funcionario funcionario) {
	
		String sql = "INSERT INTO funcionario(codigof, usuario, senha, salario, nome, cpf, endereco, telefone, cargo ) VALUES(?,?,?,?,?,?,?,?,?)";
		
		try {
			
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, funcionario.getCodigo());
			ps.setString(2, funcionario.getUsuario());
			ps.setString(3,funcionario.getSenha());
			ps.setFloat(4, funcionario.getSalario());
			ps.setString(5, funcionario.getNome());
			ps.setString(6, funcionario.getCpf());
			ps.setString(7, funcionario.getEndereco());
			ps.setString(8, funcionario.getTelefone());
			ps.setString(9, funcionario.getCargo());
			ps.execute();
			
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}
	
	public void alterarFuncionario(Funcionario funcionario) {
		
		String sql = "UPDATE funcionario SET usuario = ?, senha = ?, cpf = ?, endereco = ?, telefone = ?, cargo = ? WHERE idFuncionario = ?";
		try {
			
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, funcionario.getCodigo());
			ps.setString(2, funcionario.getUsuario());
			ps.setString(3,funcionario.getSenha());
			ps.setFloat(4, funcionario.getSalario());
			ps.setString(5, funcionario.getNome());
			ps.setString(6, funcionario.getCpf());
			ps.setString(7, funcionario.getEndereco());
			ps.setString(8, funcionario.getTelefone());
			ps.setString(9, funcionario.getCargo());
			ps.execute();
			
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
		
		
	}
	
	public List<Funcionario> listarFuncionario(){
		
		List<Funcionario> funcionario = new ArrayList<Funcionario>();
		String sql = "SELECT * FROM funcionario";
		ResultSet a;
		
		try {
			
			PreparedStatement b = c.prepareStatement(sql);
			a = b.executeQuery(sql);
			while (a.next()) {
				Funcionario auto = new Funcionario();
				auto.setCodigo(a.getInt("codigof"));
				auto.setUsuario(a.getString("usuario"));
				auto.setNome(a.getString("nome"));
				auto.setCpf(a.getString("endereco"));
				auto.setEndereco(a.getString("endereco"));
				auto.setTelefone(a.getString("telefone"));
				auto.setCargo(a.getString("cargo"));
				funcionario.add(auto);
			}
			
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		return funcionario;
		
	}
	
	 public Funcionario buscarFuncionario(int busca){
		 
		    Funcionario auto = new Funcionario();
			String sql = "SELECT * FROM funcionario WHERE idFuncionario = ?";
			ResultSet a;
			
			try {
				
				PreparedStatement b = c.prepareStatement(sql);
				b.setInt(1, busca);
				a = b.executeQuery();
				while (a.next()) {
					
					/*auto.setIdFuncionario(a.getInt("idFuncionario"));
					auto.setNomeMarca(a.getString("nomeMarca"));
					auto.setNomeModelo(a.getString("nomeModelo"));
					auto.setCor(a.getString("cor"));
					auto.setAno_fabricacao(a.getDate("anoFab"));
					auto.setAno_modelo(a.getDate("anoMod"));
					auto.setChassi(a.getString("chassi"));
					auto.setPlaca(a.getString("placa"));
					auto.setKm(a.getFloat("km"));
					auto.setValor(a.getFloat("valor"));*/
					
				}
				
				
			} catch (Exception e) {
				
				System.out.println(e.getMessage());
			}
			return auto;
			
		 
		 
	 }
	 
	 public void excluirFuncionario(int busca){
		 
		 String sql = "DELETE FROM funcionario WHERE idFuncionario = ?";
		 
		 try {
			 
			 PreparedStatement b = c.prepareStatement(sql);
			 b.setInt(1, busca);
			 b.execute();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		 
	 }
	 


}