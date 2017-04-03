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
        // Override the existing token
        setToken(null);
        // TODO: provide opportunity for app to refresh the authenticated token/identityId over the JS bridge
        update(identityId, token);
        return token;
    }

    public void setDeveloperProvider(String developerProvider) {
        this.developerProvider = developerProvider;
    }

    @Override
    protected void setToken(String token) {
        super.setToken(token);
    }

    @Override
    protected void setIdentityId(String identityId) {
        super.setIdentityId(identityId);
    }
}
