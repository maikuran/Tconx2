package com.sakalti2;

import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class Sakalti2Items {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Sakalti2Main.MODID);

    public static final RegistryObject<Item> OSIUM_ORE = block("osium_ore", Sakalti2Blocks.OSIUM_ORE);
    public static final RegistryObject<Item> IGNITZ_ORE = block("ignitz_ore", Sakalti2Blocks.IGNITZ_ORE);
    public static final RegistryObject<Item> AUROREUM_ORE = block("auroreum_ore", Sakalti2Blocks.AUROREUM_ORE);
    public static final RegistryObject<Item> TRIUM_ORE = block("trium_ore", Sakalti2Blocks.TRIUM_ORE);

    public static final RegistryObject<Item> OSIUM_BLOCK = block("osium_block", Sakalti2Blocks.OSIUM_BLOCK);
    public static final RegistryObject<Item> IGNITZ_BLOCK = block("ignitz_block", Sakalti2Blocks.IGNITZ_BLOCK);
    public static final RegistryObject<Item> AUROREUM_BLOCK = block("auroreum_block", Sakalti2Blocks.AUROREUM_BLOCK);
    public static final RegistryObject<Item> TRIUM_BLOCK = block("trium_block", Sakalti2Blocks.TRIUM_BLOCK);

    public static final RegistryObject<Item> RAW_OSIUM = simple("raw_osium");
    public static final RegistryObject<Item> OSIUM_INGOT = simple("osium_ingot");
    public static final RegistryObject<Item> RAW_IGNITZ = simple("raw_ignitz");
    public static final RegistryObject<Item> IGNITZ_INGOT = simple("ignitz_ingot");
    public static final RegistryObject<Item> RAW_AUROREUM = simple("raw_auroreum");
    public static final RegistryObject<Item> AUROREUM_INGOT = simple("auroreum_ingot");
    public static final RegistryObject<Item> RAW_TRIUM = simple("raw_trium");
    public static final RegistryObject<Item> TRIUM_INGOT = simple("trium_ingot");

    public static final RegistryObject<Item> OSIUM_BUCKET = bucket("osium_bucket", Sakalti2Fluids.OSIUM);
    public static final RegistryObject<Item> IGNITZ_BUCKET = bucket("ignitz_bucket", Sakalti2Fluids.IGNITZ);
    public static final RegistryObject<Item> AUROREUM_BUCKET = bucket("auroreum_bucket", Sakalti2Fluids.AUROREUM);
    public static final RegistryObject<Item> TRIUM_BUCKET = bucket("trium_bucket", Sakalti2Fluids.TRIUM);

    private static RegistryObject<Item> simple(String id) {
        return ITEMS.register(id, () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    }

    private static RegistryObject<Item> block(String id, RegistryObject<Block> block) {
        return ITEMS.register(id, () -> new BlockItem(block.get(),
                new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));
    }

    private static RegistryObject<Item> bucket(String id, RegistryObject<? extends Fluid> fluid) {
        return ITEMS.register(id, () -> new BucketItem(fluid,
                new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(ItemGroup.TAB_MISC)));
    }

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

    private Sakalti2Items() {}
}
