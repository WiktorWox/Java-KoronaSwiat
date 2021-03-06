package com.korona.koronaswiat.block;

import com.korona.koronaswiat.KoronaSwiat;
import com.korona.koronaswiat.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, KoronaSwiat.MOD_ID);

//    Schemat dodawania bloku, w tym przypadku sejfu (skorzystać w przypadku dodawania bloku):
//    public static final RegistryObject<Block> SAFE = registerBlock("safe",
//            () -> new Block(AbstractBlock.Properties.of(Material.DECORATION)
//                    .harvestLevel(2).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).strength(5f)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
