package net.cobicobi.springone;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BaseSpringTest {

	protected static GenericXmlApplicationContext ctx;
	
	@BeforeClass
	public static void setUpClass() throws Exception {
		ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:servlet-context.xml");
		ctx.refresh();
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
		ctx.close();
	}
}
