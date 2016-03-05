package br.com.ahe.sd.simpledb;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.simpledb.AmazonSimpleDB;
import com.amazonaws.services.simpledb.AmazonSimpleDBClient;
import com.amazonaws.services.simpledb.model.Attribute;
import com.amazonaws.services.simpledb.model.BatchPutAttributesRequest;
import com.amazonaws.services.simpledb.model.CreateDomainRequest;
import com.amazonaws.services.simpledb.model.DeleteAttributesRequest;
import com.amazonaws.services.simpledb.model.DeleteDomainRequest;
import com.amazonaws.services.simpledb.model.ListDomainsResult;
import com.amazonaws.services.simpledb.model.PutAttributesRequest;
import com.amazonaws.services.simpledb.model.ReplaceableAttribute;
import com.amazonaws.services.simpledb.model.ReplaceableItem;
import com.amazonaws.services.simpledb.model.SelectRequest;


public class AmazonSimpleDBSample {

	private AmazonSimpleDB client;

	public AmazonSimpleDBSample() throws AmazonSimpleDBException {
		this.client = getConnection();
	}

	public AmazonSimpleDBClient getConnection() throws AmazonSimpleDBException {
		try (InputStream resource = new FileInputStream("C:\\Users\\roa\\Dropbox\\Aplicativos\\aws\\aws.properties")){
			PropertiesCredentials cred = new PropertiesCredentials(resource);
			return new AmazonSimpleDBClient(cred);			
		} catch (IOException ioException) {
			throw new AmazonSimpleDBException(ioException.getMessage());
		}
	}

	public void createDomain(String domainName) {
		this.client.createDomain(new CreateDomainRequest(domainName));
	}

	public void deleteDomain(String domainName) {
		this.client.deleteDomain(new DeleteDomainRequest(domainName));
	}

	public ListDomainsResult listDomains() {
		return this.client.listDomains();
	}

	public List<String> getDomainsAsList() {
		return listDomains().getDomainNames();
	}

	public void createSampleData(String domainName) {
		this.client.batchPutAttributes(new BatchPutAttributesRequest(domainName, createSampleData()));
	}

	public void selectDataSample(String domainName , String field , String value) {
		String selectExpression = String.format("select * from `%s` where %s = '%s'", domainName , field , value);
		System.out.println("Selecting: " + selectExpression + "\n");
		SelectRequest selectRequest = new SelectRequest(selectExpression);
		explainSelectResult(selectRequest);
	}


	public void deleteAttribute(String domainName) {
		// Delete values from an attribute
		System.out.println("Deleting Blue attributes in Item_O3.\n");
		Attribute deleteValueAttribute = new Attribute().withName("Color").withValue("Blue");
		this.client.deleteAttributes(new DeleteAttributesRequest(domainName, "Item_03").withAttributes(deleteValueAttribute));
	}

	public void deleteAllAttribute(String domainName) {
		// Delete an attribute and all of its values
		System.out.println("Deleting attribute Year in Item_O3.\n");
		this.client.deleteAttributes(new DeleteAttributesRequest(domainName, "Item_03").withAttributes(new Attribute().withName("Year")));
	}

	public void replaceAttribute(String domainName) {
		// Replace an attribute
		System.out.println("Replacing Size of Item_03 with Medium.\n");
		ReplaceableAttribute replaceableAttribute = new ReplaceableAttribute()
		.withName("Size")
		.withValue("Medium")
		.withReplace(true);
		this.client.putAttributes(new PutAttributesRequest()
		.withDomainName(domainName)
		.withItemName("Item_03")
		.withAttributes(replaceableAttribute));
	}

	public void deleteItem(String domainName) {
		// Delete an item and all of its attributes
		System.out.println("Deleting Item_03.\n");
		this.client.deleteAttributes(new DeleteAttributesRequest(domainName, "Item_03"));
	}

	public void printDomains() {
		for (String domain : getDomainsAsList()) {
			System.out.println(String.format("Domain Name: ==> %s", domain));
		}
	}
	
