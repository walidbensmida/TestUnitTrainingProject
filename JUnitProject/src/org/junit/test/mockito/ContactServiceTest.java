package org.junit.test.mockito;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
public class ContactServiceTest {
   @Mock
   private ContactDAO contactDAO;
   @Rule
   public MockitoRule rule = MockitoJUnit.rule();
   @Test
   public void testFind() {
      MockitoAnnotations.initMocks(this);
      ContactService contactService = new
         ContactService(contactDAO);
      contactService.find(1L);
      Mockito.verify(contactDAO).find(1L);
   }
   @Test
   public void initTest() {
      ContactService s = new ContactService(contactDAO);
      Mockito.when(contactDAO.find(1L))
         .thenReturn(testContact());
      Contact c = s.find(1L);
      Assert.assertEquals("AAA", c.getName());
      Assert.assertEquals("9182736450", c.getPhone());
      Mockito.verify(contactDAO).find(1L);
   }
   public Contact testContact() {
      Contact contact = new Contact(1L, "AAA",
         "9182736450");
      return contact;
   }
}