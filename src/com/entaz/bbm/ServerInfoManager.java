package com.entaz.bbm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ServerInfoManager {	
	public List<ServerInfo> server_list = new ArrayList<ServerInfo>();
	
	public ServerInfoManager() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean Initialize() {
		ServerInfo server_info = null;
		
		server_info = new ServerInfo();
		server_info.server_ip = "210.116.124.205";
		server_info.server_port = 12341;
		server_info.server_name = "테스트1";
		server_list.add(server_info);
		
		server_info = new ServerInfo();
		server_info.server_ip = "210.116.124.205";
		server_info.server_port = 13341;
		server_info.server_name = "테스트2";
		server_list.add(server_info);
		
		server_info = new ServerInfo();
		server_info.server_ip = "210.116.124.205";
		server_info.server_port = 14341;
		server_info.server_name = "테스트3";
		server_list.add(server_info);
		
		return true;
	}

}
