package jdbc;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JdbcConnection {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		// TODO Auto-generated method stub

		String host = "localhost";

		String port = "3306";

		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/demo", "root", "root");

		Statement s = con.createStatement();

		ResultSet rs = s.executeQuery("select * from credentials where scenario ='lowinterestcard'");

		while (rs.next())

		{
			String path = "D:\\Selenium_drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", path);
			
			WebDriver driver = new FirefoxDriver();

			driver.get("https://login.salesforce.com");

			driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(rs.getString("username"));

			driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(rs.getString("password"));

		}

	}
	/*create table credentials (scenario varchar(20), username varchar(20), password varchar(20));
	insert into credentials values('debitcard', 'BoFA', 'user@34*');
	insert into credentials values('creditcard', 'chase', 'dallas@34*');
	insert into credentials values('travelcard', 'usbank', 'irving@34*');
	insert into credentials values('mastercard', 'barclays', 'plano@34*');
	insert into credentials values('cashrewardscard', 'pnc', 'richardson@34*');
	insert into credentials values('lowinterestcard', 'fifththirdbank', 'frisco@34*');
	
	select * from credentials;*/


}
