package org.socialsignin.provider.cloudplaylists;

import org.socialsignin.provider.AbstractProviderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.cloudplaylists.api.CloudPlaylists;
import org.springframework.social.cloudplaylists.api.impl.CloudPlaylistsTemplate;
import org.springframework.stereotype.Service;

@Service
public class CloudPlaylistsProviderService extends
		AbstractProviderService<CloudPlaylists, CloudPlaylistsProviderConfig> {

	@Value("${cloudplaylists.oauthApiBaseUrl}")
	private String cloudplaylistsOAuthApiBaseUrl;

	public CloudPlaylistsProviderService() {
		super();
	}

	public CloudPlaylistsProviderService(
			CloudPlaylistsProviderConfig providerConfig) {
		super(providerConfig);
	}

	@Override
	public CloudPlaylists getUnauthenticatedApi() {
		return new CloudPlaylistsTemplate(cloudplaylistsOAuthApiBaseUrl);
	}

}
