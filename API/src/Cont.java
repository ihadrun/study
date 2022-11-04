


import com.mitratech.teamconnect.enterprise.api.custom.CustomAction;
import com.mitratech.teamconnect.enterprise.api.model.Address;
import com.mitratech.teamconnect.enterprise.api.model.Company;
import com.mitratech.teamconnect.enterprise.api.model.Contact;
import com.mitratech.teamconnect.enterprise.api.model.Person;
import com.mitratech.teamconnect.enterprise.api.service.ContactService;


/**
 * @author smr
 * Class File used to Create the Person/Company Contact
 */
public class Cont extends CustomAction<Contact>{



	public void action(final Contact cont) {

		logDebug("--- In to the Action ---");
		ContactService contactService  = platform.getContactService();
		Person personContact = contactService.newPerson("Test1", "Test1");

		/*To create Company Contact*/
		//Company compContact = contactService.newCompany("TESTCompany");

		Address address = personContact.addAddress("ADDR_HOME");
		address.setStreet("IT Park");
		address.setCity("Chandigarh");
		address.setState("TX");
		address.setPostalCode("560061");
		//address.setCountry("India");



	}
}
