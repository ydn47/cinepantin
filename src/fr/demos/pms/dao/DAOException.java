package fr.demos.pms.dao;

public class DAOException extends RuntimeException {
	private static final long serialVersionUID = 1933561632667272154L;
	
	public DAOException(){
		super();
	}
	public DAOException(String mes){
		super(mes);
	}
	
	public DAOException(String mes, Throwable e){ //Throwable est le plus haut type exception
		super(mes, e);
	}
}

