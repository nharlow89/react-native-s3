#import "RNS3CognitoIdentityProvider.h"


@implementation RNS3CognitoIdentityProvider

-(void)setToken:(NSString *)token
                   identityId:(NSString *)identityId {
    self._token = token;
    self.identityId = identityId;
}

- (AWSTask <NSString*> *) token {
    if( !self._token ) {
        NSLog(@"FUCK token unauthenticated");
        return [AWSTask taskWithResult:nil];
    }else{
        NSLog(@"FUCK token authenticated");
        return [AWSTask taskWithResult:self._token];
    }
}

/**
 * For now assuming that if _token is not set we are running in un-authenticated mode.
 */
- (AWSTask<NSDictionary<NSString *, NSString *> *> *)logins {
    if( !self._token ) {
        NSLog(@"FUCK logins unauthenticated");
        return [AWSTask taskWithResult:nil];
    }else{
        NSLog(@"FUCK logins authenticated");
        return [super logins];
    }
}

@end
