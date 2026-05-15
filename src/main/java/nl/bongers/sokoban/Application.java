/*
 *     Copyright © 2026 bongers-tech
 *     This file is part of sokoban-reshuffled.
 *
 *     Sokoban-reshuffled is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Sokoban-reshuffled is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Sokoban-reshuffled. If not, see <http://www.gnu.org/licenses/>.
 */
package nl.bongers.sokoban;

import nl.bongers.sokoban.config.Configuration;
import nl.bongers.sokoban.config.ConfigurationContext;
import nl.bongers.sokoban.view.Sokoban;

public class Application {

    public static void main(final String... args) {
        ConfigurationContext.getConfigurations().forEach(Configuration::processConfiguration);
        final Sokoban sokoban = Sokoban.getFrame();
        sokoban.initialize();
    }
}
