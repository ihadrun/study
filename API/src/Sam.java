import com.mitratech.teamconnect.enterprise.api.custom.ScheduledCustomAction;
import com.mitratech.teamconnect.enterprise.api.model.Contact;

public class Sam extends ScheduledCustomAction{

	@Override
	public void action() {
		// TODO Auto-generated method stub
Contact cont=platform.getContactService().read((long) 1234);		
	}

}
