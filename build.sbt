androidBuild

name := "android-scala-template"
organization := "org.theronin"
version := "0.0.1"

javacOptions in Compile ++= "-source" :: "1.7" :: "-target" :: "1.7" :: Nil

scalaVersion in ThisBuild := "2.11.8"

platformTarget := "android-23"
proguardCache := Nil


resolvers in ThisBuild ++= Seq(
  Resolver.mavenLocal,
  Resolver.jcenterRepo,
  Resolver.bintrayRepo("wire-android", "releases"),
  Resolver.bintrayRepo("wire-android", "snapshots"),
  Resolver.bintrayRepo("wire-android", "third-party")
)

libraryDependencies ++= Seq (
  "com.android.support" % "support-v4" % "23.1.0",
  "com.android.support" % "appcompat-v7" % "23.1.0",
  "com.wire" % "zmessaging-android-macrosupport" % "3.0",
  "com.jakewharton.threetenabp" % "threetenabp" % "1.0.3"
)

fork in Test := true