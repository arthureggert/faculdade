package br.com.ahe.sd.simpledb;

public class MainSample {

	public static void main(String[] args) {

		String domainName = "Teste";
				
		AmazonSimpleDBSample sample;
		try {
			sample = new AmazonSimpleDBSample();
			
			sample.deleteDomain(domainName);
			
			sample.createDomain(domainName);
			
			sample.printDomains();
			
			sample.createSampleData(domainName);
			
			sample.selectDataSample(domainName , "Category" , "Clothes");
						
			sample.deleteAttribute(domainName);
			
			sample.selectDataSample(domainName , "Category" , "Clothes");
			
			sample.deleteAllAttribute(domainName);
			
			sample.selectDataSample(domainName , "Category" , "Clothes");
			
			sample.deleteItem(domainName);
			
			sample.printDomains();
			
			sample.deleteDomain(domainName);
			
			sample.printDomains();
			
		} catch (AmazonSimpleDBException e) {
			e.printStackTrace();
		}
	}

}
