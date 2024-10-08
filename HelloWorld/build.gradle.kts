buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://chaquo.com/maven")  // Chaquopyのリポジトリを追加
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.4")
        classpath("com.chaquo.python:gradle:15.0.1")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://chaquo.com/maven")  // Chaquopyのリポジトリをプロジェクト全体に追加
    }
}
