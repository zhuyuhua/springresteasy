package org.jboss.resteasy.examples.contacts.controller;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.examples.contacts.core.Contact;
import org.jboss.resteasy.examples.contacts.core.Contacts;
import org.jboss.resteasy.examples.contacts.services.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Path("/contacts")
public class ContactController {

	private ContactService contactService;

	@GET
	@Path("/data")
	@Produces(MediaType.APPLICATION_JSON)
	public Contacts getAllContacts() {
		Contacts contacts = contactService.getAllContacts();
		return contacts;
	}

	@GET
	@Path("/data/{id}")
	@Produces("application/xml")
	public Contact getContactById(@PathParam("id") Long id) {
		Contact contact = contactService.getContactById(id);

		return contact;
	}

	@GET
	@Path("/data/{id}/contacts")
	@Produces("application/xml")
	public Contacts getContactsOfContact(@PathParam("id") Long id) {
		Contacts contacts = contactService.getContactsOfContact(id);
		return contacts;
	}

	@GET
	@Path("/view")
	@Produces(MediaType.TEXT_HTML)
	public ModelAndView viewAll() {
		// forward to the "contacts" view, with a request attribute named
		// "contacts" that has all of the existing contacts
		Contacts contacts = contactService.getAllContacts();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("contacts", contacts);
		return new ModelAndView("contacts", model);
	}

	public ContactService getContactService() {
		return contactService;
	}

	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}

}
