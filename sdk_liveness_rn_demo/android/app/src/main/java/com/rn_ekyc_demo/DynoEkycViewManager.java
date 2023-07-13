package com.rn_ekyc_demo;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.dyno.ekyc.EKYCComponentView;
import com.dyno.ekyc.OnReceiverResult;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.react.uimanager.events.RCTEventEmitter;

import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class DynoEkycViewManager extends SimpleViewManager<View> {

    @Nonnull
    @Override
    public String getName() {
        return "RNDynoEkycModuleView";
    }

    @Nonnull
    @Override
    protected View createViewInstance(@Nonnull ThemedReactContext reactContext) {
        System.loadLibrary("engine");
        return new MyCustomView(reactContext);
    }

    @ReactProp(name = "normal")
    public void setNormalString(View view, String normal) {
        if (view instanceof MyCustomView) {
            ((MyCustomView) view).updateNormalString(normal);
        }
    }

    @ReactProp(name = "faceUp")
    public void setFaceUpString(View view, String faceUp) {
        if (view instanceof MyCustomView) {
            ((MyCustomView) view).updateFaceUpString(faceUp);
        }
    }

    @ReactProp(name = "faceDown")
    public void setFaceDownString(View view, String faceDown) {
        if (view instanceof MyCustomView) {
            ((MyCustomView) view).updateFaceDownString(faceDown);
        }
    }

    @ReactProp(name = "faceLeft")
    public void setFaceLeftString(View view, String faceLeft) {
        if (view instanceof MyCustomView) {
            ((MyCustomView) view).updateFaceLeftString(faceLeft);
        }
    }

    @ReactProp(name = "faceRight")
    public void setFaceRightString(View view, String faceRight) {
        if (view instanceof MyCustomView) {
            ((MyCustomView) view).updateFaceRightString(faceRight);
        }
    }

    @ReactProp(name = "blink")
    public void setFaceBlinkString(View view, String blink) {
        if (view instanceof MyCustomView) {
            ((MyCustomView) view).updateBlinkString(blink);
        }
    }

    @ReactProp(name = "initString")
    public void setInitString(View view, String initString) {
        if (view instanceof MyCustomView) {
            ((MyCustomView) view).updateInitString(initString);
        }
    }

    @ReactProp(name = "sessionToken")
    public void setSessionToken(View view, String sessionToken) {
        Log.e("'CustomView", "setSessionToken");
        if (view instanceof MyCustomView) {
            ((MyCustomView) view).updateSessionToken(sessionToken);
        }
    }
    
    @ReactProp(name = "urlConfig")
    public void setUrlConfig(View view, String urlConfig) {
        Log.e("'CustomView", "setUrlConfig");
        if (view instanceof MyCustomView) {
            ((MyCustomView) view).updateUrlConfig(urlConfig);
        }
    }

    @Nullable
    @Override
    public Map getExportedCustomBubblingEventTypeConstants() {
        return MapBuilder.builder().put("onSuccess",
                MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onSuccess"))).build();
    }
}

class MyCustomView extends FrameLayout implements OnReceiverResult {

    private EKYCComponentView ekycComponentView;
    private ReactContext reactContext;
    private String sessionToken;
    private String urlConfig;

    MyCustomView(ReactContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
        ekycComponentView = new EKYCComponentView(reactContext.getCurrentActivity() == null ? reactContext : reactContext.getCurrentActivity(),
                null, 0, this);
        initView(reactContext);
    }

    private void initView(Context context) {
        Log.e("'CustomView", "initView");
        this.setBackgroundColor(0xFF00FF00);
        TextView textView = new TextView(context);
        textView.setText("CustomView");
        this.addView(ekycComponentView, new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }

    public void updateNormalString(String normal) {
        ekycComponentView.setNormalString(normal);
    }

    public void updateFaceUpString(String faceUp) {
        ekycComponentView.setFaceUpString(faceUp);
    }

    public void updateFaceDownString(String faceDown) {
        ekycComponentView.setFaceDownString(faceDown);
    }

    public void updateFaceLeftString(String faceLeft) {
        ekycComponentView.setFaceLeftString(faceLeft);
    }

    public void updateFaceRightString(String faceRight) {
        ekycComponentView.setFaceRightString(faceRight);
    }

    public void updateBlinkString(String blink) {
        ekycComponentView.setBlinkString(blink);
    }

    public void updateInitString(String initString) {
        ekycComponentView.updateInitString(initString);
    }

    public void updateUrlConfig(String urlConfig) {
        this.urlConfig = urlConfig;
        if (this.sessionToken != null && this.sessionToken.length() > 0) {
            ekycComponentView.updateSessionToken(urlConfig, sessionToken);
        }
    }

    public void updateSessionToken(String sessionToken) {
        Log.e("'CustomView", "updateSessionToken");
        this.sessionToken = sessionToken;
        if (this.urlConfig != null && this.urlConfig.length() > 0)
            ekycComponentView.updateSessionToken(this.urlConfig, sessionToken);
    }

    @Override
    public void onReceiverResult(boolean isSuccess, String filePath) {
        WritableMap event = Arguments.createMap();
        event.putBoolean("isSuccess", isSuccess);
        event.putString("filePath", filePath);
        reactContext.getJSModule(RCTEventEmitter.class)
                .receiveEvent(getId(), "onSuccess", event);
    }
}
