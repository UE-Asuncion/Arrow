@echo off
"E:\\Program\\AndroidStudio\\Android\\Sdk\\cmake\\3.22.1\\bin\\cmake.exe" ^
  "-HE:\\Program\\AndroidStudio\\Arrow\\opencv\\libcxx_helper" ^
  "-DCMAKE_SYSTEM_NAME=Android" ^
  "-DCMAKE_EXPORT_COMPILE_COMMANDS=ON" ^
  "-DCMAKE_SYSTEM_VERSION=24" ^
  "-DANDROID_PLATFORM=android-24" ^
  "-DANDROID_ABI=x86" ^
  "-DCMAKE_ANDROID_ARCH_ABI=x86" ^
  "-DANDROID_NDK=E:\\Program\\AndroidStudio\\Android\\Sdk\\ndk\\23.1.7779620" ^
  "-DCMAKE_ANDROID_NDK=E:\\Program\\AndroidStudio\\Android\\Sdk\\ndk\\23.1.7779620" ^
  "-DCMAKE_TOOLCHAIN_FILE=E:\\Program\\AndroidStudio\\Android\\Sdk\\ndk\\23.1.7779620\\build\\cmake\\android.toolchain.cmake" ^
  "-DCMAKE_MAKE_PROGRAM=E:\\Program\\AndroidStudio\\Android\\Sdk\\cmake\\3.22.1\\bin\\ninja.exe" ^
  "-DCMAKE_LIBRARY_OUTPUT_DIRECTORY=E:\\Program\\AndroidStudio\\Arrow\\opencv\\build\\intermediates\\cxx\\Debug\\5k4sl1zu\\obj\\x86" ^
  "-DCMAKE_RUNTIME_OUTPUT_DIRECTORY=E:\\Program\\AndroidStudio\\Arrow\\opencv\\build\\intermediates\\cxx\\Debug\\5k4sl1zu\\obj\\x86" ^
  "-DCMAKE_BUILD_TYPE=Debug" ^
  "-BE:\\Program\\AndroidStudio\\Arrow\\opencv\\.cxx\\Debug\\5k4sl1zu\\x86" ^
  -GNinja ^
  "-DANDROID_STL=c++_shared"