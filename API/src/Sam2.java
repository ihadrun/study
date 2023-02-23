import com.mitratech.teamconnect.enterprise.api.custom.ScheduledCustomAction;
import com.mitratech.teamconnect.enterprise.api.model.Contact;

public class Sam2 extends ScheduledCustomAction{

	@Override
	public void action() {
		// TODO Auto-generated method stub try again
Contact cont=platform.getContactService().read((long) 1006);		
logDebug("fetching contact with pk"+cont.getPrimaryKey());

cont.setTextFieldValue("POBOX","chennai");
cont.setBooleanFieldValue("0001", "POBOX", true);
cont.getTextFieldValue("POBOX");
logDebug("contact pobox is updated");

	}

}
