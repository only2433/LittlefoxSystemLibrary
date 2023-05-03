# About

리틀팍스에서 개발한 특정 주요 기능들이 포함된 라이브러리를 소개하고자 하는 문서입니다.<br>
이 라이브러리는 Coroutine 모듈, 압축 알고리즘, 핸들러 모듈, 루팅 체크,<br>
마켓 버전 정보 체크 등을 제공합니다.

이 라이브러리는 리틀팍스에서 개발한 앱에서 사용되는 기능들을 추상화하여 제공하며,<br>
안정성과 성능면에서도 높은 품질을 보장합니다. <br>
개발자들이 보다 쉽고 빠르게 앱 개발을 진행할 수 있도록 도와주는 유용한 라이브러리입니다.

감사합니다!

# Getting Started
안드로이드 스튜디오나 gradle을 사용하시는 분께서는<br>
아래 dependencies를 build.gradle에 추가해주시면 바로 사용해보실수 있습니다.
```groovy
implementation 'com.github.only2433:LittlefoxSystemLibrary:2.0.12'
```

# Usage
#### 주요 사용 하는 모듈 
- BaseCoroutine
    ```
    Base Coroutine 모듈은 비동기 프로그래밍을 위해 제공되며, 
    개발자들이 간단하게 비동기 작업을 처리할 수 있도록 도와줍니다.
    extends 해서 사용하면, 결과값 처리는 Async 내부 모듈 처럼 
    처리 가능하여, AsyncTask를 사용하던 분들은 쉽게 Coroutine을 
    사용할 수 있습니다.
    ```
- Compressor
    ```
    Compressor는 파일 압축 및 압축 해제를 위해 사용되며, 간단한 Method를 통해
    압축 및 압축 해제 기능을 쉽게 사용할 수 있습니다. 
    ```  
- WeakReferenceHandler
    ```
    기존 Handler는 메모리가 누적되는 이슈가 있어서 사용하는 데 
    위험요소가 있어 이를 해결하기 위해 만든 Handler 모듈
    ```     
# License
본 프로젝트는 MIT 라이선스를 따릅니다.<br>
자세한 내용은 [LICENSE](https://github.com/only2433/LittlefoxSystemLibrary/blob/master/LICENCE.md) 파일을 참고해주세요
