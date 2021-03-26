package com.a105.apiServer.service;

import java.util.List;

import com.a105.apiServer.dto.GameInfoDto;
import com.a105.apiServer.dto.GameLinksDto;
import com.a105.apiServer.dto.GameTagsDto;
import com.a105.apiServer.dto.GamesDto;

public interface GameService {
	public List<GamesDto> gameList() throws Exception;
	public GamesDto gameSearch(String appid) throws Exception;
	
	public List<GameTagsDto> gameTagAll() throws Exception;
	public List<GameTagsDto> gameTagList(String appid) throws Exception;
	public GameTagsDto gameTagSearch(String gametagid) throws Exception;
	
	public List<GameLinksDto> gameLinkAll() throws Exception;
	public List<GameLinksDto> gameLinkList(String appid) throws Exception;
	public GameLinksDto gameLinkSearch(String linkid) throws Exception;
	
	public List<GameInfoDto> gameInfoList() throws Exception;
	public GameInfoDto gameInfoSearch(String appid) throws Exception;
}
