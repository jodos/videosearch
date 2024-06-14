package ch.lab4tech.jav09;

import ch.lab4tech.jav09.gui.MainGUI;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JavaVideoSearch {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = createApplicationContext(args);
		context.getBean(MainGUI.class).setVisible(true);
	}

	private static ConfigurableApplicationContext createApplicationContext(String[] args) {
		return new SpringApplicationBuilder(JavaVideoSearch.class).headless(false).run(args);
	}
}
