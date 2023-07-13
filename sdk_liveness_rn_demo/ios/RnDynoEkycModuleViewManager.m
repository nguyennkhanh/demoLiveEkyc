//
//  RnDynoEkycModuleViewManager.m
//  rn_ekyc_demo
//
//  Created by Hungnx on 12/02/2022.
//  Copyright © 2022 Facebook. All rights reserved.
//

#import "React/RCTViewManager.h"

@interface RCT_EXTERN_MODULE(RNDynoEkycModuleViewManager, RCTViewManager)

RCT_EXPORT_VIEW_PROPERTY(color, NSString)
RCT_EXPORT_VIEW_PROPERTY(normal, NSString)
RCT_EXPORT_VIEW_PROPERTY(faceUp, NSString)
RCT_EXPORT_VIEW_PROPERTY(faceDown, NSString)
RCT_EXPORT_VIEW_PROPERTY(faceLeft, NSString)
RCT_EXPORT_VIEW_PROPERTY(faceRight, NSString)
RCT_EXPORT_VIEW_PROPERTY(blink, NSString)
RCT_EXPORT_VIEW_PROPERTY(initString, NSString)
RCT_EXPORT_VIEW_PROPERTY(urlConfig, NSString)
RCT_EXPORT_VIEW_PROPERTY(sessionToken, NSString)
RCT_EXPORT_VIEW_PROPERTY(onSuccess, RCTDirectEventBlock)


@end
