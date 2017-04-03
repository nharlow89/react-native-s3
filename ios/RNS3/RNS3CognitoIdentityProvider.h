#import <Foundation/Foundation.h>
#import <AWSCore/AWSCore.h>


@interface RNS3CognitoIdentityProvider : AWSCognitoCredentialsProviderHelper

@property (nonatomic) NSString *_token;

-(void)setToken:(NSString *)token
                   identityId:(NSString *)identityId;

@end
