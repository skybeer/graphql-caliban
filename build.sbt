val scala3Version = "3.4.2"

lazy val root = project
  .in(file("."))
  .settings(
    name := "caliban-quick",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies ++= Seq(
      "com.github.ghostdogpr" %% "caliban-quick" % "2.5.0",
      "org.scalameta" %% "munit" % "1.0.0" % Test
    )
  )
