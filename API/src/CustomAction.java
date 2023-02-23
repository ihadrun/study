import com.mitratech.teamconnect.enterprise.api.model.Contact;

public class CustomAction extends com.mitratech.teamconnect.enterprise.api.custom.CustomAction<Contact>{

	@Override
	public void action(Contact cont) {
cont.setTextFieldValue("POBOX", "hyderabad");	
		
		// TODO Auto-generated method stub
		
	}

}
