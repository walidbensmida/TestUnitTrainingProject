package org.junit.test.mockito;


public class ContactService {
		private ContactDAO contactDAO;

		public ContactService(ContactDAO contactDAO) {
			this.contactDAO = contactDAO;
		}

		public Contact find(long id) {
			return contactDAO.find(id);
		}
	}

