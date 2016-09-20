package org.systemexception.spark.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import spark.ModelAndView;
import spark.TemplateEngine;

import java.io.IOException;
import java.io.StringWriter;

/**
 * @author leo
 * @date 04/11/15 22:05
 */
public class FreeMarkerEngine extends TemplateEngine {

	/**
	 * The FreeMarker configuration
	 */
	private Configuration configuration;

	/**
	 * Creates a FreeMarkerEngine
	 */
	public FreeMarkerEngine() {
		this.configuration = createDefaultConfiguration();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String render(ModelAndView modelAndView) {
		try {
			StringWriter stringWriter = new StringWriter();

			Template template = configuration.getTemplate(modelAndView.getViewName());
			template.process(modelAndView.getModel(), stringWriter);

			return stringWriter.toString();
		} catch (IOException | TemplateException e) {
			throw new IllegalArgumentException(e);
		}
	}

	private Configuration createDefaultConfiguration() {
		Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(FreeMarkerEngine.class, "/freemarker/");
		return configuration;
	}

}
