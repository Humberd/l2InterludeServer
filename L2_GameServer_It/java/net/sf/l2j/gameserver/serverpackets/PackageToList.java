/*
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 *
 * http://www.gnu.org/copyleft/gpl.html
 */
package net.sf.l2j.gameserver.serverpackets;

import java.util.List;

import net.sf.l2j.gameserver.model.actor.instance.L2PcInstance;

/**
 * Format: (c) d[dS]
 * d: list size
 * [
 *   d: char ID
 *   S: char Name
 * ]
 *
 * @author  -Wooden-
 */
public class PackageToList extends L2GameServerPacket
{
	private static final String _S__C2_PACKAGETOLIST = "[S] C2 PackageToList";
	private List<L2PcInstance> _players;
	
	// Lecter : i put a char list here, but i'm unsure these really are Pc. I duno how freight work tho...
	public PackageToList(List<L2PcInstance> players)
	{
		_players = players;
	}

	/**
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#writeImpl()
	 */
	@Override
	protected
	void writeImpl()
	{
		writeC(0xC2);
		writeC(_players.size());
		for(L2PcInstance pc : _players)
		{
			writeD(pc.getObjectId()); // you told me char id, i guess this was object id?
			writeS(pc.getName());
		}
	}

	/**
	 * @see net.sf.l2j.gameserver.BasePacket#getType()
	 */
	@Override
	public String getType()
	{
		return _S__C2_PACKAGETOLIST;
	}
	
}