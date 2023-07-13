//
//  ViewController.swift
//  HeadPoseIOSDemo
//
//  Created by Hungnx on 30/08/2022.
//

import UIKit
import HeadPoseFramework
class ViewController: UIViewController, ReceiverResultDelegate {
    
    @IBOutlet weak var ekycContainer:UIView!
    let customview = DynoEkycView()

    override func viewDidLoad() {
        super.viewDidLoad()
        setupView()
        // Do any additional setup after loading the view.
    }
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
    }
    
    override func viewDidLayoutSubviews() {
        super.viewDidLayoutSubviews()
        ekycContainer.translatesAutoresizingMaskIntoConstraints = true
    }

    private func setupView(){
        ekycContainer.addSubview(customview)
        customview.frame = ekycContainer.bounds
        customview.sesstionToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYW0iOiJkMzgzOWE3N2JkZjYiLCJpYXQiOjE2ODkyMjEyMTM3MzAsImV4cCI6MTY4OTIyMTU3MzczMH0.VAZ7ikVlJyzug_y7a4RUy7TTwumQ-pxSuGSf0D30yjc"
        customview.urlConfig = "https://ocp.mascom.vn/burma/sdk/config"
        customview.receiverResultDelegate = self
        customview.initString = "Move face to camera"
        customview.faceUpString = "Face up"
        customview.faceDownString = "Face down"
        customview.faceLeftString = "Face left"
        customview.faceRightString = "Face right"
        customview.blinkString = "Blink"
        customview.normalString = "Look forward"
    }
    
    func receiverResult(isSuccess: Bool, filePath: String) {
        print(filePath)
    }
    
}

