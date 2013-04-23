/*
 * #%L
 * Support code for the 3D Niche at the Wisconsin Institutes for Discovery.
 * %%
 * Copyright (C) 2012 Board of Regents of the University of Wisconsin-Madison.
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

import imagej.ImageJ;

/**
 * Simple test class for the {@link MODSForm} command.
 * 
 * @author Curtis Rueden
 */
public class Main {

	public static void main(final String... args) {
		final ImageJ ij = new ImageJ();

		// show the UI
		ij.ui().showUI();

		// display the MODS form
		ij.command().run(MODSForm.class);
	}

}
