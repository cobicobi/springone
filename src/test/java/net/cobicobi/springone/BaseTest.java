package net.cobicobi.springone;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.naming.java.javaURLContextFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BaseTest {
	
	protected static GenericXmlApplicationContext ctx;
	
	@BeforeClass
	public static void setUpClass() throws Exception {
		System.setProperty(Context.INITIAL_CONTEXT_FACTORY, 
				javaURLContextFactory.class.getName());
		System.setProperty(Context.URL_PKG_PREFIXES, "org.apache.naming");
		InitialContext ic = new InitialContext();
 
		ic.createSubcontext("java:");
		ic.createSubcontext("java:env");
		ic.createSubcontext("java:env/jdbc");
		ic.createSubcontext("java:env/jdbc/psql");
 
		ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:servlet-context.xml");
		ctx.refresh();
		
		DataSource ds = ctx.getBean("dataSource", DataSource.class);
 
		ic.bind("java:env/jdbc/psql/springoneDS", ds);
	}
	
	@AfterClass
	public static void tearDownClass() throws Exception {
		InitialContext ic = new InitialContext();
		
		ic.unbind("java:env/jdbc/psql/springoneDS");
	}
}
