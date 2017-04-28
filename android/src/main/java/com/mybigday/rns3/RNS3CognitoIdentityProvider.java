package com.mybigday.rns3;

import com.amazonaws.auth.AWSAbstractCognitoDeveloperIdentityProvider;
import com.amazonaws.regions.Regions;

public class RNS3CognitoIdentityProvider extends AWSAbstractCognitoDeveloperIdentityProvider {
    private String developerProvider;

    public RNS3CognitoIdentityProvider(String accountId, String identityPoolId, Regions region) {
        super(accountId, identityPoolId, region);
        developerProvider = "";
    }

    @Override
    public String getProviderName() {
        return developerProvider;
    }

    @Override
    public String refresh() {
        // TODO: provide opportunity for app to refresh the authenticated token/identityId over the JS bridge
        // Override the existing token
        // setToken(null);
        update(identityId, token);
        return token;
    }

    public void setDeveloperAuthenticatedIdentity(String identityId, String token) {
        setIdentityId( identityId );
        setToken( token );
    }

    public void setDeveloperProvider(String developerProvider) {
        this.developerProvider = developerProvider;
    }
}
