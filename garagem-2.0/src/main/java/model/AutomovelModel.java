package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Execute;

import config.SQLConnection;
import entity.Automovel;

public class AutomovelModel {
	
	Connection c;
	
	
public AutomovelModel() {
		this.c = SQLConnection.getConnection();
	}

public void cadastrarAutomovel(Automovel automovel) {
	
		String sql = "INSERT INTO automovel(nomeMarca, nomeModelo, cor, chassi, placa, anoFab, anoMod, km, valor ) VALUES(?,?,?,?,?,?,?,?,?)";
		
		try {
			
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, automovel.getNomeMarca());
			ps.setString(2, automovel.getNomeModelo());
			ps.setString(3, automovel.getCor());
			ps.setString(4, automovel.getChassi());
			ps.setString(5, automovel.getPlaca());
			ps.setDate(6, new java.sql.Date(automovel.getAno_fabricacao().getTime()));
			ps.setDate(7, new java.sql.Date(automovel.getAno_modelo().getTime()));
			ps.setFloat(8, automovel.getKm());
			ps.setFloat(9, automovel.getValor());
			//ps.setInt(10, automovel.getIdAutomovel());
			ps.execute();
			
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}
	
	public void alterarAutomovel(Automovel automovel) {
		
		String sql = "UPDATE automovel SET nomeMarca = ?, nomeModelo = ?, cor = ?, chassi = ?, placa = ?, anoFab = ?, anoMod = ?, km = ?, valor = ? WHERE idAutomovel = ?";
		try {
			
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, automovel.getNomeMarca());
			ps.setString(2, automovel.getNomeModelo());
			ps.setString(3, automovel.getCor());
			ps.setString(4, automovel.getChassi());
			ps.setString(5, automovel.getPlaca());
			ps.setDate(6, new java.sql.Date(automovel.getAno_fabricacao().getTime()));
			ps.setDate(7, new java.sql.Date(automovel.getAno_modelo().getTime()));
			ps.setFloat(8, automovel.getKm());
			ps.setFloat(9, automovel.getValor());
			ps.setInt(10, automovel.getIdAutomovel());
			ps.execute();
			
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
		
		
	}
	
	public List<Automovel> listarAutomovel(){
		
		List<Automovel> automoveis = new ArrayList<Automovel>();
		String sql = "SELECT * FROM automovel";
		ResultSet a;
		
		try {
			
			PreparedStatement b = c.prepareStatement(sql);
			a = b.executeQuery(sql);
			while (a.next()) {
				Automovel auto = new Automovel();
				auto.setIdAutomovel(a.getInt("idAutomovel"));
				auto.setNomeMarca(a.getString("nomeMarca"));
				auto.setNomeModelo(a.getString("nomeModelo"));
				auto.setCor(a.getString("cor"));
				auto.setAno_fabricacao(a.getDate("anoFab"));
				auto.setAno_modelo(a.getDate("anoMod"));
				auto.setChassi(a.getString("chassi"));
				auto.setPlaca(a.getString("placa"));
				auto.setKm(a.getFloat("km"));
				auto.setValor(a.getFloat("valor"));
				automoveis.add(auto);
			}
			
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		return automoveis;
		
	}
	
	 public Automovel buscarAutomovel(int busca){
		 
		    Automovel auto = new Automovel();
			String sql = "SELECT * FROM automovel WHERE idAutomovel = ?";
			ResultSet a;
			
			try {
				
				PreparedStatement b = c.prepareStatement(sql);
				b.setInt(1, busca);
				a = b.executeQuery();
				while (a.next()) {
					
					auto.setIdAutomovel(a.getInt("idAutomovel"));
					auto.setNomeMarca(a.getString("nomeMarca"));
					auto.setNomeModelo(a.getString("nomeModelo"));
					auto.setCor(a.getString("cor"));
					auto.setAno_fabricacao(a.getDate("anoFab"));
					auto.setAno_modelo(a.getDate("anoMod"));
					auto.setChassi(a.getString("chassi"));
					auto.setPlaca(a.getString("placa"));
					auto.setKm(a.getFloat("km"));
					auto.setValor(a.getFloat("valor"));
					
				}
				
				
			} catch (Exception e) {
				
				System.out.println(e.getMessage());
			}
			return auto;
			
		 
		 
	 }
	 
	 public void excluirAutomovel(int busca){
		 
		 String sql = "DELETE FROM automovel WHERE idAutomovel = ?";
		 
		 try {
			 
			 PreparedStatement b = c.prepareStatement(sql);
			 b.setInt(1, busca);
			 b.execute();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		 
	 }
	 


}
