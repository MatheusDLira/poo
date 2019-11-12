package entity;

import java.util.Date;

public class Automovel extends Modelo {
	
	private int idAutomovel;
	private String cor;
	private Date ano_fabricacao;
	private Date ano_modelo;
	private String chassi;
	private String placa;
	private float km;
	private float valor;
	
	
	public int getIdAutomovel() {
		return idAutomovel;
	}
	public void setIdAutomovel(int idAutomovel) {
		this.idAutomovel = idAutomovel;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public Date getAno_fabricacao() {
		return ano_fabricacao;
	}
	public void setAno_fabricacao(Date ano_fabricacao) {
		this.ano_fabricacao = ano_fabricacao;
	}
	public Date getAno_modelo() {
		return ano_modelo;
	}
	public void setAno_modelo(Date ano_modelo) {
		this.ano_modelo = ano_modelo;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public float getKm() {
		return km;
	}
	public void setKm(float km) {
		this.km = km;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	

}
