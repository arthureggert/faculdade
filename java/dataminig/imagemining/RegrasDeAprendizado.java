package br.com.ahe.dataminig.imagemining;

import org.neuroph.core.data.DataSet;
import org.neuroph.core.learning.LearningRule;


public class RegrasDeAprendizado extends LearningRule 
{

	private static final long serialVersionUID = 1L;

	private DataSet dataSet;

	@Override
	public void learn(DataSet dataSet) {
		this.setDataSet(dataSet);
	}

	public DataSet getDataSet() {
		return this.dataSet;
	}

	public void setDataSet(DataSet dataSet) {
		this.dataSet = dataSet;
	}

}
