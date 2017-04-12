package it.polito.tdp.libretto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.polito.tdp.libretto.model.Esame;

public class EsameDAO {
	
	public Esame find(String codice){
		
		String sql="SELECT codice,titolo,docente,superato,voto, data_superamento "+
				   "FROM esame "+
				   "WHERE codice=?"; // ? = parametro ('"+codice+"'")
		Esame result=null;
		String jdbcURL="jdbc:mysql://localhost/libretto?user=root";
		
		try {
			Connection conn=DriverManager.getConnection(jdbcURL);
			PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1,codice); // il primo ? equivale al codice
			ResultSet res=st.executeQuery();
			if(res.next()){
				Esame ex=new Esame(res.getString("codice"),
								   res.getString("titolo"),
								   res.getString("docente"));
				result=ex;
			}
			else result=null;
			conn.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean create(Esame e){
		String sql="INSERT INTO `libretto`.`esame` (`codice`, `titolo`, `docente`) VALUES (?,?,?)";
		String jdbcURL="jdbc:mysql://localhost/libretto?user=root";
		try {
		Connection conn=DriverManager.getConnection(jdbcURL);
		PreparedStatement st=conn.prepareStatement(sql);
		st.setString(1,e.getCodice());
		st.setString(2,e.getTitolo());
		st.setString(3,e.getDocente());
		
		int result=st.executeUpdate();
		conn.close();
		if(result==1){
			return true;
		}
		else return false;
		}
		
	 catch (SQLException e1) {
		e1.printStackTrace();
		return false;
	}
	}
}


