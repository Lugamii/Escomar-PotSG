package me.weebo.barrier;

import com.google.common.collect.Iterables;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.ArrayList;

abstract class BlockFiller {
    @Deprecated
    VisualBlockData generate(Player player, World world, int x, int y, int z) {
        return generate(player, new Location(world, x, y, z));
    }

    abstract VisualBlockData generate(Player paramPlayer, Location paramLocation);

    ArrayList<VisualBlockData> bulkGenerate(Player player, Iterable<Location> locations) {
        ArrayList<VisualBlockData> data = new ArrayList<>(Iterables.size(locations));
        for (Location location : locations) {
            data.add(generate(player, location));
        }
        return data;
    }
}