	private void explainSelectResult(SelectRequest selectRequest) {
		for (com.amazonaws.services.simpledb.model.Item item : this.client.select(selectRequest).getItems()) {
			System.out.println("+Item");
			System.out.println("++Name: " + item.getName());
			for (Attribute attribute : item.getAttributes()) {
				System.out.println("+++Attribute");
				System.out.println("++++Name:  " + attribute.getName());
				System.out.println("++++Value: " + attribute.getValue());
				System.out.println(" ");
			}
			System.out.println("------------------------------------");
		}
	}

	private List<ReplaceableItem> createSampleData() {
		List<ReplaceableItem> sampleData = new ArrayList<>();

//		sampleData.add(new ReplaceableItem().withName("Item_01").withAttributes(
//				new ReplaceableAttribute().withName("Category").withValue("Clothes"),
//				new ReplaceableAttribute().withName("Subcategory").withValue("Sweater"),
//				new ReplaceableAttribute().withName("Name").withValue("Cathair Sweater"),
//				new ReplaceableAttribute().withName("Color").withValue("Siamese"),
//				new ReplaceableAttribute().withName("Size").withValue("Small"),
//				new ReplaceableAttribute().withName("Size").withValue("Medium"),
//				new ReplaceableAttribute().withName("Size").withValue("Large")));
//
//		sampleData.add(new ReplaceableItem().withName("Item_02").withAttributes(
//				new ReplaceableAttribute().withName("Category").withValue("Clothes"),
//				new ReplaceableAttribute().withName("Subcategory").withValue("Pants"),
//				new ReplaceableAttribute().withName("Name").withValue("Designer Jeans"),
//				new ReplaceableAttribute().withName("Color").withValue("Paisley Acid Wash"),
//				new ReplaceableAttribute().withName("Size").withValue("30x32"),
//				new ReplaceableAttribute().withName("Size").withValue("32x32"),
//				new ReplaceableAttribute().withName("Size").withValue("32x34")));

		sampleData.add(new ReplaceableItem().withName("Item_03").withAttributes(
				new ReplaceableAttribute().withName("Category").withValue("Clothes"),
				new ReplaceableAttribute().withName("Subcategory").withValue("Pants"),
				new ReplaceableAttribute().withName("Name").withValue("Sweatpants"),
				new ReplaceableAttribute().withName("Color").withValue("Blue"),
				new ReplaceableAttribute().withName("Color").withValue("Yellow"),
				new ReplaceableAttribute().withName("Color").withValue("Pink"),
				new ReplaceableAttribute().withName("Size").withValue("Large"),
				new ReplaceableAttribute().withName("Year").withValue("2006"),
				new ReplaceableAttribute().withName("Year").withValue("2007")));
//
//		sampleData.add(new ReplaceableItem().withName("Item_04").withAttributes(
//				new ReplaceableAttribute().withName("Category").withValue("Car Parts"),
//				new ReplaceableAttribute().withName("Subcategory").withValue("Engine"),
//				new ReplaceableAttribute().withName("Name").withValue("Turbos"),
//				new ReplaceableAttribute().withName("Make").withValue("Audi"),
//				new ReplaceableAttribute().withName("Model").withValue("S4"),
//				new ReplaceableAttribute().withName("Year").withValue("2000"),
//				new ReplaceableAttribute().withName("Year").withValue("2001"),
//				new ReplaceableAttribute().withName("Year").withValue("2002")));
//
//		sampleData.add(new ReplaceableItem().withName("Item_05").withAttributes(
//				new ReplaceableAttribute().withName("Category").withValue("Car Parts"),
//				new ReplaceableAttribute().withName("Subcategory").withValue("Emissions"),
//				new ReplaceableAttribute().withName("Name").withValue("O2 Sensor"),
//				new ReplaceableAttribute().withName("Make").withValue("Audi"),
//				new ReplaceableAttribute().withName("Model").withValue("S4"),
//				new ReplaceableAttribute().withName("Year").withValue("2000"),
//				new ReplaceableAttribute().withName("Year").withValue("2001"),
//				new ReplaceableAttribute().withName("Year").withValue("2002")));

		return sampleData;
	}
}
