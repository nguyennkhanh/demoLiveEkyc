## Cài đặt

### Android

Support minSdkVersion from 21

- Step 1:
Copy file './android/app/src/main/libs/ekyc.aar' to 'your_project/android/src/main/libs/ekyc.aar'
Add kotlin_version to 'your_project/android/build.gradle'
Add code to 'your_project/android/app/build.gradle'
```sh

    implementation files('src/main/libs/ekyc.aar')
    implementation 'com.android.support.constraint:constraint-layout:2.0.4'
    implementation "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
```

- Step 2:
Tạo 2 file DynoEkycViewManager.java và RnDynoEkycModulePackage.java tương tự như trong project demo.
Trong file MainApplication thêm package mới tạo vào

```java
        @Override
        protected List<ReactPackage> getPackages() {
            return Arrays.<ReactPackage>asList(
                    new MainReactPackage(),
                    new RnDynoEkycModulePackage()
            );
        }
```

### iOS
Open xcode
- Step 1:

Kéo thả file HeadPoseFramework.xcframework vào project, chọn copy items if need.
Ở general->Frameworks, Libaries, and Embedded content->HeadPoseFramework.xcframework->Embed switch sang Embed & Sign

-Step 2:

Tạo file swift đặt tên là "RNDynoEkycModuleViewManager", xcode sẽ hỏi có muốn tạo file "...Bridging-Header.h" không thì chọn có tạo.
Ở file "...Bridging-Header.h" vừa tạo copy code từ file "...Bridging-Header.h' ở project demo vào, tương tự copy code từ file swift ở project demo sang file swift vừa tạo.
Tạo file objective-c và copy code từ file "RnDynoEkycModuleViewManager.m".

### React Native

Tạo folder EkycModule tương tự như project demo

## Usage

- Import:
```js
import {RnDynoEkycModuleView} from './EkycModule'
```
- Usage:
```js
<RnDynoEkycModuleView 
        style={{
            width: '100%',
            aspectRatio: 480 / 640}}
        onSuccess={(event) => {
          const { isSuccess, filePath } = event.nativeEvent;
          console.warn(isSuccess);
          console.warn(filePath);
        }}
        faceUp="Ngửa mặt"
        faceDown="Cúi mặt"
        faceLeft="Quay trái"
        faceRight="Quay phải"
        blink="Nháy mắt"
        normal="Nhìn thẳng"
        initString="Đưa khuôn mặt vào trong camera"
        sessionToken="Your sessionToken"
        urlConfig = "Url api get config"/>
```
*Lưu ý: 
- tỉ lệ view phải là 480/640 để camerapreview không bị méo, có thể cho các view khác đè lên
        
- cần permisstion camera trước khi sử dụng module
