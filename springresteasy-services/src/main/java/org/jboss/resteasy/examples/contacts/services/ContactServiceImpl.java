package org.jboss.resteasy.examples.contacts.services;

import org.jboss.resteasy.examples.contacts.core.Contact;
import org.jboss.resteasy.examples.contacts.core.Contacts;
import org.jboss.resteasy.examples.contacts.persistence.ContactDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author <a href="mailto:obrand@yahoo.com">Olivier Brand</a> Jun 28, 2008
 */
// @Path("contactservice")
@Transactional
public class ContactServiceImpl implements ContactService {
	// DAO class used for interacting with the database
	private ContactDao contactDao;

	public ContactServiceImpl() {
		// System.out.println("In Constructor ContactServiceImpl");
	}


	@Override
	public Contacts getAllContacts() {
		Contacts contacts = new Contacts();
		contacts.setContacts(contactDao.findAllContacts());
		return contacts;
	}

	@Override
	public Contact getContactById(Long id) {
		Contact contact = contactDao.findContactById(id);

		return contact;
	}

	@Override
	public Contacts getContactsOfContact(Long id) {
		Contacts contacts = new Contacts();
		contacts.setContacts(contactDao.findContactsOfContact(id));
		return contacts;
	}

	public ContactDao getContactDao() {
		return contactDao;
	}

	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

}
