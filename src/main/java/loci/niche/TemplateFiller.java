/*
 * #%L
 * Support code for the 3D Niche at the Wisconsin Institutes for Discovery.
 * %%
 * Copyright (C) 2012 - 2014 Board of Regents of the University of
 * Wisconsin-Madison.
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

package loci.niche;

import imagej.module.Module;
import imagej.module.ModuleItem;

import java.io.StringWriter;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

/**
 * TODO
 * 
 * @author Curtis Rueden
 */
public class TemplateFiller {

	private final VelocityEngine engine;

	public TemplateFiller() {
		engine = new VelocityEngine();
		final Properties p = new Properties();
		p.setProperty("resource.loader", "class");
		p.setProperty("class.resource.loader.class",
			"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		engine.init(p);
	}

	/**
	 * Populates the template specified by the given resource, using the input
	 * values from the given module instance.
	 */
	public String fillTemplate(final String resource, final Module module) {
		final VelocityContext context = new VelocityContext();
		for (final ModuleItem<?> input : module.getInfo().inputs()) {
			final String name = input.getName();
			final Object value = input.getValue(module);
			context.put(name, value);
		}

		final Template t = engine.getTemplate(resource);
		final StringWriter writer = new StringWriter();
		t.merge(context, writer);

		return writer.toString();
	}

}
