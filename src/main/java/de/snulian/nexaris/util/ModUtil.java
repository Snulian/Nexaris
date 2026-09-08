package de.snulian.nexaris.util;

import de.snulian.nexaris.Nexaris;
import net.minecraft.resources.ResourceLocation;

public class ModUtil {
    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(Nexaris.MODID, path);
    }
}
