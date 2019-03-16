package org.junit.test.mockito;
public class Contact {
   private long id;
   private String name;
   private String phone;
   public Contact() {
      super();
   }
   public Contact(long id, String firstName,
         String phone) {
      super();
      this.setId(id);
      this.setName(getName());
      this.setPhone(phone);
   }
   public String getName() {  return name;  }
   public void setName(String name) {
      this.name = name;  }
   public String getPhone() {
      return phone; }
   public void setPhone(String phone) {
      this.phone = phone; }
   public long getId() { return id; }
   public void setId(long id) { this.id = id; }
}

class ContactDAO {
	public Contact find(long id) {
		throw new UnsupportedOperationException();
	}

	class ContactService {
		private ContactDAO contactDAO;

		public ContactService(ContactDAO contactDAO) {
			this.contactDAO = contactDAO;
		}

		public Contact find(long id) {
			return contactDAO.find(id);
		}
	}

}