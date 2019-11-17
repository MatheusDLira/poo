package entity;

public class Funcionario extends Pessoa {
	
	private int codigof;
	private String usuario;
	private String senha;
	private float salario;
	private String cargo;
	
	
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public int getCodigo() {
		return codigof;
	}
	public void setCodigo(int codigo) {
		this.codigof = codigo;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	public float calculaSalario(float salario) {
		return this.salario*1;
	}

}
