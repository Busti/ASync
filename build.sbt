name := "aSync"

val commonSettings = Seq(
  scalaVersion := "2.12.2"
  version := "1.0"
)

lazy val server = project
  .settings(commonSettings)
  .settings({
    name := "async-server"
    val http4s = "0.17.0-M2"
    libraryDependencies ++= Seq(
      "org.http4s"                 %% "http4s-dsl"          % http4s,
      "org.http4s"                 %% "http4s-blaze-server" % http4s,
      "org.http4s"                 %% "http4s-blaze-client" % http4s,

      "org.yaml"                   % "snakeyaml"            % "1.18",
      "org.typelevel"              %% "spire"               % "0.14.1",
      "ch.qos.logback"             % "logback-classic"      % "1.1.7",
      "com.typesafe.scala-logging" %% "scala-logging"       % "3.5.0",
      "com.google.protobuf"        % "protobuf-java"        % "3.2.0",
      "de.sciss"                   %% "scalaosc"            % "1.1.5",

      "org.webjars"                % "jquery"               % "3.2.0"
    )
  })

lazy val scalajs = project
  .enablePlugins(ScalaJSPlugin)
  .settings(commonSettings)

lazy val root = project.in(file(".")).aggregate(server, scalajs)