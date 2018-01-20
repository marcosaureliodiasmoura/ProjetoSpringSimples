package com.ertheia.model;

public enum StatusPerfil {
	
	
	PERFILPROFISSIONAL("PerfilProfissional"),
	PERFILEMPRESA("PerfilEmpresa");
	
	//Pra salvar em cada Nome cadastrado
		private String nome;
		
		
		StatusPerfil(String nome){
			this.nome=nome;
			
		}
		
		public String getNome()
		{
			return nome;
		}
	

}
