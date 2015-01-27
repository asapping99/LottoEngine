package main;

import util.xml.XMLParse;

public class MainLotto {

	protected void initialize() {
		XMLParse.execute();
	}
	
	public void execute() {
		initialize();
	}
	
	protected void run() {
		
	}
	
	/**
	 * @function main
	 * @param args
	 */
	public static void main(String[] args) {
		MainLotto lotto = new MainLotto();
		lotto.execute();
	}

}
