name := "$name$"
version := "1.0"
scalaVersion := "$scala_version$"

val pekkoVersion = "$pekko_version$"
lazy val pekkoGrpcVersion = "$pekko_grpc_version$"

enablePlugins(PekkoGrpcPlugin)

pekkoGrpcGeneratedLanguages := Seq(PekkoGrpc.Java)

// Run in a separate JVM, to make sure sbt waits until all threads have
// finished before returning.
// If you want to keep the application running while executing other
// sbt tasks, consider https://github.com/spray/sbt-revolver/
fork := true

libraryDependencies ++= Seq(
  "org.apache.pekko" %% "pekko-actor-typed" % pekkoVersion,
  "org.apache.pekko" %% "pekko-discovery" % pekkoVersion,
  "org.apache.pekko" %% "pekko-stream" % pekkoVersion,
  "org.apache.pekko" %% "pekko-pki" % pekkoVersion,

  "ch.qos.logback" % "logback-classic" % "1.3.14",

  "org.apache.pekko" %% "pekko-actor-testkit-typed" % pekkoVersion % Test,
  "org.apache.pekko" %% "pekko-stream-testkit" % pekkoVersion % Test,
  "junit" % "junit" % "4.13.2" % Test,
  "com.novocode" % "junit-interface" % "0.11" % Test
)

testOptions += Tests.Argument(TestFrameworks.JUnit, "-v")
