package sampletest;
import java.math.BigDecimal;
import java.util.Calendar;

import com.mitratech.teamconnect.enterprise.api.custom.CustomAction;
import com.mitratech.teamconnect.enterprise.api.model.CalendarDate;
import com.mitratech.teamconnect.enterprise.api.model.Company;
import com.mitratech.teamconnect.enterprise.api.model.Invoice;
import com.mitratech.teamconnect.enterprise.api.model.LineItem;
import com.mitratech.teamconnect.enterprise.api.model.Project;
import com.mitratech.teamconnect.enterprise.api.service.InvoiceService;
import com.mitratech.teamconnect.enterprise.api.service.ProjectService;


/**
 * @author smr
 * Class File used to Create the Invoice
 */

public class CreateInvoice extends CustomAction<Invoice>{

	@Override
	public void action(final Invoice invoice) {
		// vendor is an existing contact
		Company vendor = platform.getContactService().readCompany(10506L);
		Project project =platform.getProjectService().read(2002L);
		InvoiceService service = platform.getInvoiceService();
		Calendar cal =Calendar.getInstance();
		cal.set(2014, 6, 30);
		Invoice createInvoice = (Invoice) service.newInvoice("New-Alps11", vendor, new CalendarDate(cal)).setLookupFieldValue("MatterTypeIN", "MATY_ROOT_DISP").setProjectFieldValue("DisputeMatterIN", project);

		logDebug("----- Completed Creation of Invoice ----");

		BigDecimal originalRate = new BigDecimal("23.00");
		//the line item original quantity.
		BigDecimal originalQuantity = new BigDecimal("500");
		//the line item original discount.
		BigDecimal originalDiscount = new BigDecimal("17.56");
		//the line item original total.
		BigDecimal originalTotal = new BigDecimal("34805743570");
		LineItem newLineItem = service.newExpenseLineItem(createInvoice, new CalendarDate(cal) ,"LNI$_EXPS_OCEX_E100_E101", originalRate,originalQuantity).setOriginalDiscount(originalDiscount).setOriginalTotal(originalTotal);

		LineItem newLineItem1 = service.newFeeLineItem(createInvoice, new CalendarDate(cal), "LNI$_FEES_BILL_BANK_B100", vendor, originalRate,originalQuantity).setOriginalDiscount(originalDiscount).setOriginalTotal(originalTotal);

	}
}
