import sbt._

object Dependencies {
  lazy val VersionScala = "2.12.6"
  lazy val VersionPaxExam = "4.11.0"
  lazy val VersionPaxUrl = "2.5.4"
  lazy val VersionLogBack = "1.2.3"
  lazy val VersionFelix = "5.6.10"
  lazy val VersionAkka = "2.5.12"
  lazy val VersionHttp = "10.0.10"

  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"

  lazy val akkaHttp = "com.typesafe.akka" %% "akka-http" % VersionHttp

  lazy val akka = Seq(
    "com.typesafe.akka" %% "akka-stream" % VersionAkka,
    "com.typesafe.akka" %% "akka-osgi" % VersionAkka
  )

  lazy val scalaCompiler = "org.scala-lang" % "scala-compiler" % VersionScala % Test

  lazy val paxExam = Seq(
    "org.ops4j.pax.exam" % "pax-exam-container-forked" % VersionPaxExam % Test,
    "org.ops4j.pax.exam" % "pax-exam-junit4" % VersionPaxExam % Test,
    "org.ops4j.pax.exam" % "pax-exam-link-mvn" % VersionPaxExam % Test,
    "org.ops4j.pax.url" % "pax-url-aether" % VersionPaxUrl % Test,
    "org.ops4j.pax.url" % "pax-url-classpath" % VersionPaxUrl % Test,
    "org.ops4j.pax.url" % "pax-url-link" % VersionPaxUrl % Test,
    "ch.qos.logback" % "logback-core" % VersionLogBack % Test,
    "ch.qos.logback" % "logback-classic" % VersionLogBack % Test,
    "javax.inject" % "javax.inject" % "1" % Test
  )

  lazy val felix = "org.apache.felix" % "org.apache.felix.framework" % VersionFelix % Test
}
