package vn.dyno.myapplication

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mv.engine.EKYCComponentView
import com.mv.engine.OnReceiverResult


class MainActivity : AppCompatActivity(), OnReceiverResult {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val packageManager = packageManager
        if (!packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            // Camera is not available on this device
            // Handle the error or show a message to the user
            Toast.makeText(this,"Camera is not available on this device", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "Camera  on this device", Toast.LENGTH_SHORT).show()
        }

        findViewById<EKYCComponentView>(R.id.ekyc_view).updateSessionToken(
            "https://ocp.mascom.vn/burma/sdk/config",
            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYW0iOiJkMzgzOWE3N2JkZjYiLCJpYXQiOjE2ODkxNDQ2ODM3NzAsImV4cCI6MTY4OTE0NTA0Mzc3MH0.iNYLZDkPo5Z_6XZi0U4_rlotgE5A-yTjzNUkVzTE84s"
        )
        findViewById<EKYCComponentView>(R.id.ekyc_view).onReceiverResult = this
        findViewById<EKYCComponentView>(R.id.ekyc_view).normalString = "Nhìn thẳng"
        findViewById<EKYCComponentView>(R.id.ekyc_view).faceLeftString = "Nhìn trái"
        findViewById<EKYCComponentView>(R.id.ekyc_view).faceRightString = "Nhìn phải"
        findViewById<EKYCComponentView>(R.id.ekyc_view).faceUpString = "Nhìn lên"
        findViewById<EKYCComponentView>(R.id.ekyc_view).faceDownString = "Nhìn xuống"
        findViewById<EKYCComponentView>(R.id.ekyc_view).initString = "Di chuyển mặt vào camera"

    }

    override fun onReceiverResult(isSuccess: Boolean, filePath: String) {
        Toast.makeText(this, if (isSuccess) "Success" else "Fail", Toast.LENGTH_SHORT).show()
    }
}