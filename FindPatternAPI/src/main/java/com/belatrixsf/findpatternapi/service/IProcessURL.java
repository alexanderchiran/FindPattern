package com.belatrixsf.findpatternapi.service;

import java.util.List;

public interface IProcessURL {

	public void processURL(String url, List<String> notsslUrls, String regexr);
}
