package NLPProject;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

public class SolrExample {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String url = "http://localhost:8983/solr/core1";
		SolrClient client = new HttpSolrClient(url);
		((HttpSolrClient) client).setParser(new XMLResponseParser());
		String q = "registration";
		SolrQuery query = new SolrQuery();
		query.setQuery(q);
		query.set("hl", true);
		QueryResponse response = client.query(query);
		SolrDocumentList docs = response.getResults();
		System.out.println(response.getHighlighting());
		for (SolrDocument doc : docs){
			System.out.println(doc);
		}
	}

}
