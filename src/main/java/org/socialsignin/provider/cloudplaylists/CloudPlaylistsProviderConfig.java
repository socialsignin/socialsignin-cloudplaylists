/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.socialsignin.provider.cloudplaylists;

import org.socialsignin.provider.AbstractProviderConfig;
import org.socialsignin.springsocial.security.CloudPlaylistsConnectInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.cloudplaylists.api.CloudPlaylists;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.ConnectInterceptor;

/**
 * @author Michael Lavelle
 */
@Configuration
public class CloudPlaylistsProviderConfig extends
		AbstractProviderConfig<CloudPlaylists> {

	@Autowired(required = false)
	private CloudPlaylistsConnectInterceptor cloudplaylistsConnectInterceptor;

	public CloudPlaylistsProviderConfig() {
		super();
	}

	public CloudPlaylistsProviderConfig(String cloudplaylistsConsumerKey,
			CloudPlaylists authenticatedApi) {
		super(authenticatedApi);
	}

	public CloudPlaylistsProviderConfig(
			ConnectionRepository connectionRepository) {
		super(connectionRepository);
	}

	public CloudPlaylistsProviderConfig(
			ConnectionRepository connectionRepository,
			UsersConnectionRepository usersConnectionRepository) {
		super(connectionRepository, usersConnectionRepository);

	}

	public CloudPlaylistsProviderConfig(String userId,
			UsersConnectionRepository usersConnectionRepository) {
		super(userId, usersConnectionRepository);
	}

	@Override
	protected ConnectInterceptor<CloudPlaylists> getConnectInterceptor() {
		return cloudplaylistsConnectInterceptor;
	}

	@Override
	public Class<CloudPlaylists> getApiClass() {
		return CloudPlaylists.class;
	}

}
