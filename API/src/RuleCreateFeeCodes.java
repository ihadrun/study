import com.mitratech.teamconnect.entity.TNDocument;
import com.mitratech.teamconnect.entity.WNObjdCategory;
import com.mitratech.teamconnect.entity.YNLitmTaskCode;
import com.mitratech.teamconnect.entity.factory.FNClientSessionManager;
import com.mitratech.teamconnect.entity.factory.FNEntityFactory;
import com.mitratech.teamconnect.entity.factory.GNLitmTaskCodeStore;
import com.mitratech.teamconnect.entity.factory.GNObjdCategoryStore;
import com.mitratech.teamconnect.foundation.TCDefaultActionHandler;
import com.mitratech.teamconnect.foundation.TCLog;
import com.mitratech.teamconnect.mid.HLSearchObject;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.eclipse.persistence.sessions.UnitOfWork;

public class RuleCreateFeeCodes extends TCDefaultActionHandler {
  public void parameterDeclaration() {}
  
  public void action() {
    TNDocument document = getDocumentFile();
    if (document == null) {
      logXML("document not found ");
      return;
    } 
    try {
      OPCPackage opc = OPCPackage.open(new ByteArrayInputStream(document.getContent()));
      logXML("categoryMapFileName : " + document.getName());
      XSSFWorkbook xSSFWorkbook = new XSSFWorkbook(opc);
      importCategoryMap((Workbook)xSSFWorkbook);
    } catch (IOException|org.apache.poi.openxml4j.exceptions.InvalidFormatException e) {
      logXMLError("Exception occurred while reading/writing wb : " + ExceptionUtils.getStackTrace(e));
    } 
  }
  
  private void logXML(String string) {
    TCLog.getXmlLogger().debug(string);
  }
  
  private void logXMLError(String string) {
    TCLog.getXmlLogger().error(string);
  }
  
  private TNDocument getDocumentFile() {
    HLSearchObject docSearch = new HLSearchObject("TDocument", null);
    docSearch.setCriteria("name__EQUALS__STR", "Categories List.xlsx");
    docSearch.search();
    List<TNDocument> doc = docSearch.allObjects();
    if (doc != null && doc.size() > 0)
      return doc.get(0); 
    return null;
  }
  
  private void importCategoryMap(Workbook categoryMapWB) throws IOException {
    logXML("importCategoryMap");
    Sheet categoryMapSheet = categoryMapWB.getSheetAt(0);
    int lastRowNum = categoryMapSheet.getLastRowNum() + 1;
    logXML("lastRowNum+1 : " + lastRowNum);
    CellStyle dataCellStyle = categoryMapWB.createCellStyle();
    CellStyle headerCellStyle = categoryMapWB.createCellStyle();
    Row categoryMapSheetHeaderRow = categoryMapSheet.getRow(0);
    Cell cell2 = categoryMapSheetHeaderRow.createCell(2);
    cell2.setCellStyle(headerCellStyle);
    cell2.setCellValue("Result");
    for (int wbRowCounter = 1; wbRowCounter < lastRowNum; wbRowCounter++) {
      Row dataRow = categoryMapSheet.getRow(wbRowCounter);
      Cell resultCell = dataRow.createCell(3);
      resultCell.setCellStyle(dataCellStyle);
      String categoryName = (dataRow.getCell(0) != null) ? dataRow.getCell(0).getStringCellValue().trim() : "";
      logXML("categoryName : " + categoryName);
      String categoryTreePosition = (dataRow.getCell(1) != null) ? dataRow.getCell(1).getStringCellValue().trim() : "";
      String taskCodeName = (dataRow.getCell(2) != null) ? dataRow.getCell(2).getStringCellValue().trim() : "";
      logXML("categoryTreePosition : " + categoryTreePosition);
      if (categoryName.isEmpty()) {
        resultCell.setCellValue("Category Name column is empty");
        logXMLError("Category Name column is empty");
      } else if (categoryTreePosition.isEmpty()) {
        resultCell.setCellValue("Category Tree Position column is empty");
        logXMLError("Category Tree Position column is empty");
      } else if (categoryTreePosition.indexOf("_") == -1) {
        resultCell.setCellValue("Category must be a child.");
        logXMLError("Category must be a child.");
      } else if (taskCodeName.isEmpty()) {
        resultCell.setCellValue("Task Code shouldn't be empty.");
        logXMLError("Task Code shouldn't be empty.");
      } else {
        String parentCatTP = categoryTreePosition.substring(0, categoryTreePosition.lastIndexOf("_"));
        logXML("parentCatTP : " + parentCatTP);
        String nodeCatTP = categoryTreePosition.substring(categoryTreePosition.lastIndexOf("_") + 1, categoryTreePosition.length());
        logXML("nodeCatTP : " + nodeCatTP);
        WNObjdCategory parentCat = null;
        try {
          parentCat = GNObjdCategoryStore.getItemForTreePosition(parentCatTP);
        } catch (Exception e) {
          resultCell.setCellValue("Parent category with tree position not found: " + parentCatTP);
          logXMLError("Parent category with tree position not found: " + parentCatTP);
        } 
        if (parentCat != null) {
          boolean isActive = parentCat.getIsActive();
          logXML("parentCat isActive : " + isActive);
          if (isActive) {
            try {
              UnitOfWork unitOfWork = FNClientSessionManager.acquireUnitOfWork();
              YNLitmTaskCode taskCode = (YNLitmTaskCode)FNEntityFactory.newEntityInstance("YLitmTaskCode");
              logXML("parentCat display string: " + parentCat.getDisplayString());
              logXML("taskCodeQ: " + taskCode);
              logXML("taskCodeNameQss: " + taskCodeName);
              taskCode = (YNLitmTaskCode)unitOfWork.registerObject(taskCode);
              parentCat = (WNObjdCategory)unitOfWork.registerObject(parentCat);
              taskCode.setDisplayOrder(1);
              taskCode.setLitmFeeCategory(parentCat);
              taskCode.setName(categoryName);
              taskCode.setPartialTreePosition(nodeCatTP);
              taskCode.setTaskCode(taskCodeName);
              GNLitmTaskCodeStore.addTaskCodeEntry(taskCode);
              FNClientSessionManager.commit(unitOfWork);
              resultCell.setCellValue("Imported");
              logXML("Imported");
            } catch (Exception e) {
              logXMLError("Exception occurred while adding category node with full tree position : " + categoryTreePosition + " " + ExceptionUtils.getStackTrace(e));
              resultCell.setCellValue("Exception occurred while adding category node:" + e.getMessage());
            } 
          } else {
            resultCell.setCellValue("Parent category with tree position is inactive: " + parentCatTP);
            logXML("Parent category with tree position is inactive: " + parentCatTP);
          } 
        } else {
          resultCell.setCellValue("Parent category with tree position not found: " + parentCatTP);
          logXML("Parent category with tree position not found: " + parentCatTP);
        } 
      } 
    } 
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    try {
      categoryMapWB.write(bos);
    } finally {
      bos.close();
      categoryMapWB.close();
    } 
    UnitOfWork uow = FNClientSessionManager.acquireUnitOfWork();
    TNDocument doc = (TNDocument)getObject();
    doc.setContent(bos.toByteArray());
    FNClientSessionManager.commit(uow);
    logXML("File updated with result log.");
  }
}
