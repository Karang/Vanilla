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
package org.spout.vanilla.plugin.component.living.hostile;

import java.util.Random;

import com.bulletphysics.collision.shapes.BoxShape;

import org.spout.api.component.impl.SceneComponent;
import org.spout.api.inventory.ItemStack;

import org.spout.vanilla.api.component.Hostile;

import org.spout.vanilla.plugin.VanillaPlugin;
import org.spout.vanilla.plugin.component.inventory.VanillaEntityInventory;
import org.spout.vanilla.plugin.component.living.Living;
import org.spout.vanilla.plugin.component.misc.EntityDrops;
import org.spout.vanilla.plugin.component.misc.EntityPickupItemComponent;
import org.spout.vanilla.plugin.component.misc.Health;
import org.spout.vanilla.plugin.material.VanillaMaterials;
import org.spout.vanilla.plugin.protocol.entity.creature.SkeletonEntityProtocol;

/**
 * A component that identifies the entity as a Skeleton.
 */
public class Skeleton extends Living implements Hostile {
	@Override
	public void onAttached() {
		super.onAttached();
		getOwner().getNetwork().setEntityProtocol(VanillaPlugin.VANILLA_PROTOCOL_ID, new SkeletonEntityProtocol());
		SceneComponent scene = getOwner().getScene();
		EntityDrops dropComponent = getOwner().add(EntityDrops.class);
		getOwner().add(VanillaEntityInventory.class);
		getOwner().add(EntityPickupItemComponent.class);
		Random random = getRandom();
		dropComponent.addDrop(new ItemStack(VanillaMaterials.ARROW, random.nextInt(2)));
		dropComponent.addDrop(new ItemStack(VanillaMaterials.BONE, random.nextInt(2)));
		dropComponent.addXpDrop((short) 5);
		scene.setShape(5f, new BoxShape(1F, 2F, 1F));
		scene.setFriction(1f);
		scene.setRestitution(0f);
		if (getAttachedCount() == 1) {
			getOwner().add(Health.class).setSpawnHealth(20);
		}

		//TODO: There's 2 kind of damage for Skele's : Sword & Bow
	}
}
