import com.mitratech.teamconnect.enterprise.api.custom.WizardCustomBlock; import com.mitratech.teamconnect.enterprise.api.model.Contact;
import com.mitratech.teamconnect.enterprise.api.custom.WizardCustomBlock; import com.mitratech.teamconnect.enterprise.api.model.Contact;

public class MyCustomBlock extends WizardCustomBlock<Contact> {

    @Override
    public void initialize(java.util.Map<String, String> pageArgs) {
    // Perform some custom initialization getParameters().addTextParameter("name", "Label", "Default Value");
    
    }
    
  public String getText() {
Contact contact = getRecord(); // Display something on screen
return contact.getDisplayString(); }
} 