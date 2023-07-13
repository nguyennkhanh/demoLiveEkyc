//
//  RnDynoEkycModuleViewManager.swift
//  rn_ekyc_demo
//
//  Created by Hungnx on 12/02/2022.
//  Copyright © 2022 Facebook. All rights reserved.
//

import Foundation
import HeadPoseFramework

@objc(RNDynoEkycModuleViewManager)
class RNDynoEkycModuleViewManager: RCTViewManager {

  override func view() -> (RNDynoEkycModuleView) {
    return RNDynoEkycModuleView()
  }
  
  override class func moduleName() -> String! {
    return "RNDynoEkycModuleView"
  }
}

class RNDynoEkycModuleView : UIView,ReceiverResultDelegate {
    
    func receiverResult(isSuccess: Bool, filePath: String) {
        self.onSuccess?(["isSuccess":isSuccess,
                         "filePath":filePath])
    }
    
    let customView = DynoEkycView()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setupView()
    }

    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setupView()
    }

    private func setupView(){
        self.addSubview(customView)
        customView.receiverResultDelegate = self
    }
    
    override func layoutSublayers(of layer: CALayer) {
        super.layoutSublayers(of: layer)
        customView.frame = self.bounds
    }

    
    
  @objc var color: String = "" {
    didSet {
      self.backgroundColor = hexStringToUIColor(hexColor: color)
    }
  }
    
    @objc var normal: String = "Noraml"{
        didSet{
            customView.normalString = normal
        }
    }
    
    @objc var faceUp: String = "Face up"{
        didSet{
            customView.faceUpString = faceUp
        }
    }
    
    @objc var faceDown: String = "Face down"{
        didSet{
            customView.faceDownString = faceDown
        }
    }
    
    @objc var faceLeft: String = "Face left"{
        didSet{
            customView.faceLeftString = faceLeft
        }
    }
    
    @objc var faceRight: String = "Face right"{
        didSet{
            customView.faceRightString = faceRight
        }
    }
    
    @objc var blink: String = "Blink"{
        didSet{
            customView.blinkString = blink
        }
    }
  
  @objc var initString: String = "Move face to camera"{
      didSet{
          customView.initString = initString
      }
  }
  
  @objc var sessionToken: String = ""{
      didSet{
        if !sessionToken.isEmpty {
          self.customView.sesstionToken = self.sessionToken
        }
      }
  }
  
  @objc var urlConfig: String = ""{
      didSet{
        if !urlConfig.isEmpty {
          self.customView.urlConfig = self.urlConfig
        }
      }
  }
    
    @objc var onSuccess: RCTDirectEventBlock? = nil

  func hexStringToUIColor(hexColor: String) -> UIColor {
    let stringScanner = Scanner(string: hexColor)

    if(hexColor.hasPrefix("#")) {
      stringScanner.scanLocation = 1
    }
    var color: UInt32 = 0
    stringScanner.scanHexInt32(&color)

    let r = CGFloat(Int(color >> 16) & 0x000000FF)
    let g = CGFloat(Int(color >> 8) & 0x000000FF)
    let b = CGFloat(Int(color) & 0x000000FF)

    return UIColor(red: r / 255.0, green: g / 255.0, blue: b / 255.0, alpha: 1)
  }
}
