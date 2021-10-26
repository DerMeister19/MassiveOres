package com.dermeister_19.massive_ores.main;

import com.dermeister_19.massive_ores.blocks.blockMassiveCoal;
import com.dermeister_19.massive_ores.blocks.blockMassiveDiamond;
import com.dermeister_19.massive_ores.blocks.blockMassiveEmerald;
import com.dermeister_19.massive_ores.blocks.blockMassiveGold;
import com.dermeister_19.massive_ores.blocks.blockMassiveIron;
import com.dermeister_19.massive_ores.blocks.blockMassiveLapis;
import com.dermeister_19.massive_ores.blocks.blockMassiveQuartz;
import com.dermeister_19.massive_ores.blocks.blockMassiveRedstone;
import com.dermeister_19.massive_ores.generation.MassiveGeneration;
import com.dermeister_19.massive_ores.items.itemNiter;
import com.dermeister_19.massive_ores.items.itemSulfur;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Mod(modid = "mo", name = "Massive Ores", version = "0.1")
public class MassiveOres {

	// Blocks
	// OverWorld
	public static Block massiveCoal;
	public static Block massiveIron;
	public static Block massiveGold;
	public static Block massiveRedstone;
	// TOFIX
	public static Block massiveLapis;
	public static Block massiveDiamond;
	public static Block massiveEmerald;

	// Nether
	public static Block massiveQuartz;
	
	// Items
	public static Item niter;
	public static Item sulfur;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		// Create object
		massiveCoal = new blockMassiveCoal(Material.rock).setBlockName("massiveCoal").setBlockTextureName("mo:coal").setCreativeTab(tabMO);
		massiveIron = new blockMassiveIron(Material.rock).setBlockName("massiveIron").setBlockTextureName("mo:iron").setCreativeTab(tabMO);
		massiveGold = new blockMassiveGold(Material.rock).setBlockName("massiveGold").setBlockTextureName("mo:gold").setCreativeTab(tabMO);
		massiveLapis = new blockMassiveLapis(Material.rock).setBlockName("massiveLapis").setBlockTextureName("mo:lapis");
		massiveRedstone = new blockMassiveRedstone(Material.rock).setBlockName("massiveRedstone").setBlockTextureName("mo:redstone").setCreativeTab(tabMO);
		massiveDiamond = new blockMassiveDiamond(Material.rock).setBlockName("massiveDiamond").setBlockTextureName("mo:diamond").setCreativeTab(tabMO);
		massiveEmerald = new blockMassiveEmerald(Material.rock).setBlockName("massiveEmerald").setBlockTextureName("mo:emerald").setCreativeTab(tabMO);
		massiveQuartz = new blockMassiveQuartz(Material.rock).setBlockName("massiveQuartz").setBlockTextureName("mo:quartz").setCreativeTab(tabMO);
		
		niter = new itemNiter().setUnlocalizedName("niter").setTextureName("mo:niter").setCreativeTab(tabMO);
		sulfur = new itemSulfur().setUnlocalizedName("sulfur").setTextureName("mo:sulfur").setCreativeTab(tabMO);
		
		// Registry
		// Blocks
		GameRegistry.registerBlock(massiveCoal, massiveCoal.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(massiveIron, massiveIron.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(massiveGold, massiveGold.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(massiveLapis, massiveLapis.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(massiveRedstone, massiveRedstone.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(massiveDiamond, massiveDiamond.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(massiveEmerald, massiveEmerald.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(massiveQuartz, massiveQuartz.getUnlocalizedName().substring(5));
		// Items
		GameRegistry.registerItem(niter, niter.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(sulfur, sulfur.getUnlocalizedName().substring(5));
		// World Generator
		GameRegistry.registerWorldGenerator( (IWorldGenerator) new MassiveGeneration(), 0);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		// Smelting recipes
		GameRegistry.addSmelting(MassiveOres.massiveCoal, new ItemStack(Items.coal, 32), 4.0F);	
		GameRegistry.addSmelting(MassiveOres.massiveIron, new ItemStack(Items.iron_ingot, 32), 8.0F);
		GameRegistry.addSmelting(MassiveOres.massiveLapis, new ItemStack(Items.dye, 64, 4), 12.0F);
		GameRegistry.addSmelting(MassiveOres.massiveRedstone, new ItemStack(Items.redstone, 64), 16.0F);
		GameRegistry.addSmelting(MassiveOres.massiveGold, new ItemStack(Items.gold_ingot, 16), 20.0F);
		GameRegistry.addSmelting(MassiveOres.massiveDiamond, new ItemStack(Items.diamond, 8), 24.0F);
		GameRegistry.addSmelting(MassiveOres.massiveEmerald, new ItemStack(Items.emerald, 8), 28.0F);
		GameRegistry.addSmelting(MassiveOres.massiveQuartz, new ItemStack(Items.quartz, 64), 32.0F);
		// Crafting Recipes
		GameRegistry.addRecipe(new ItemStack(niter, 16), new Object[]{ "*# ", "SC ", "   ", '*', Items.coal, '#', Blocks.gravel, 'S', Blocks.sand, 'C', Items.clay_ball });
		GameRegistry.addRecipe(new ItemStack(sulfur, 16), new Object[]{ "FC ", "DR ", "   ", 'F', Items.flint, 'C', Items.coal, 'D', Blocks.dirt, 'R', Items.redstone });
		GameRegistry.addRecipe(new ItemStack(Items.gunpowder, 4), new Object[] { "NS ", "C  ", "   ", 'N', niter, 'S', sulfur, 'C', Items.coal });		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) { }
		
	public static CreativeTabs tabMO = new CreativeTabs("tabMO") {
		@Override
		public Item getTabIconItem() {
			return new ItemStack(massiveDiamond).getItem();
		}
	};
}
