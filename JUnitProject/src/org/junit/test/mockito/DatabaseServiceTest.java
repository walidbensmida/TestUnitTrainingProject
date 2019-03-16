package org.junit.test.mockito;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.Assert;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class DatabaseServiceTest {
	@InjectMocks
	private DatabaseService service;
	@Mock
	private Connection conn;
	@Mock
	private Statement stmt;

	@Before
	public void initTest() {
		MockitoAnnotations.initMocks(this);
	}

	public void testConnection() throws Exception {
		Mockito.when(conn.createStatement()).thenReturn(stmt);
		Mockito.when(conn.createStatement().executeUpdate(Mockito.anyString())).thenReturn(1);
		int result = service.runQuery("");
		Assert.assertEquals(result, 1);
		Mockito.verify(conn.createStatement(), Mockito.times(1));
	}
}