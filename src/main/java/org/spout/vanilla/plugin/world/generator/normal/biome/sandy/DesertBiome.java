/*
 * This file is part of Vanilla.
 *
 * Copyright (c) 2011-2012, Spout LLC <http://www.spout.org/>
 * Vanilla is licensed under the Spout License Version 1.
 *
 * Vanilla is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option)
 * any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the Spout License Version 1.
 *
 * Vanilla is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License for
 * more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the Spout License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://spout.in/licensev1> for the full license, including
 * the MIT license.
 */
package org.spout.vanilla.plugin.world.generator.normal.biome.sandy;

import java.awt.Color;

import org.spout.vanilla.plugin.world.generator.normal.decorator.CactusDecorator;
import org.spout.vanilla.plugin.world.generator.normal.decorator.DeadBushDecorator;
import org.spout.vanilla.plugin.world.generator.normal.decorator.MushroomDecorator;
import org.spout.vanilla.plugin.world.generator.normal.decorator.SandAndClayDecorator;
import org.spout.vanilla.plugin.world.generator.normal.decorator.SugarCaneDecorator;
import org.spout.vanilla.plugin.world.generator.normal.decorator.WellDecorator;

public class DesertBiome extends SandyBiome {
	public DesertBiome(int biomeId) {
		super(biomeId, new SandAndClayDecorator(), new CactusDecorator(),
				new DeadBushDecorator((byte) 8, (byte) 2), new MushroomDecorator(),
				new SugarCaneDecorator((byte) 20, (byte) 3), new WellDecorator());
		setElevation(63, 74);
		setGrassColorMultiplier(new Color(191, 183, 85));
		setFoliageColorMultiplier(new Color(174, 164, 42));
	}

	@Override
	public String getName() {
		return "Desert";
	}
}
