


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
public class CreateContact extends CustomAction<Contact>{

	@Override
	public void action(Contact cont) {
		
		cont.getTextFieldValue("POBOX", "Hyderabad");
		
		// TODO uto-generated method stub
		
	}



	/*public void action(final Contact cont) {

		logDebug("--- In to the Action ---");
		ContactService contactService  = platform.getContactService();
		Person personContact = contactService.newPerson("Test2", "Test2");

		/*To create Company Contact*/
		//Company compContact = contactService.newCompany("TESTCompany");

		/*Address address = personContact.addAddress("ADDR_HOME");
		address.setStreet("IT Park");
		//address.setCity("Hyderabad");
		address.setState("TX");
		address.setPostalCode("560061");*/
		//address.setCountry("COUN_ADAD");*/



	
}
