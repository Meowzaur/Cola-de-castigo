package mainapp;

import models.ColaDelCastigo;
import models.StringComparator;

public class MainApp {

	public static void main(String[] args) {
		ColaDelCastigo<String> cola = new ColaDelCastigo<String>(new StringComparator());
	}

}
