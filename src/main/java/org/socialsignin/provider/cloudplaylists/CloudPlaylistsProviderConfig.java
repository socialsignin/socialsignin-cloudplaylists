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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.cloudplaylists.api.CloudPlaylists;
import org.springframework.social.cloudplaylists.connect.CloudPlaylistsConnectionFactory;
import org.springframework.social.connect.ConnectionFactory;
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

	@Value("${cloudplaylists.consumerKey}")
	private String cloudplaylistsConsumerKey;

	@Value("${cloudplaylists.consumerSecret}")
	private String cloudplaylistsConsumerSecret;

	@Value("${cloudplaylists.oauthTokenUrl}")
	private String cloudplaylistsOAuthTokenUrl;

	@Value("${cloudplaylists.oauthAuthorizeUrl}")
	private String cloudplaylistsOAuthAuthorizeUrl;

	@Value("${cloudplaylists.oauthApiBaseUrl}")
	private String cloudplaylistsOAuthApiBaseUrl;

	public CloudPlaylistsProviderConfig() {
		super();
	}

	public CloudPlaylistsProviderConfig(String cloudplaylistsConsumerKey,
			CloudPlaylists authenticatedApi) {
		super(authenticatedApi);
		this.cloudplaylistsConsumerKey = cloudplaylistsConsumerKey;
	}

	public CloudPlaylistsProviderConfig(String cloudplaylistsOAuthApiBaseUrl,
			String cloudplaylistsConsumerKey,
			String cloudplaylistsConsumerSecret,
			ConnectionRepository connectionRepository,
			ConnectionFactoryRegistry connectionFactoryRegistry) {
		super(connectionRepository, connectionFactoryRegistry);
		this.cloudplaylistsConsumerKey = cloudplaylistsConsumerKey;
		this.cloudplaylistsConsumerSecret = cloudplaylistsConsumerSecret;
		this.cloudplaylistsOAuthApiBaseUrl = cloudplaylistsOAuthApiBaseUrl;

	}

	public CloudPlaylistsProviderConfig(String cloudplaylistsOAuthApiBaseUrl,
			String cloudplaylistsConsumerKey,
			String cloudplaylistsConsumerSecret,
			ConnectionRepository connectionRepository,
			UsersConnectionRepository usersConnectionRepository,
			ConnectionFactoryRegistry connectionFactoryRegistry) {
		super(connectionRepository, usersConnectionRepository,
				connectionFactoryRegistry);
		this.cloudplaylistsConsumerKey = cloudplaylistsConsumerKey;
		this.cloudplaylistsConsumerSecret = cloudplaylistsConsumerSecret;
		this.cloudplaylistsOAuthApiBaseUrl = cloudplaylistsOAuthApiBaseUrl;

	}

	public CloudPlaylistsProviderConfig(String cloudplaylistsOAuthApiBaseUrl,
			String cloudplaylistsConsumerKey,
			String cloudplaylistsConsumerSecret, String userId,
			UsersConnectionRepository usersConnectionRepository,
			ConnectionFactoryRegistry connectionFactoryRegistry) {
		super(userId, usersConnectionRepository, connectionFactoryRegistry);
		this.cloudplaylistsConsumerKey = cloudplaylistsConsumerKey;
		this.cloudplaylistsConsumerSecret = cloudplaylistsConsumerSecret;
		this.cloudplaylistsOAuthApiBaseUrl = cloudplaylistsOAuthApiBaseUrl;
	}

	public void setcloudplaylistsConsumerKey(String cloudplaylistsConsumerKey) {
		this.cloudplaylistsConsumerKey = cloudplaylistsConsumerKey;
	}

	public void setcloudplaylistsConsumerSecret(
			String cloudplaylistsConsumerSecret) {
		this.cloudplaylistsConsumerSecret = cloudplaylistsConsumerSecret;
	}

	public void setcloudplaylistsOAuthTokenUrl(
			String cloudplaylistsOAuthTokenUrl) {
		this.cloudplaylistsOAuthTokenUrl = cloudplaylistsOAuthTokenUrl;
	}

	public void setcloudplaylistsOAuthAuthorizeUrl(
			String cloudplaylistsOAuthAuthorizeUrl) {
		this.cloudplaylistsOAuthAuthorizeUrl = cloudplaylistsOAuthAuthorizeUrl;
	}

	public void setcloudplaylistsOAuthApiBaseUrl(
			String cloudplaylistsOAuthApiBaseUrl) {
		this.cloudplaylistsOAuthApiBaseUrl = cloudplaylistsOAuthApiBaseUrl;
	}

	@Override
	protected ConnectionFactory<CloudPlaylists> createConnectionFactory() {
		return new CloudPlaylistsConnectionFactory(cloudplaylistsConsumerKey,
				cloudplaylistsConsumerSecret, cloudplaylistsOAuthAuthorizeUrl,
				cloudplaylistsOAuthTokenUrl, cloudplaylistsOAuthApiBaseUrl);
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
