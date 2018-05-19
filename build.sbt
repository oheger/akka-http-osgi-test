import Dependencies._

lazy val copyDeps = taskKey[Unit]("Copies all dependencies in a special directory")

lazy val osgiTest = taskKey[Unit]("Executes OSGi integration tests")

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.6",
      version      := "0.0.1-SNAPSHOT"
    )),
    name := "akka-http-osgi-test",
    libraryDependencies ++= Seq(akkaHttp, scalaTest % Test),
    copyDeps := {
      val dependencies = (Runtime / dependencyClasspath).value.files
      val depsTarget = new File(target.value, "dependencies")
      IO.createDirectory(depsTarget)
      IO.copy(dependencies.filter(_.isFile)
        .map(f => (f, new File(depsTarget, f.getName))))
    },
    osgiTest in Test := Def.sequential(
      copyDeps,
      test in Test
    ).value
  )
