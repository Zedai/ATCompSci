package spanish;

import java.io.File;
import java.io.IOException;

public class SpanRunner
{
	public static void main( String args[] ) throws IOException {
		SpanishToEnglish translator = new SpanishToEnglish(new File("H:\\workspace\\ATCompSci\\somemaps\\spanish\\spantoeng.dat"));
		System.out.println(translator.translate("yo quiero una ordenador virus"));
		System.out.println(translator.translate("todas de los muchachos tienen interno memoria"));
		System.out.println(translator.translate("mi pelo es cafe"));
		System.out.println(translator.translate("tu quieres tinta con su papel"));
		System.out.println(translator.translate("rearrancar el ordenador a vacio el pantalla"));
	}
}