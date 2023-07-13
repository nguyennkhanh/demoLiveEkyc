# EKYC SDK

## Import SDK

1. Copy file ekyc.aar to "root_project/app/scr/main/libs/ekyc.aar"
2. implementation files('src/main/libs/ekyc.aar') to "root_project/app/build.gradle"

## Usage

1. Use "com.mv.engine.EKYCComponentView" like "android.View"
   Using in xml

    ```
    <com.mv.engine.EKYCComponentView
        android:id="@+id/ekyc_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
   ```
    
2. Get sessionToken from server and update to EKYCComponentView
3. Set interface OnReceiverResult to listen event success or fail
   Using in Kotlin
    
   ```
    class MainActivity : AppCompatActivity(), OnReceiverResult {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            findViewById<EKYCComponentView>(R.id.ekyc_view).updateSessionToken(
                "https://dev-gateway.ekyc.dev/burma/sdk/config",
                "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYW0iOiJlYmQzYmZhMzViYzYiLCJpYXQiOjE2ODg3MjA5NTI2MDQsImV4cCI6MTY4ODcyMTMxMjYwNH0.WZfEptgv_r-yP5vWpL5u04tL-eSKC1H6MTS06S_dW9I"
            )
            findViewById<EKYCComponentView>(R.id.ekyc_view).onReceiverResult = this
        }

        override fun onReceiverResult(isSuccess: Boolean, filePath: String) {
            Toast.makeText(this, if (isSuccess) "Success" else "Fail", Toast.LENGTH_SHORT).show()
        }
    }
   ```
4. Using function normalString, faceUpString... to update string
   Using in Kotlin

    ```
    findViewById<EKYCComponentView>(R.id.ekyc_view).normalString = "Nhìn thẳng"
        findViewById<EKYCComponentView>(R.id.ekyc_view).faceLeftString = "Nhìn trái"
        findViewById<EKYCComponentView>(R.id.ekyc_view).faceRightString = "Nhìn phải"
        findViewById<EKYCComponentView>(R.id.ekyc_view).faceUpString = "Nhìn lên"
        findViewById<EKYCComponentView>(R.id.ekyc_view).faceDownString = "Nhìn xuống"
        findViewById<EKYCComponentView>(R.id.ekyc_view).initString = "Di chuyển mặt vào camera"
   ```