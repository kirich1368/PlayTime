/*
 * Copyright (C) 2013 Spencer Alderman
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.rogue.playtime.listener;

import com.rogue.playtime.Playtime;
import com.rogue.playtime.runnable.DeathResetRunnable;
import com.rogue.playtime.sql.db.MySQL;
import java.sql.SQLException;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 *
 * @since 1.2
 * @author 1Rogue
 * @version 1.2
 */
public class PlaytimeListener implements Listener {
    
    private final Playtime plugin;
    
    public PlaytimeListener (Playtime p) {
        plugin = p;
    }
    
    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerDeathEvent(PlayerDeathEvent e) {
        Bukkit.getScheduler().runTaskAsynchronously(Playtime.getPlugin(), new DeathResetRunnable(e.getEntity().getName()));
    }
    
}