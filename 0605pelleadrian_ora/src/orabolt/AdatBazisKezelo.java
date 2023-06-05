package orabolt;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdatBazisKezelo {
	
	private static Connection kapcsolat;
	
	private static PreparedStatement sqlUtasitas;	

	
	private AdatBazisKezelo() {
		
	}
	
	public static Connection csatlakozas() {
		
		Connection kapcsolat = null;
		
		try {
			
			String connectionURL = "jdbc:mysql://localhost:3306/ora?autoReconnect=true&useSSL=false";
			
			kapcsolat = DriverManager.getConnection(connectionURL,"root","Ruander2023");
			
			
		} catch (Exception e) {
			
			System.err.println("A csatlakozás sikertelen, a program bezárul!");
			System.exit(0);
			
		}
		
		return kapcsolat;
		
	}
	
	
	public static void ujOra(Ora ora) {
		
		int osszeg;
		String nev;
		boolean ujra;
		
		do {
			
			ujra = false;
			try (Connection kapcsolat = csatlakozas()){
				
				
				
				String sql = "INSERT INTO orabolt (megnevezes, tipus, ar, vizallo) VALUES (?,?,?,?)";
				PreparedStatement ps = kapcsolat.prepareStatement(sql);
				ps.setString(1, ora.getMegnevezes());
				ps.setString(2, ora.getTipus().toString());
				ps.setInt(3, ora.getAr());
				ps.setBoolean(4, ora.isVizallo());
						
				int eredmeny = ps.executeUpdate();
				// System.out.println(eredmeny+" db sor hozzáadva.");		
	
			} catch (SQLException e) {
				
				System.err.println("DB hiba! "+e.getMessage());
				
			} catch (NumberFormatException e) {
			
				System.err.println("Számformátum hiba!");
				ujra = true;
					
			}
			
			
			
		}while (ujra);
		
	}

	
	
	
	
	

}
