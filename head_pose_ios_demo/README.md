## Import Framework

1. Import HeadPoseFramework to your project

## Usage

1. Use "DynoEkycView" like "UIView"

    ```
    let customview = DynoEkycView()
    ekycContainer.addSubview(customview)
    customview.frame = ekycContainer.bounds
    ```
    
    In function viewDidLayoutSubviews, add code
    
    ```
    ekycContainer.translatesAutoresizingMaskIntoConstraints = true
    ```
2. Get sessionToken, url api config from server and update to DynoEkycView
    
    ```
    customview.sesstionToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYW0iOiJlYmQzYmZhMzViYzYiLCJpYXQiOjE2ODg3MTkxMzgyMjIsImV4cCI6MTY4ODcxOTQ5ODIyMn0.vat75Fheazu-uZzIwJs-RuoM2PI6e6Ey4UpeJc74btc"
    customview.urlConfig = "https://dev-gateway.ekyc.dev/burma/sdk/config"
    
4. Set protocol ReceiverResultDelegate to listen event success or fail

    ```
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
            customview.sesstionToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYW0iOiJlYmQzYmZhMzViYzYiLCJpYXQiOjE2ODg3MTkxMzgyMjIsImV4cCI6MTY4ODcxOTQ5ODIyMn0.vat75Fheazu-uZzIwJs-RuoM2PI6e6Ey4UpeJc74btc"
            customview.urlConfig = "https://dev-gateway.ekyc.dev/burma/sdk/config"
            customview.receiverResultDelegate = self
        }
        
        func receiverResult(isSuccess: Bool, filePath: String) {
            
        }
        
    }
    ```
5. Using funtion normalString, faceupString... to update string
    
    ```
    customview.initString = "Move face to camera"
    customview.faceUpString = "Face up"
    customview.faceDownString = "Face down"
    customview.faceLeftString = "Face left"
    customview.faceRightString = "Face right"
    customview.blinkString = "Blink"
    customview.normalString = "Look forward"