package br.com.ahe.dataminig.imagemining;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.neuroph.core.NeuralNetwork;
import org.neuroph.imgrec.ImageRecognitionPlugin;


public class MineracaoDeImagens {

	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void main(String[] args) {
		NeuralNetwork<RegrasDeAprendizado> nnet = NeuralNetwork.load("c:\\Users\\roa\\Desktop\\animals_net.nnet");
		ImageRecognitionPlugin imageRecognition = (ImageRecognitionPlugin)nnet.getPlugin(ImageRecognitionPlugin.class);

		try {
			HashMap<String, Double> output = imageRecognition.recognizeImage(new File("c:\\Users\\roa\\Desktop\\gato2.jpg"));
			//HashMap<String, Double> output = imageRecognition.recognizeImage(new File("c:\\Users\\roa\\Desktop\\coelho2.jpg"));
			//HashMap<String, Double> output = imageRecognition.recognizeImage(new File("c:\\Users\\roa\\Desktop\\peixe3.jpg"));
			System.out.println(output.toString());
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
