


import com.mitratech.teamconnect.enterprise.api.custom.CustomAction;
import com.mitratech.teamconnect.enterprise.api.model.Address;
import com.mitratech.teamconnect.enterprise.api.model.Company;
import com.mitratech.teamconnect.enterprise.api.model.Contact;
import com.mitratech.teamconnect.enterprise.api.model.Person;
import com.mitratech.teamconnect.enterprise.api.service.ContactService;



public class CreateContacts extends CustomAction<Contact>{

	@Override
	public void action(Contact cont) {
		
		cont.getTextFieldValue("City", "Delhi");
		
		
		
	}




	}

