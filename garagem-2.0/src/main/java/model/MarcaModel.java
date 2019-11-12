package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Execute;
import com.mysql.cj.xdevapi.Statement;

import config.SQLConnection;
import entity.Marca;

public class MarcaModel {
	
	Connection c;
	
	
public MarcaModel() {
		this.c = SQLConnection.getConnection();
	}

public void cadastrarMarca(Marca marca) {
	
		String sql = "INSERT INTO marca(nomeMarca, cod) VALUES(?,?)";
		
		try {
			
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, marca.getNomeMarca());
			ps.setString(2, "0");
			ps.execute();
			
			
		}catch(Exception e) {
			
			System.out.println("erro: " + e);
			
		}
		
	}
	
	public void alterarMarca() {
		
		
		
	}
	
	public void listarMarca(){
		
		String sql = "SELECT * FROM marca";
		ResultSet a;
		
		try {
			
			PreparedStatement b = c.prepareStatement(sql);
			a = b.executeQuery(sql);
			while (a.next()) {
				Marca auto = new Marca();
				auto.setNomeMarca(a.getString("nome"));
				
			}
			
			
		} catch (Exception e) {
			
		}
		
	}
	
	 public void buscarMarca(){
		 
		 
		 
		 
	 }
	 
	 public void excluirMarca(){
		 
		 
	 }
	 


}