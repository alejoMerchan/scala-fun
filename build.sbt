name := "scala-fun"

version := "0.1"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.scalaz"     %% "scalaz-core"          % "7.2.0" withSources() withJavadoc(),
  "org.scalatest"  %% "scalatest"            % "2.2.1" % "test",
  "org.typelevel"  %% "scalaz-contrib-210"   % "0.2",
  "org.mockito"    %  "mockito-core"         % "1.9.5",
  "org.specs2"     %% "specs2-core"          % "3.8.3" % "test",
  "org.typelevel" %% "cats" % "0.9.0",
  "org.typelevel" %% "cats-effect" % "0.3"
)
        