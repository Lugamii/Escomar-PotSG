package me.weebo.commands.host;

import me.weebo.PotionSG;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.weebo.utilities.C;

public class StartCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] arg) {
        if (s instanceof Player) {
            Player p = (Player) s;
            if (p.hasPermission(PotionSG.PERM_HOST) || p.hasPermission(PotionSG.PERM_MOD) || p.hasPermission(PotionSG.PERM_ACCESS)) {
                if (p.getName().equalsIgnoreCase(PotionSG.getInst().getHost())) {
                    if (PotionSG.getInst().isWaiting()) {
                        if (PotionSG.getInst().getPlayersWaiting().size() > 1) PotionSG.getInst().start();
                        else C.c(p, "&cThere must be at least 2 players joined to start the game.");
                    } else if (PotionSG.getInst().isStarted()) C.c(p, "&e\u26A0 &cThe game has already started!");
                    else C.c(p, "&cThere is no game available.");
                } else C.c(p, "&cYou cannot start the game as you are not the host.");
            } else C.c(p, "&cYou do not have permissions to start events.");
        }
        return true;
    }

}
